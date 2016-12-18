package com.example.aigdy.fairybakery.Model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aigdy on 12/12/2016 AD.
 */

public class RegisterModel {
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setRegisterModel(String jsonObjstr){
        try {
            JSONObject data = new JSONObject(jsonObjstr);

            this.Status = data.get("Status").toString();
        } catch (JSONException e) {
            Log.d("ERROR::",jsonObjstr);
            e.printStackTrace();
        }
    }
}
