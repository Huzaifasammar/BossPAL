package com.example.bosspal.MainFragments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bosspal.Models.TokenModel;
import com.example.bosspal.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TokenAdapter extends RecyclerView.Adapter<TokenAdapter.TokenViewHolder>{

    private ArrayList<TokenModel> list;
    private Context context;

    public TokenAdapter(ArrayList<TokenModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public TokenViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_wallet_coin,parent,false);

        return new TokenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TokenAdapter.TokenViewHolder holder, int position) {

        TokenModel model = list.get(position);
        holder.coinName.setText(model.getCoinName());
        holder.rate.setText(model.getRate());
        holder.percent.setText(model.getPercent());
        holder.value.setText(model.getValue());
        holder.pic.setImageResource(model.getPic());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TokenViewHolder extends RecyclerView.ViewHolder{

        ImageView pic;
        TextView coinName,rate,percent, value;
        public TokenViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            coinName = itemView.findViewById(R.id.sample_coin_name);
            rate = itemView.findViewById(R.id.sample_coin_price);
            percent = itemView.findViewById(R.id.sample_coin_profit);
            value = itemView.findViewById(R.id.sample_coin_value);
            pic = itemView.findViewById(R.id.sample_image_coin);
        }
    }
}
