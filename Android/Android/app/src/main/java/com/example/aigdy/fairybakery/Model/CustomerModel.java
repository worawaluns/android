package com.example.aigdy.fairybakery.Model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aigdy on 11/27/2016 AD.
 */

public class CustomerModel {
    private int CustomerID;
    private String CustomerEmail;
    private String CustomerUsername;
    private String CustomerFullname;
    private String CustomerTel;
    private String CustomerStatus;

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerFullname() {
        return CustomerFullname;
    }

    public void setCustomerFullname(String customerFullname) {
        CustomerFullname = customerFullname;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerTel() {
        return CustomerTel;
    }

    public void setCustomerTel(String customerTel) {
        CustomerTel = customerTel;
    }

    public String getCustomerUsername() {
        return CustomerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        CustomerUsername = customerUsername;
    }

    public String getCustomerStatus() {
        return CustomerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        CustomerStatus = customerStatus;
    }

    public void setUserModel(String jsonObjstr){
        try {
            JSONObject data = new JSONObject(jsonObjstr);

            Log.v(CustomerModel.class.getSimpleName(), jsonObjstr);

            this.CustomerEmail = data.get("CustomerEmail").toString();
            this.CustomerUsername = data.getString("CustomerUsername");
            this.CustomerFullname = data.getString("CustomerFullname");
            this.CustomerTel = data.getString("CustomerTel");
            this.CustomerID = data.getInt("CustomerID");
            this.CustomerStatus = data.getString("CustomerStatus");

        } catch (JSONException e) {
            Log.d("ERROR::",jsonObjstr);
            e.printStackTrace();
        }
    }

}
