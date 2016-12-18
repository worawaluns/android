package com.example.aigdy.fairybakery.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aigdy.fairybakery.Model.MenuDBModel;
import com.example.aigdy.fairybakery.Model.MyOrderModel;
import com.example.aigdy.fairybakery.Model.OrdersModel;
import com.example.aigdy.fairybakery.R;
import com.example.aigdy.fairybakery.menuDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aigdy on 12/18/2016 AD.
 */

public class MyOrderAdapter extends RecyclerView.Adapter {

    private List<MyOrderModel> dataset;
    private Activity activity;

    public MyOrderAdapter(Activity activity, List<MyOrderModel> dataset) {
        this.dataset = dataset;
        this.activity = activity;
    }

    public void setData(List<MyOrderModel> dataset) {
        this.dataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_my_order_item,parent,false);
        //viewมาจากไหน? ต้องมีตัวมาช่วย
        MyOrderViewHoler current = new MyOrderViewHoler(view);
        return current;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyOrderModel model = dataset.get(position);
        MyOrderAdapter.MyOrderViewHoler cv_holder = (MyOrderAdapter.MyOrderViewHoler) holder;
        cv_holder.TVOrderID.setText(model.getMyOrderID());
        cv_holder.TVOrderStatus.setText(model.getMyOrderStatus());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class MyOrderViewHoler extends RecyclerView.ViewHolder {
        //public ImageView IVImg;
        public TextView TVOrderID;
        public TextView TVOrderStatus;

        public MyOrderViewHoler(View itemView) {
            super(itemView);
            TVOrderID = (TextView)itemView.findViewById(R.id.TVOrderID);
            TVOrderStatus = (TextView)itemView.findViewById(R.id.TVOrderStatus);
        }
    }
}
