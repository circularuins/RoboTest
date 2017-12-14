package com.circularuins.robotest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.circularuins.robotest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bind.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bind.tvHoge.setText("fuga");
            }
        });

        bind.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NextActivity.class));
            }
        });
    }
}
