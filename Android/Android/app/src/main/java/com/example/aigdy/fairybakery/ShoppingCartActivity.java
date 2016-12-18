package com.example.aigdy.fairybakery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.aigdy.fairybakery.Adapter.OrderAdapter;
import com.example.aigdy.fairybakery.Model.EntityModel;
import com.example.aigdy.fairybakery.Model.OrdersModel;

import java.util.Arrays;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {

    private static final String TAG = ShoppingCartActivity.class.getSimpleName();

    final MyDBClass myDb = new MyDBClass(this);
    private List<OrdersModel> dataset;

    private LinearLayoutManager mLayoutManager;

    //2.Init Adapter
    private OrderAdapter adapter;

    private TextView BTNPriceCart;
    private TextView BTNCalCart;

    private View btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        dataset = myDb.SelectAllData();

        //4.new Adapter
        adapter = new OrderAdapter(this, dataset);

        //5.call RecyclerView
        RecyclerView rcy = (RecyclerView) findViewById(R.id.RCVData);
        mLayoutManager = new LinearLayoutManager(ShoppingCartActivity.this);
        rcy.setLayoutManager(mLayoutManager);
        rcy.setAdapter(adapter);

        BTNPriceCart = (TextView) findViewById(R.id.BTNPriceCart);
        BTNCalCart = (TextView) findViewById(R.id.BTNCalCart);
        updateTotalPrice();
        updateTotalCal();

        btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EntityModel entity = new EntityModel();
                String ids[] = new String[dataset.size()];
                String names[] = new String[dataset.size()];
                String amounts[] = new String[dataset.size()];
                String totals[] = new String[dataset.size()];
                String prices[] = new String[dataset.size()];

                for (int i = 0; i < dataset.size(); i++) {
                    ids[i] = dataset.get(i).getMenuID();
                    names[i] = dataset.get(i).getMenuName();
                    amounts[i] = dataset.get(i).getMenuCount();
                    prices[i] = dataset.get(i).getMenuPrice();
                    totals[i] = String.valueOf(Integer.parseInt(dataset.get(i).getMenuPrice()) * Integer.parseInt(dataset.get(i).getMenuCount()));

//                    entity.getValues().put("ids[]", dataset.get(i).getMenuID());
//                    entity.getValues().put("names[]", dataset.get(i).getMenuName());
//                    entity.getValues().put("amounts[]", dataset.get(i).getMenuCount());
//                    entity.getValues().put("totals[]", String.valueOf(Integer.parseInt(dataset.get(i).getMenuPrice()) * Integer.parseInt(dataset.get(i).getMenuCount())));
                }

                //Assign Data to EntityModel object

                Log.v(TAG, "ids = " + Arrays.toString(ids).replace("[", "").replace("]", ""));

                entity.getValues().put("ids", Arrays.toString(ids).replace("[", "").replace("]", "").replace(" ", ""));
                entity.getValues().put("names", Arrays.toString(names).replace("[", "").replace("]", "").replace(" ", ""));
                entity.getValues().put("prices", Arrays.toString(prices).replace("[", "").replace("]", "").replace(" ", ""));
                entity.getValues().put("amounts", Arrays.toString(amounts).replace("[", "").replace("]", "").replace(" ", ""));
                entity.getValues().put("totals", Arrays.toString(totals).replace("[", "").replace("]", "").replace(" ", ""));
                entity.getValues().put("customerId", myDb.getCustomerId());
                entity.getValues().put("orderTotal", getTotalPrice());


                //Create ServerConnector object
                ServerConnect connector = new ServerConnect();

                //Connect Web page with Entitymodel object
                String strresult = connector.connect("save_order.php", true, entity);
                Log.v(TAG, "strresult = " + strresult);

                myDb.DeleteDataAll();

                Intent i = new Intent(ShoppingCartActivity.this, ConfirmActivity.class);
                startActivity(i);
            }
        });
    }

    public void updateTotalPrice() {
        BTNPriceCart.setText(getTotalPrice());
    }

    public void updateTotalCal() {
        BTNCalCart.setText(getTotalCal());
    }


    private String getTotalPrice() {
        int total = 0;
        for (OrdersModel ordersModel : dataset) {
            total += Integer.parseInt(ordersModel.getMenuPrice()) * Integer.parseInt(ordersModel.getMenuCount());
        }

        return String.valueOf(total);
    }

    private String getTotalCal() {
        int total = 0;
        for (OrdersModel ordersModel : dataset) {
            total += Integer.parseInt(ordersModel.getMenuCal()) * Integer.parseInt(ordersModel.getMenuCount());
        }

        return String.valueOf(total);
    }

}
