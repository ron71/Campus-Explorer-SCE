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
public class OthersFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<DataModel> othersDataSet = null;
    private DataAdapter adapter = null;

    public OthersFragment() {
        // Required empty public constructor
    }

    public OthersFragment(ArrayList<DataModel> othersDataSet) {
        this.othersDataSet = othersDataSet;
    }

    private void initList(ArrayList<DataModel> dataset){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new DataAdapter(dataset, getActivity());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_others, container, false);
        recyclerView = view.findViewById(R.id.others_recycle_view);
        initList(othersDataSet);
        return  view;
    }

}
