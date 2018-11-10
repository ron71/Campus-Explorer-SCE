package com.infinitybehind.campusexplorer.adapters;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;

import com.infinitybehind.campusexplorer.fragments.ClassroomFragment;
import com.infinitybehind.campusexplorer.fragments.FacultyFragment;
import com.infinitybehind.campusexplorer.fragments.LabFragment;
import com.infinitybehind.campusexplorer.fragments.OthersFragment;
import com.infinitybehind.campusexplorer.models.DataModel;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;
    private ArrayList<DataModel> classroomList = null;
    private ArrayList<DataModel> labList = null;
    private ArrayList<DataModel> othersList = null;
    private ArrayList<DataModel> facultyList = null;


    public PagerAdapter(FragmentManager fm, int noOfTabs, ArrayList<DataModel> classroomDataSet, ArrayList<DataModel> labDataset, ArrayList<DataModel> othersDataset, ArrayList<DataModel> facultyDataset) {
        super(fm);
        this.mNoOfTabs = noOfTabs;
        this.classroomList = classroomDataSet;
        this.labList = labDataset;
        this.othersList = othersDataset;
        this.facultyList = facultyDataset;


    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:{

                ClassroomFragment tab2 = new ClassroomFragment(classroomList);
                return tab2;

            }
            case 1:{

                LabFragment tab1 = new LabFragment(labList);
                return tab1;
            }
            case 2:{
                FacultyFragment tab3 = new FacultyFragment(facultyList);
                return tab3;
            }
            case 3:{
                OthersFragment tab4 = new OthersFragment(othersList);
                return tab4;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
