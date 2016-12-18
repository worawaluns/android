package com.example.aigdy.fairybakery.Model;

import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aigdy on 12/13/2016 AD.
 */

public class OrdersModel
{
    private String MenuID;
    private String MenuPic;
    private String MenuName;
    private String MenuPrice;
    private String MenuCal;
    private String MenuCount;

    public String getMenuCal() {
        return MenuCal;
    }

    public void setMenuCal(String menuCal) {
        MenuCal = menuCal;
    }

    public String getMenuCount() {
        return MenuCount;
    }

    public void setMenuCount(String menuDescription) {
        MenuCount = menuDescription;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public String getMenuPic() {
        return MenuPic;
    }

    public void setMenuPic(String menuPic) {
        MenuPic = menuPic;
    }

    public String getMenuPrice() {
        return MenuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        MenuPrice = menuPrice;
    }


}
