package com.example.bosspal.Common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bosspal.Models.FilterModel;
import com.example.bosspal.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {

    private ArrayList<FilterModel> list;
    private Context context;

    public FilterAdapter(ArrayList<FilterModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_filter,parent,false);

        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FilterAdapter.FilterViewHolder holder, int position) {

        FilterModel model = list.get(position);

        holder.name.setText(model.getName());
        holder.pic.setImageResource(model.getPic());
        if (model.getOnSwitch().equals("on")){
            holder.onSwitch.setChecked(true);
        }else {
            holder.onSwitch.setChecked(false);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FilterViewHolder extends RecyclerView.ViewHolder{

        ImageView pic;
        TextView name,on;
        Switch onSwitch;

        public FilterViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.sample_filter_img);
            name = itemView.findViewById(R.id.sampleFilterName);
            onSwitch = itemView.findViewById(R.id.sample_filterSwitch);
        }
    }
}
