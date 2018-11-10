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

/**
 * A simple {@link Fragment} subclass.
 */
public class LabFragment extends Fragment {

    private ArrayList<DataModel> labDataSet;
    RecyclerView recyclerView;
    private DataAdapter adapter = null;

    public LabFragment() {
        // Required empty public constructor
    }

    public LabFragment(ArrayList<DataModel> labDataSet) {
        this.labDataSet = labDataSet;
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
        View view= inflater.inflate(R.layout.fragment_lab, container, false);
        recyclerView = view.findViewById(R.id.lab_recycle_view);
        initList(labDataSet);
        return  view;
    }
}
