package com.example.aigdy.fairybakery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class menuDetailActivity extends AppCompatActivity {

    private static final String TAG = menuDetailActivity.class.getSimpleName();

    private ImageView IMVpic;
    private TextView tvName;
    private TextView tvCal;
    private TextView tvPrice;
    private TextView tvDetailMore;
    private Button BtnAddtocart;

    private String id;
    private String name;
    private String pic;
    private String cal;
    private String detail;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        IMVpic = (ImageView) findViewById(R.id.IMVpic);
        tvName = (TextView) findViewById(R.id.tvName);
        tvCal = (TextView) findViewById(R.id.tvCal);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDetailMore = (TextView) findViewById(R.id.tvDetailMore);
        BtnAddtocart = (Button) findViewById(R.id.BtnAddtocart);

        //ดึงจาก DB
        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        pic = getIntent().getStringExtra("pic");
        cal = getIntent().getStringExtra("cal");
        detail = getIntent().getStringExtra("detail");
        price = getIntent().getStringExtra("price");

        //ตรวจสอบว่า pic มาหรือไม่
        Log.v(TAG, "pic = " + pic);

        tvName.setText(name);
        tvCal.setText(cal + " Cal");
        tvDetailMore.setText(detail);
        tvPrice.setText("ราคา " + price + " บาท");
        Glide.with(this).load(pic).centerCrop().into(IMVpic);

        final MyDBClass myDb = new MyDBClass(this);

        BtnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Statement 1
                long flg1 = myDb.InsertData(id, pic, name, cal, price, "1");
                if(flg1 > 0)
                {
                    Toast.makeText(menuDetailActivity.this,"เพิ่มรายการสำเร็จ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(menuDetailActivity.this,"คุณเคยเพิ่มรายการนี้แล้ว", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
