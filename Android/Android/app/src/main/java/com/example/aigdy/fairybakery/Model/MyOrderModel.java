package com.example.aigdy.fairybakery.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aigdy on 12/18/2016 AD.
 */

public class MyOrderModel {
    private String MyOrderID;
    private String MyOrderStatus;

    public String getMyOrderID() {
        return MyOrderID;
    }

    public void setMyOrderID(String myOrderID) {
        MyOrderID = myOrderID;
    }

    public String getMyOrderStatus() {
        return MyOrderStatus;
    }

    public void setMyOrderStatus(String myOrderStatus) {
        MyOrderStatus = myOrderStatus;
    }

    public void setMYOrderModel(String jsonObjstr){
        try {
            JSONObject data = new JSONObject(jsonObjstr);

            this.MyOrderID = data.get("MyOrderID").toString();
            this.MyOrderStatus = data.getString("MyOrderStatus");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
