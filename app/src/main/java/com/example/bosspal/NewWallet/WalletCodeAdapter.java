package com.example.bosspal.NewWallet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bosspal.Models.CodeModel;
import com.example.bosspal.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WalletCodeAdapter extends RecyclerView.Adapter<WalletCodeAdapter.GridviewHolder>{

    private ArrayList<CodeModel> modelArrayList;
    private Context context;

    public WalletCodeAdapter(ArrayList<CodeModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public GridviewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recovery_code,parent,false);
        return new GridviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull WalletCodeAdapter.GridviewHolder holder, int position) {

        CodeModel model = modelArrayList.get(position);
        holder.textView.setText(model.getCode());
        holder.number.setText(Integer.toString(model.getItem()));
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


    public class GridviewHolder extends RecyclerView.ViewHolder{
        TextView textView,number;

        public GridviewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.position);
            textView = itemView.findViewById(R.id.item_code);
        }
    }
}
