package com.example.bosspal.MainFragments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bosspal.Models.NewDAppModel;
import com.example.bosspal.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewDAppAdapter extends RecyclerView.Adapter<NewDAppAdapter.NewViewHolder>{

    private ArrayList<NewDAppModel> modelArrayList;
    private Context context;

    public NewDAppAdapter(ArrayList<NewDAppModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_newdapp_item,parent,false);
        return new NewDAppAdapter.NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewDAppAdapter.NewViewHolder holder, int position) {

        NewDAppModel model = modelArrayList.get(position);
        holder.pic.setImageResource(model.getPic());
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


    public class NewViewHolder extends RecyclerView.ViewHolder{
        TextView title,desc;
        ImageView pic;

        public NewViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.sampleD_App_desc);
            title = itemView.findViewById(R.id.sampleD_App_title);
            pic = itemView.findViewById(R.id.sampleD_App_image);
        }
    }
}
