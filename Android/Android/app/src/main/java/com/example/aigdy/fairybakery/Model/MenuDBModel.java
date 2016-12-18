package com.example.aigdy.fairybakery.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aigdy on 12/13/2016 AD.
 */

public class MenuDBModel
{
    private String MenuID;
    private String MenuPic;
    private String MenuName;
    private String MenuPrice;
    private String MenuDescription;
    private String MenuCal;

    public String getMenuCal() {
        return MenuCal;
    }

    public void setMenuCal(String menuCal) {
        MenuCal = menuCal;
    }

    public String getMenuDescription() {
        return MenuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        MenuDescription = menuDescription;
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

    public void setMenuModel(String jsonObjstr){
        try {
            JSONObject data = new JSONObject(jsonObjstr);

            this.MenuID = data.get("MenuName").toString();
            this.MenuPic = data.getString("MenuCal");
            this.MenuName = data.getString("MenuPrice");
            this.MenuPrice = data.getString("MenuPrice");
            this.MenuDescription = data.getString("MenuPrice");
            this.MenuCal = data.getString("MenuPrice");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
