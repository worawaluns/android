package com.example.aigdy.fairybakery.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aigdy.fairybakery.Model.MenuDBModel;
import com.example.aigdy.fairybakery.Model.MenuModel;
import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.aigdy.fairybakery.R;
import com.example.aigdy.fairybakery.menuDetailActivity;


/**
 * Created by aigdy on 12/13/2016 AD.
 */

public class MenuAdapter extends RecyclerView.Adapter {

    private List<MenuDBModel> dataset;
    private Activity activity;

    public MenuAdapter(Activity activity, List<MenuDBModel> dataset) {
        this.dataset = dataset;
        this.activity = activity;
    }

    public void setData(List<MenuDBModel> dataset) {
        this.dataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_menu_item,parent,false);
        //viewมาจากไหน? ต้องมีตัวมาช่วย
        MenuViewHoler current = new MenuViewHoler(view);
        return current;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuDBModel model = dataset.get(position);
        MenuViewHoler cv_holder = (MenuViewHoler)holder;
        //cv_holder.IVImg.setImageDrawable(model.getName());
        //cv_holder.tvMenuName.setText(model.getMenuID());
        cv_holder.tvMenuName.setText(model.getMenuName());
        cv_holder.tvMenuCal.setText(model.getMenuCal() + " cal");
        cv_holder.tvMenuPrice.setText("ราคา " + model.getMenuPrice() + " บาท");
        Glide.with(activity).load(model.getMenuPic()).centerCrop().into(cv_holder.ivMenuPic);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class MenuViewHoler extends RecyclerView.ViewHolder {
        //public ImageView IVImg;
        public TextView tvMenuName;
        public TextView tvMenuCal;
        public TextView tvMenuPrice;
        public ImageView ivMenuPic;
        private View btnClick;

        public MenuViewHoler(View itemView) {
            super(itemView);
            //IVImg = (ImageView) itemView.findViewById(R.id.IVImg);
            tvMenuName = (TextView)itemView.findViewById(R.id.tvMenuName);
            tvMenuCal = (TextView)itemView.findViewById(R.id.tvMenuCal);
            tvMenuPrice = (TextView)itemView.findViewById(R.id.tvMenuPrice);
            ivMenuPic = (ImageView) itemView.findViewById(R.id.ivMenuPic);
            btnClick = itemView.findViewById(R.id.btnClick);

            btnClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(activity, menuDetailActivity.class);
                    i.putExtra("id", dataset.get(getAdapterPosition()).getMenuID());
                    i.putExtra("name", dataset.get(getAdapterPosition()).getMenuName());
                    i.putExtra("pic", dataset.get(getAdapterPosition()).getMenuPic());
                    i.putExtra("cal", dataset.get(getAdapterPosition()).getMenuCal());
                    i.putExtra("detail", dataset.get(getAdapterPosition()).getMenuDescription());
                    i.putExtra("price", dataset.get(getAdapterPosition()).getMenuPrice());

                    activity.startActivity(i);
                }
            });
        }
    }
}
