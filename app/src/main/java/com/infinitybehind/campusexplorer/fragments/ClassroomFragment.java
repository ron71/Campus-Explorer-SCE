package com.infinitybehind.campusexplorer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.infinitybehind.campusexplorer.R;
import com.infinitybehind.campusexplorer.adapters.DataAdapter;
import com.infinitybehind.campusexplorer.models.DataModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassroomFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<DataModel> classroomDataSet = null;
    private DataAdapter adapter = null;

    public ClassroomFragment() {
        // Required empty public constructor
    }

    public ClassroomFragment(ArrayList<DataModel> classroomDataSet) {
        this.classroomDataSet = classroomDataSet;
    }

    private void initList(){

        adapter = new DataAdapter(classroomDataSet,getActivity());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Toast.makeText(getContext(),"Frag created", Toast.LENGTH_LONG).show();
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_classroom, container, false);
        recyclerView = view.findViewById(R.id.classroom_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initList();
        return  view;
    }

}
