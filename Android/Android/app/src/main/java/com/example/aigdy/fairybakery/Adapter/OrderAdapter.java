package com.example.aigdy.fairybakery.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aigdy.fairybakery.Model.MenuDBModel;
import com.example.aigdy.fairybakery.Model.OrdersModel;
import com.example.aigdy.fairybakery.MyDBClass;
import com.example.aigdy.fairybakery.R;
import com.example.aigdy.fairybakery.ShoppingCartActivity;
import com.example.aigdy.fairybakery.menuDetailActivity;

import java.util.List;


/**
 * Created by aigdy on 12/13/2016 AD.
 */

public class OrderAdapter extends RecyclerView.Adapter {

    private List<OrdersModel> dataset;
    private Activity activity;
    MyDBClass myDb;

    public OrderAdapter(Activity activity, List<OrdersModel> dataset) {
        this.dataset = dataset;
        this.activity = activity;
        myDb = new MyDBClass(activity);
    }

    public void setData(List<OrdersModel> dataset) {
        this.dataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_order_item, parent, false);
        //viewมาจากไหน? ต้องมีตัวมาช่วย
        MenuViewHoler current = new MenuViewHoler(view);
        return current;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        OrdersModel model = dataset.get(position);
        MenuViewHoler cv_holder = (MenuViewHoler) holder;
        //cv_holder.IVImg.setImageDrawable(model.getName());
        //cv_holder.tvMenuName.setText(model.getMenuID());
        cv_holder.TVNamemenucart.setText(model.getMenuName());
        cv_holder.TVnumberCount.setText(model.getMenuCount());
        cv_holder.TVCalAll.setText((Integer.parseInt(model.getMenuCal()) * Integer.parseInt(model.getMenuCount()) ) + " Cal");
        cv_holder.TVPriceAll.setText("ราคา : " + (Integer.parseInt(model.getMenuPrice()) * Integer.parseInt(model.getMenuCount()) ) + " บาท");
        Glide.with(activity).load(model.getMenuPic()).centerCrop().into(cv_holder.IMVpiccart);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


    class MenuViewHoler extends RecyclerView.ViewHolder {
        //public ImageView IVImg;
        public ImageView IMVpiccart;
        public TextView TVNamemenucart;
        public TextView TVDeleteCart;
        public TextView TVnumberCount;
        public TextView TVSumCart;
        public TextView TVPriceAll;
        public TextView TVCalAll;
        public TextView BTNDelete;

        private View tvDown;
        private View tvUp;

        public MenuViewHoler(View itemView) {
            super(itemView);
            //IVImg = (ImageView) itemView.findViewById(R.id.IVImg);
            IMVpiccart = (ImageView) itemView.findViewById(R.id.IMVpiccart);
            TVNamemenucart = (TextView) itemView.findViewById(R.id.TVNamemenucart);
            tvDown = (TextView) itemView.findViewById(R.id.tvDown);
            TVnumberCount = (TextView) itemView.findViewById(R.id.TVnumberCount);
            tvUp = (TextView) itemView.findViewById(R.id.tvUp);
            TVPriceAll = (TextView) itemView.findViewById(R.id.TVPriceAll);
            TVCalAll = (TextView) itemView.findViewById(R.id.TVCalAll);
            BTNDelete = (TextView) itemView.findViewById(R.id.BTNDelete);

            tvDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrdersModel ordersModel = dataset.get(getAdapterPosition());

                    if(ordersModel.getMenuCount().equalsIgnoreCase("1"))
                        return;

                    String count = String.valueOf(Integer.parseInt(ordersModel.getMenuCount()) - 1);
                    ordersModel.setMenuCount(count);
                    myDb.UpdateData(ordersModel.getMenuID(), count);

                    notifyDataSetChanged();

                    ShoppingCartActivity a = (ShoppingCartActivity) activity;
                    a.updateTotalPrice();
                    a.updateTotalCal();
                }
            });

            tvUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrdersModel ordersModel = dataset.get(getAdapterPosition());

                    String count = String.valueOf(Integer.parseInt(ordersModel.getMenuCount()) + 1);
                    ordersModel.setMenuCount(count);
                    myDb.UpdateData(ordersModel.getMenuID(), count);

                    notifyDataSetChanged();

                    ShoppingCartActivity a = (ShoppingCartActivity) activity;
                    a.updateTotalPrice();
                    a.updateTotalCal();
                }
            });

            BTNDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDb.DeleteData(dataset.get(getAdapterPosition()).getMenuID());
                    dataset.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });

//            btnClick.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(activity, menuDetailActivity.class);
//                    i.putExtra("id", dataset.get(getAdapterPosition()).getMenuID());
//                    i.putExtra("name", dataset.get(getAdapterPosition()).getMenuName());
//                    i.putExtra("pic", dataset.get(getAdapterPosition()).getMenuPic());
//                    i.putExtra("cal", dataset.get(getAdapterPosition()).getMenuCal());
//                    i.putExtra("detail", dataset.get(getAdapterPosition()).getMenuDescription());
//                    i.putExtra("price", dataset.get(getAdapterPosition()).getMenuPrice());
//
//                    activity.startActivity(i);
//                }
//            });
        }
    }
}
