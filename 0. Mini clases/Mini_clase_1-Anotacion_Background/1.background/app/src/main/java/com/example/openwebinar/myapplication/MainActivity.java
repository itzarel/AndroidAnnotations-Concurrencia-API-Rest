package com.example.openwebinar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @AfterViews
    void initAfterViews() {
        sumBackground();
    }

    @Background
    void sumBackground() {
        int result = 0;
        for (int counter = 1; counter <= 150; counter++) {
            result = result + counter;
            Log.d("",counter + ". ------------------------------------------------------------------->" + result);
        }
    }
}
