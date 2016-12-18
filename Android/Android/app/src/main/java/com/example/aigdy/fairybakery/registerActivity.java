package com.example.aigdy.fairybakery;

import android.app.Activity;
import android.content.Intent;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aigdy.fairybakery.Model.CustomerModel;
import com.example.aigdy.fairybakery.Model.EntityModel;
import com.example.aigdy.fairybakery.Model.RegisterModel;

public class registerActivity extends Activity {

    //Dialog
    AlertDialog.Builder ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ad = new AlertDialog.Builder(registerActivity.this);
    }

    public void onClickConfirm(View v){

        ad.setTitle("Error!");
        ad.setIcon(android.R.drawable.btn_star_big_on);
        ad.setPositiveButton("Close",null);

        EditText email_edt = (EditText)findViewById(R.id.EdtEmail);
        EditText username_edt = (EditText)findViewById(R.id.EdtUsername);
        EditText password_edt = (EditText)findViewById(R.id.EdtPassword);
        EditText name_edt = (EditText)findViewById(R.id.EdtName);
        EditText tel_edt = (EditText)findViewById(R.id.EdtTel);

        EntityModel entity = new EntityModel();

        //Check validate
        if (email_edt.getText().length() == 0){
            ad.setMessage("Please input Email");
            ad.show();
            email_edt.requestFocus();
        }else if (username_edt.getText().length() == 0){
            ad.setMessage("Please input Username");
            ad.show();
            username_edt.requestFocus();
        }else if (password_edt.getText().length() < 6){
            ad.setMessage("Please input Password More 6 Character");
            ad.show();
            password_edt.requestFocus();
        }else if (name_edt.getText().length() == 0){
            ad.setMessage("Please input Name");
            ad.show();
            name_edt.requestFocus();
        }else if (tel_edt.getText().length() == 0){
            ad.setMessage("Please input Tel");
            ad.show();
            tel_edt.requestFocus();
        }else{
        //Assign Data to EntityModel object
        entity.getValues().put("CustomerEmail",email_edt.getText().toString());
        entity.getValues().put("CustomerUsername",username_edt.getText().toString());
        entity.getValues().put("CustomerPassword",password_edt.getText().toString());
        entity.getValues().put("CustomerFullname",name_edt.getText().toString());
        entity.getValues().put("CustomerTel",tel_edt.getText().toString());

        //Create ServerConnector object
        ServerConnect connector = new ServerConnect();

        //Connect Web page with Entitymodel object
        String strresult = connector.connect("register.php",true,entity);

        RegisterModel register = new RegisterModel();
        register.setRegisterModel(strresult);

            if (register.getStatus() == null){
                Intent dointent = new Intent(this,loginActivity.class);
                startActivity(dointent);
                finish();
            }else {
                Toast.makeText(this,"Can't register.",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
