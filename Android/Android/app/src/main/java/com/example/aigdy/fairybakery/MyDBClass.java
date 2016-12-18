package com.example.aigdy.fairybakery;

/**
 * Created by aigdy on 12/16/2016 AD.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.aigdy.fairybakery.Model.OrdersModel;

import java.util.ArrayList;
import java.util.List;

public class MyDBClass extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "mydatabase";

    // Table Name
    private static final String TABLE_MEMBER = "orders";

    public MyDBClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("CREATE TABLE " + TABLE_MEMBER +
                "(OrderID TEXT(10) PRIMARY KEY," +
                " PicMenu TEXT(255)," +
                " NameMenu TEXT(100)," +
                " PriceMenu TEXT(10)," +
                " CalMenu TEXT(10)," +
                " MenuCount TEXT(10));");

        db.execSQL("CREATE TABLE CUSTOMER (customerId TEXT(10) PRIMARY KEY);");

        Log.d("CREATE TABLE", "Create Table Successfully.");
    }

    // Insert Data
    public long insertCusomterId(String customerId) {
        // TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();
            Val.put("customerId", customerId);

            long rows = db.insert("CUSTOMER", null, Val);


            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }

    public String getCustomerId() {
        // TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT * FROM CUSTOMER";
            Cursor cursor = db.rawQuery(strSQL, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        return cursor.getString(0);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return "";

        } catch (Exception e) {
            return null;
        }

    }

    // Insert Data
    public long InsertData(String strOrderID, String strPicMenu, String strNameMenu, String strPriceMenu, String strCalMenu, String strMenuCount) {
        // TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            /**
             *  for API 11 and above
             SQLiteStatement insertCmd;
             String strSQL = "INSERT INTO " + TABLE_MEMBER
             + "(MemberID,Name,Tel) VALUES (?,?,?)";

             insertCmd = db.compileStatement(strSQL);
             insertCmd.bindString(1, strMemberID);
             insertCmd.bindString(2, strName);
             insertCmd.bindString(3, strTel);
             return insertCmd.executeInsert();
             */

            ContentValues Val = new ContentValues();
            Val.put("OrderID", strOrderID);
            Val.put("PicMenu", strPicMenu);
            Val.put("NameMenu", strNameMenu);
            Val.put("PriceMenu", strPriceMenu);
            Val.put("CalMenu", strCalMenu);
            Val.put("MenuCount", strMenuCount);

            long rows = db.insert(TABLE_MEMBER, null, Val);

            if (rows > 1) {

            } else {
                OrdersModel ordersModel = SelectData(strOrderID);
                UpdateData(strOrderID, String.valueOf(Integer.parseInt(ordersModel.getMenuCount()) + 1));
            }

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            OrdersModel ordersModel = SelectData(strOrderID);
            UpdateData(strOrderID, String.valueOf(Integer.parseInt(ordersModel.getMenuCount()) + 1));
            return -1;
        }

    }

    // Delete Data
    public long DeleteData(String strOrderID) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            /**
             * for API 11 and above
             SQLiteStatement insertCmd;
             String strSQL = "DELETE FROM " + TABLE_MEMBER
             + " WHERE MemberID = ? ";

             insertCmd = db.compileStatement(strSQL);
             insertCmd.bindString(1, strMemberID);

             return insertCmd.executeUpdateDelete();
             *
             */

            long rows = db.delete(TABLE_MEMBER, "OrderID = ?",
                    new String[]{String.valueOf(strOrderID)});

            db.close();
            return rows; // return rows delete.

        } catch (Exception e) {
            return -1;
        }

    }


    // Delete Data
    public long deleteCustomer() {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            /**
             * for API 11 and above
             SQLiteStatement insertCmd;
             String strSQL = "DELETE FROM " + TABLE_MEMBER
             + " WHERE MemberID = ? ";

             insertCmd = db.compileStatement(strSQL);
             insertCmd.bindString(1, strMemberID);

             return insertCmd.executeUpdateDelete();
             *
             */

            long rows = db.delete("CUSTOMER", "", new String[]{});

            db.close();
            return rows; // return rows delete.

        } catch (Exception e) {
            return -1;
        }

    }

    // Delete Data
    public long DeleteDataAll() {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            /**
             * for API 11 and above
             SQLiteStatement insertCmd;
             String strSQL = "DELETE FROM " + TABLE_MEMBER
             + " WHERE MemberID = ? ";

             insertCmd = db.compileStatement(strSQL);
             insertCmd.bindString(1, strMemberID);

             return insertCmd.executeUpdateDelete();
             *
             */

            long rows = db.delete(TABLE_MEMBER, "", new String[]{});

            db.close();
            return rows; // return rows delete.

        } catch (Exception e) {
            return -1;
        }

    }

    // Update Data
    public long UpdateData(String strOrderID, String strMenuCount) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();
            Val.put("OrderID", strOrderID);
            Val.put("MenuCount", strMenuCount);

            long rows = db.update(TABLE_MEMBER, Val, " OrderID = ?",
                    new String[]{String.valueOf(strOrderID)});

            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }

    }

    public List<OrdersModel> SelectAllData() {
        // TODO Auto-generated method stub

        try {
            List<OrdersModel> OrdersList = new ArrayList<OrdersModel>();

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_MEMBER;
            Cursor cursor = db.rawQuery(strSQL, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        OrdersModel cOrders = new OrdersModel();
                        cOrders.setMenuID(cursor.getString(0));
                        cOrders.setMenuPic(cursor.getString(1));
                        cOrders.setMenuName(cursor.getString(2));
                        cOrders.setMenuPrice(cursor.getString(3));
                        cOrders.setMenuCal(cursor.getString(4));
                        cOrders.setMenuCount(cursor.getString(5));
                        OrdersList.add(cOrders);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return OrdersList;

        } catch (Exception e) {
            return null;
        }

    }

    public OrdersModel SelectData(String orderId) {
        // TODO Auto-generated method stub

        try {
            OrdersModel ordersModel = new OrdersModel();
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_MEMBER + " WHERE OrderID = '" + orderId + "'";
            Cursor cursor = db.rawQuery(strSQL, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        ordersModel.setMenuID(cursor.getString(0));
                        ordersModel.setMenuPic(cursor.getString(1));
                        ordersModel.setMenuName(cursor.getString(2));
                        ordersModel.setMenuPrice(cursor.getString(3));
                        ordersModel.setMenuCal(cursor.getString(4));
                        ordersModel.setMenuCount(cursor.getString(5));
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return ordersModel;

        } catch (Exception e) {
            return null;
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}

