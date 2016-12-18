package com.example.aigdy.fairybakery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aigdy.fairybakery.Adapter.MyOrderAdapter;
import com.example.aigdy.fairybakery.Model.MenuDBModel;
import com.example.aigdy.fairybakery.Model.MyOrderModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends AppCompatActivity {

    //1.Init Data List
    private ArrayList<MyOrderModel> dataset;

    //2.Init Adapter
    private MyOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        MyDBClass myDb = new MyDBClass(this);
        myDb.getWritableDatabase();

        //3.new Data List
        dataset = new ArrayList<MyOrderModel>();
        callMyorderAPIService();

        //4.new Adapter
        adapter = new MyOrderAdapter(this,dataset);

        //5.call RecyclerView
        RecyclerView rcy = (RecyclerView)findViewById(R.id.RCVData);

        //6.Set adapter of RecyclerView
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.setAdapter(adapter);

        MyOrderModel myorder = new MyOrderModel();
    }

    private void callMyorderAPIService() {
        //ServerConnect connector = new ServerConnect();
        //String result = connector.connect("index.php",true);
        //Create ServerConnector object
        ServerConnect connector = new ServerConnect();

        //Connect Web page with Entitymodel object
        String strresults = connector.connect("ShowMyOrderDB.php", true);
        dataset.addAll(parseJSON(strresults));

    }

    private List<MyOrderModel> parseJSON(String strresults) {

        List<MyOrderModel> MyOrderModelss = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strresults);

            for (int i = 0; i < jsonArray.length(); i++) {
                MyOrderModel MyOrderModels = getJSONObject(jsonArray.getJSONObject(i));
                if (MyOrderModelss == null) {
                    MyOrderModelss = new ArrayList<>();
                }
                if (MyOrderModels != null) {
                    MyOrderModelss.add(MyOrderModels);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return MyOrderModelss;
    }

    public MyOrderModel getJSONObject(JSONObject data) {
        try {
            //JSONObject data = new JSONObject(jsonObjstr);
            MyOrderModel MyOrderModels = new MyOrderModel();
            MyOrderModels.setMyOrderID(data.get("OrdersID").toString());
            MyOrderModels.setMYOrderModel(data.get("OrdersStatus").toString());
            return MyOrderModels;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
