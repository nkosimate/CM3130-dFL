package com.example.dfl;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link viewVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class viewVideoFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public viewVideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment viewVideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static viewVideoFragment newInstance(String param1, String param2) {
        viewVideoFragment fragment = new viewVideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_video, container, false);

        ImageButton btnUsr = (ImageButton)view.findViewById(R.id.usrBtn);
        btnUsr.setOnClickListener(this);

        LocalDate todaysDate = LocalDate.now();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = todaysDate.format(myFormatObj);

        String date = formattedDate.toString();
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add(date);

        LocalDate [] dates = new LocalDate[30];
        String [] formateddates = new String[30];
        String [] stringdates = new String[30];
        for (int i = 1;i < dates.length;i++){
            dates[i] = todaysDate.plusDays(i);
            formateddates[i] = dates[i].format(myFormatObj);
            stringdates[i] = formateddates[i].toString();
            spinnerArray.add(stringdates[i]);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) view.findViewById(R.id.videoSpinner);
        sItems.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.usrBtn){
            Navigation.findNavController(v).navigate(R.id.action_viewVideoFragment_to_editUserFragment);
        }

    }
}