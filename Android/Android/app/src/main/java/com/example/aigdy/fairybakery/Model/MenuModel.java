package com.example.aigdy.fairybakery.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aigdy on 12/13/2016 AD.
 */

public class MenuModel {
    //private String picMenu;
    private String NameMenu;
    private String CalMenu;
    private String PriceMenu;


    public MenuModel(String nameMenu, String calMenu, String priceMenu) {
        //this.picMenu = picMenu;
        this.NameMenu = nameMenu;
        this.CalMenu = calMenu;
        this.PriceMenu = priceMenu;
    }

    public String getCalMenu() {
        return CalMenu;
    }

    public void setCalMenu(String calMenu) {
        CalMenu = calMenu;
    }

    public String getNameMenu() {
        return NameMenu;
    }

    public void setNameMenu(String nameMenu) {
        NameMenu = nameMenu;
    }

//    public String getPicMenu() {
//        return picMenu;
//    }
//
//    public void setPicMenu(String picMenu) {
//        this.picMenu = picMenu;
//    }

    public String getPriceMenu() {
        return PriceMenu;
    }

    public void setPriceMenu(String priceMenu) {
        PriceMenu = priceMenu;
    }

}
