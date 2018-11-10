package com.infinitybehind.campusexplorer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.infinitybehind.campusexplorer.MapActivity;
import com.infinitybehind.campusexplorer.R;
import com.infinitybehind.campusexplorer.models.DataModel;

import java.util.ArrayList;
import java.util.HashMap;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

   private ArrayList<DataModel> dataset;
   private Context context;
    HashMap<String , Integer> imageMap;

    public DataAdapter(ArrayList<DataModel> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    public void createImageHashMap(){

        imageMap = new HashMap<String, Integer>();
        imageMap.put("avatar0",R.drawable.avatar0);
        imageMap.put("avatar15",R.drawable.avatar15);
        imageMap.put("avatar23",R.drawable.avatar23);
        imageMap.put("avatar24",R.drawable.avatar24);
        imageMap.put("avatar25",R.drawable.avatar25);
        imageMap.put("avatar26",R.drawable.avatar26);
        imageMap.put("avatar27",R.drawable.avatar27);
        imageMap.put("avatar28",R.drawable.avatar28);
        imageMap.put("avatar29",R.drawable.avatar29);
        imageMap.put("avatar30",R.drawable.avatar30);
        imageMap.put("avatar31",R.drawable.avatar31);
        imageMap.put("avatar32",R.drawable.avatar32);
        imageMap.put("avatar33",R.drawable.avatar33);
        imageMap.put("avatar34",R.drawable.avatar34);
        imageMap.put("avatar35",R.drawable.avatar35);
        imageMap.put("avatar36",R.drawable.avatar36);
        imageMap.put("avatar37",R.drawable.avatar37);
        imageMap.put("avatar38",R.drawable.avatar38);
        imageMap.put("avatar39",R.drawable.avatar39);
        imageMap.put("avatar40",R.drawable.avatar40);
        imageMap.put("avatar41",R.drawable.avatar41);
        imageMap.put("avatar42",R.drawable.avatar42);
        imageMap.put("avatar43",R.drawable.avatar43);
        imageMap.put("avatar50",R.drawable.avatar50);
        imageMap.put("avatar51",R.drawable.avatar51);
        imageMap.put("avatar52",R.drawable.avatar52);
        imageMap.put("avatar54",R.drawable.avatar54);
        imageMap.put("others", R.drawable.others);
        imageMap.put("classroom",R.drawable.classroom);
        imageMap.put("lab", R.drawable.lab);

    }


    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        DataHolder dataHolder = new DataHolder(view);
        createImageHashMap();
        return dataHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final DataHolder holder, int position) {
        TextView place = holder.placeName;
        TextView roomno = holder.roomNo;
        TextView floor = holder.floor;
        ImageView imageView = holder.avatar;

        final DataModel dataItem = dataset.get(position);
        Log.e("LONG : ",""+dataItem.getLongitude());

        place.setText(dataItem.getPlaceName());
        roomno.setText(dataItem.getRoomNo());
        floor.setText(dataItem.getFloor());
        if(imageMap.containsKey(dataItem.getAvatarName())){
            imageView.setImageResource(imageMap.get(dataItem.getAvatarName()));
        }
        else
        {
            imageView.setImageResource(R.drawable.ic_action_name);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Clicked", "PASSED");
                Toast.makeText(holder.itemView.getContext(),"LAT : "+dataItem.getLatitude()+"\n"+"Long : "+dataItem.getLongitude(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(holder.itemView.getContext(), MapActivity.class);
                i.putExtra("title",dataItem.getRoomNo());
                i.putExtra("lat",dataItem.getLatitude());
                i.putExtra("lng",dataItem.getLongitude());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        TextView placeName;
        TextView roomNo;
        TextView floor;
        ImageView avatar;


        public DataHolder(View itemView) {
            super(itemView);
            placeName = itemView.findViewById(R.id.room_no);
            roomNo = itemView.findViewById(R.id.place_name);
            floor = itemView.findViewById(R.id.floor_id);
            avatar = itemView.findViewById(R.id.profile_image);
        }
    }
}
