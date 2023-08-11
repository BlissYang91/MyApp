package com.by.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.by.myapp.service.AccessService;
import com.by.myapp.service.BaseService;

public class MainActivity extends AppCompatActivity {
    private  BaseService instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = BaseService.getInstance();
        instance.init(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!instance.checkAccessibilityEnabled(getResources().getString(R.string.access_name))) {
            instance.goAccess();
        }
    }
}