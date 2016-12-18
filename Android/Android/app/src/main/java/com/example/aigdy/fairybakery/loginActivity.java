package com.example.aigdy.fairybakery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aigdy.fairybakery.Model.CustomerModel;
import com.example.aigdy.fairybakery.Model.EntityModel;

public class loginActivity extends AppCompatActivity {

    MyDBClass myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDb = new MyDBClass(this);

        myDb.getWritableDatabase(); // First method
        myDb.deleteCustomer();
    }

    public void onClickSignIn(View v){
        EditText username_edt = (EditText)findViewById(R.id.EdtUsername);
        EditText password_edt = (EditText)findViewById(R.id.EdtPassword);

        EntityModel entity = new EntityModel();

        //Assign Data to EntityModel object
        entity.getValues().put("login_username",username_edt.getText().toString());
        entity.getValues().put("login_password",password_edt.getText().toString());

        //Create ServerConnector object
        ServerConnect connector = new ServerConnect();

        //Connect Web page with Entitymodel object
        String strresult = connector.connect("login.php",true,entity);
        //Toast.makeText(this, strresult, Toast.LENGTH_SHORT).show();

        //Get JSON to String
        //สร้างกระบวนการตรงนี้ไว้ใน UserModel ไว้หมดแล้ว
        /*
        try {
            JSONObject jdata = new JSONObject(strresult);
            Toast.makeText(this, jdata.get("user_id").toString(), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        CustomerModel custom = new CustomerModel();
        custom.setUserModel(strresult);


        Log.v(loginActivity.class.getSimpleName(), "id = " + custom.getCustomerID());

        //ถ้าทุกอย่างเรียบร้อยให้ไปหน้า main
        if (custom.getCustomerID() != 0 && !custom.getCustomerStatus().equalsIgnoreCase("0")){
            myDb.insertCusomterId(String.valueOf(custom.getCustomerID()));
            Intent dointent = new Intent(this,MainActivity.class);
            startActivity(dointent);
            finish();
        }else {
            Toast.makeText(this,"Username or Password is incorrect.",Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickRegister(View v){
        Intent dointent = new Intent(this, registerActivity.class);
        startActivity(dointent);
    }
}
