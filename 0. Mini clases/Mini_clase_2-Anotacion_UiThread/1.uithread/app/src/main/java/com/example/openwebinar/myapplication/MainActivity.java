package com.example.openwebinar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    final String THE_RESULT = "The result is: ";
    final String END = "FIN!";

    @ViewById(R.id.tv_demo)
    TextView tvDemo;

    @AfterViews
    void initAfterViews() {
        sumBackground();
        tvDemo.setText(END);
    }

    @Background
    void sumBackground() {
        double result = 0;
        for (int counter = 1; counter <= 200; counter++) {
            sleep();
            result = result + counter;
            Log.d("",counter + ". ------------------------------------------------------------------->" + result);
        }

        // Esto falla porque estamos modificando un objeto de UI en background
        // android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
//        String toShow = THE_RESULT + result;
//        tvDemo.setText(toShow);

        // Por ello debemos emplear la anotación UiThread
        resultUiThread(result);
    }

    @UiThread
    void resultUiThread(double result) {
        String toShow = THE_RESULT + result;
        tvDemo.setText(toShow);
    }

    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
