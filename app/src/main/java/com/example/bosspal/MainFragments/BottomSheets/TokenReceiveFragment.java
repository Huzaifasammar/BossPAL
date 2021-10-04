package com.example.bosspal.MainFragments.BottomSheets;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bosspal.MainFragments.Adapters.TokenAdapter;
import com.example.bosspal.Models.ReceiveModel;
import com.example.bosspal.Models.TokenModel;
import com.example.bosspal.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class TokenReceiveFragment extends BottomSheetDialogFragment {
    private View view;
    private ReceiveAdapter adapter;
    private ArrayList<ReceiveModel> list;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_token_receive, container, false);
        mRecyclerView = view.findViewById(R.id.receiveTokenRecycler);

        receiveCoinList();


        return view;
    }
    private void receiveCoinList() {

        ArrayList<ReceiveModel> list = new ArrayList<>();
        list.add(new ReceiveModel(R.drawable.ic_tajiri,"Tajiri","0BTC"));
        list.add(new ReceiveModel(R.drawable.ic_coin_yellow,"BNB","0BTC"));
        list.add(new ReceiveModel(R.drawable.ic_coin_black,"Smart Chain","0BTC"));
        list.add(new ReceiveModel(R.drawable.ic_ethereum,"Ethereum","0BTC"));

        adapter = new ReceiveAdapter(list,TokenReceiveFragment.this.getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }



    // Adapter class
    private class ReceiveAdapter extends RecyclerView.Adapter<ReceiveAdapter.ReceiveViewHolder>{

        ArrayList<ReceiveModel> list;
        Context context;

        public ReceiveAdapter(ArrayList<ReceiveModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @NotNull
        @Override
        public ReceiveViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
             view = LayoutInflater.from(context).inflate(R.layout.sample_token_receive_item,parent,false);
             return new ReceiveViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull TokenReceiveFragment.ReceiveAdapter.ReceiveViewHolder holder, int position) {

            ReceiveModel model = list.get(position);
            holder.name.setText(model.getName());
            holder.price.setText(model.getPrice());
            holder.pic.setImageResource(model.getPic());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        protected class ReceiveViewHolder extends RecyclerView.ViewHolder{
            TextView name,price;
            ImageView pic;

            public ReceiveViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);
                price = itemView.findViewById(R.id.sample_receivePrice);
                name = itemView.findViewById(R.id.sample_receiveName);
                pic = itemView.findViewById(R.id.sample_receiveImg);
            }
        }
    }
}