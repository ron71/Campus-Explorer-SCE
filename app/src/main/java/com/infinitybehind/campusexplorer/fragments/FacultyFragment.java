package com.infinitybehind.campusexplorer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infinitybehind.campusexplorer.R;
import com.infinitybehind.campusexplorer.adapters.DataAdapter;
import com.infinitybehind.campusexplorer.models.DataModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class FacultyFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<DataModel> classroomDataSet = null;
    private DataAdapter adapter = null;

    public FacultyFragment() {
        // Required empty public constructor
    }

    public FacultyFragment(ArrayList<DataModel> classroomDataSet) {
        this.classroomDataSet = classroomDataSet;
    }

    private void initList(ArrayList<DataModel> dataset){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new DataAdapter(dataset, getActivity());
        recyclerView.setAdapter(adapter);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);
        recyclerView = view.findViewById(R.id.faculty_recycler_view);
        initList(classroomDataSet);
        return  view;


    }

}
