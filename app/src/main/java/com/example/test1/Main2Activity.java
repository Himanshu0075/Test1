package com.example.test1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    Button btn1;
    Intent intent;
    Context context=Main2Activity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=findViewById(R.id.btn);
        btn1=findViewById(R.id.btn1);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                intent=new Intent(context,admin.class);
                context.startActivity(intent);
                break;
            case R.id.btn1:
                intent=new Intent(context,ProductsActivity.class);
                context.startActivity(intent);
                break;

        }
    }
}
