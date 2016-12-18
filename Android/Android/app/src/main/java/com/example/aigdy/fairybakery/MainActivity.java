package com.example.aigdy.fairybakery;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aigdy.fairybakery.Adapter.MenuAdapter;
import com.example.aigdy.fairybakery.Model.CustomerModel;
import com.example.aigdy.fairybakery.Model.MenuDBModel;
import com.example.aigdy.fairybakery.Model.MenuModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    //1.Init Data List
    private List<MenuDBModel> datasetMoretoLess;
    private List<MenuDBModel> datasetLesstoMore;

    private GridLayoutManager mLayoutManager;

    //2.Init Adapter
    private MenuAdapter adapter;

    private Button calDown;
    private Button calUp;
    private View btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBClass myDb = new MyDBClass(this);

        myDb.getWritableDatabase(); // First method

        //myDb.DeleteDataAll();

        //3.new Data List
        datasetLesstoMore = new ArrayList<>();
        datasetMoretoLess = new ArrayList<>();

        callMenuLesstoMoreAPIService();
        callMenuMoretoLessAPIService();

        //4.new Adapter
        adapter = new MenuAdapter(this, datasetLesstoMore);

        //5.call RecyclerView
        RecyclerView rcy = (RecyclerView) findViewById(R.id.RCVData);
        mLayoutManager = new GridLayoutManager(MainActivity.this, 2);

        calDown = (Button) findViewById(R.id.CalDown);
        calUp = (Button) findViewById(R.id.CalUp);
        btnCart = findViewById(R.id.btnCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dointent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(dointent);
            }
        });

        calDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calDown.setTextColor(Color.parseColor("#F36373"));
                calUp.setTextColor(Color.parseColor("#3b3b3b"));
                adapter.setData(datasetLesstoMore);
                adapter.notifyDataSetChanged();
            }
        });
        calUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calUp.setTextColor(Color.parseColor("#F36373"));
                calDown.setTextColor(Color.parseColor("#3b3b3b"));
                adapter.setData(datasetMoretoLess);
                adapter.notifyDataSetChanged();
            }
        });

        //6.Set adapter of RecyclerView
        rcy.setLayoutManager(mLayoutManager);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.grid_padding);
        rcy.addItemDecoration(itemDecoration);
        rcy.setAdapter(adapter);


        MenuDBModel Menu = new MenuDBModel();
        //Menu.setMenuModel(strresults);

    }

    private void callMenuLesstoMoreAPIService() {
        //ServerConnect connector = new ServerConnect();
        //String result = connector.connect("index.php",true);
        //Create ServerConnector object
        ServerConnect connector = new ServerConnect();

        //Connect Web page with Entitymodel object
        String strresults = connector.connect("showmenu.php?source=1", true);
        Log.v(TAG, "callMenuLesstoMoreAPIService" + strresults);

        datasetLesstoMore.addAll(parseJSON(strresults));

    }

    private void callMenuMoretoLessAPIService() {
        //ServerConnect connector = new ServerConnect();
        //String result = connector.connect("index.php",true);
        //Create ServerConnector object
        ServerConnect connector = new ServerConnect();

        //Connect Web page with Entitymodel object
        String strresults = connector.connect("showmenu.php?source=0", true);
        Log.v(TAG, "callMenuMoretoLessAPIService" + strresults);

        datasetMoretoLess.addAll(parseJSON(strresults));

    }

    private List<MenuDBModel> parseJSON(String strresults) {

        List<MenuDBModel> menuDBModels = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strresults);

            for (int i = 0; i < jsonArray.length(); i++) {
                MenuDBModel menuDBModel = getJSONObject(jsonArray.getJSONObject(i));
                if (menuDBModels == null) {
                    menuDBModels = new ArrayList<>();
                }
                if (menuDBModel != null) {
                    menuDBModels.add(menuDBModel);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return menuDBModels;
    }

    public MenuDBModel getJSONObject(JSONObject data) {
        try {
            //JSONObject data = new JSONObject(jsonObjstr);
            MenuDBModel menuDBModel = new MenuDBModel();
            menuDBModel.setMenuID(data.get("MenuID").toString());
            menuDBModel.setMenuName(data.get("MenuName").toString());
            menuDBModel.setMenuPic(data.get("MenuPic").toString());
            menuDBModel.setMenuPrice(data.get("MenuPrice").toString());
            menuDBModel.setMenuDescription(data.get("MenuDescription").toString());
            menuDBModel.setMenuCal(data.get("MenuCal").toString());
            return menuDBModel;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void onClickDetailMenu(View v) {
        Intent dointent = new Intent(this, menuDetailActivity.class);
        startActivity(dointent);
    }

    public void onClickMyOrder(View v){
        Intent dointent = new Intent(this, MyOrderActivity.class);
        startActivity(dointent);
    }
}
