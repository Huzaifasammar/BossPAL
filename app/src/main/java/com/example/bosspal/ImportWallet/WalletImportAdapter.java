package com.example.bosspal.ImportWallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bosspal.Models.CodeModel;
import com.example.bosspal.Models.WalletListModel;
import com.example.bosspal.NewWallet.WalletCodeAdapter;
import com.example.bosspal.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WalletImportAdapter extends RecyclerView.Adapter<WalletImportAdapter.GridviewHolder>{

    private ArrayList<WalletListModel> modelArrayList;
    private Context context;

    public WalletImportAdapter(ArrayList<WalletListModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public WalletImportAdapter.GridviewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_wallet_list,parent,false);
        return new WalletImportAdapter.GridviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull WalletImportAdapter.GridviewHolder holder, int position) {

        WalletListModel model = modelArrayList.get(position);
        holder.imageView.setImageResource(model.getImageView());
        holder.textView.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


    public class GridviewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public GridviewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.list_itemImage);
            textView = itemView.findViewById(R.id.list_itemTex);
        }
    }
}
