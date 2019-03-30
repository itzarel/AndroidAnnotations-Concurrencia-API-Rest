package com.example.openwebinar.concurrenceui;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    TextView tv_example;


    void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }

/*
    @AfterViews
    void initAfterViews() {
        slowUIUpdaterUiThread();
        initForUIBackground();
    }

    @Background
    void initForUIBackground() {
//        try {
//            sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        updateTheUIUiThread("Starting process...");
    }

    @UiThread
    void updateTheUIUiThread(String toUpdate) {
        tv_example.setText(toUpdate);
    }

    @UiThread
    void slowUIUpdaterUiThread() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String toUpdate = "Updated in '@UiThread' annotated method";
        tv_example.setText(toUpdate);


        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        toUpdate = "Done!";
        tv_example.setText(toUpdate);
    }

*/
    @AfterViews
    void initAfterViews() {
        initSlowUIUpdaterUiThread();
        initForUIBackground();
    }

    @Background
    void initForUIBackground() {
        updateTheUIUiThread("Starting process...");
    }

    @UiThread
    void updateTheUIUiThread(String toUpdate) {
        tv_example.setText(toUpdate);
    }

    @Background
    void initSlowUIUpdaterUiThread() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        slowUIUpdaterUiThread();
    }

    @UiThread
    void slowUIUpdaterUiThread() {
        String toUpdate = "Updated in '@UiThread' annotated method";
        tv_example.setText(toUpdate);
        secondLogicFromSlowUIUpdaterUiThread();
    }

    @Background
    void secondLogicFromSlowUIUpdaterUiThread() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        finnishUIUpdaterUiThread();
    }

    @UiThread(delay = 10000)
    void finnishUIUpdaterUiThread() {
        String toUpdate = "Really done!";
        tv_example.setText(toUpdate);
        reusedFinnishUIUpdaterUiThread();
    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void reusedFinnishUIUpdaterUiThread() {
        String toUpdate = "Reusing UI, it is more optimal: Done!";
        tv_example.setText(toUpdate);
    }
/**/
}
