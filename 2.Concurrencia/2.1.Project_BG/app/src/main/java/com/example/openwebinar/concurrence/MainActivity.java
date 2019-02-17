package com.example.openwebinar.concurrence;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.api.BackgroundExecutor;

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    TextView tv_example;

    private final String INIT_COMMENT = "*************************************************> ";

    @AfterViews
    void initAfterViews() {
        // Delayed task
        delayerTaskBackground();

        // First explanation
        final String OPERATION = "hello";
        System.out.println(INIT_COMMENT + "Launching " + OPERATION + " operation");
        addOperationBackground("hello", 42);
        System.out.println(INIT_COMMENT + "End!");

        // Background with ids
        cancellableTaskBackground();
        iAmTheKillerBackground();
    }

    @Background
    void addOperationBackground(String aParam, long init) {
        long result = init;

        for (int c=0; c<15; c++) {
            try {
                sleep(500);
                result = result + 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("addOperationBackground: " +INIT_COMMENT + aParam + " is: " + result);
        Log.v("addOperationBackground - DETAIL", INIT_COMMENT + aParam + " is: " + result);
        Log.i("addOperationBackground - INFO", INIT_COMMENT + aParam + " is: " + result);
        Log.e("addOperationBackground - ERROR", INIT_COMMENT + aParam + " is: " + result);

//        This code will generate an AndroidRuntime: FATAL EXCEPTION (Only the original thread that created a view hierarchy can touch its views.)
//        tv_example.setText(aParam + " is: " + result);

        serial1Background();
        serial2Background();
        serial3Background();
        serial4Background();
        serial5Background();
        serial6Background();
    }

    private void sleep(int sleepTime) throws InterruptedException {
            Thread.sleep(sleepTime);
    }

    @Background(id="cancellable_task")
    void cancellableTaskBackground() {
        Log.i("cancellableTaskBackground", INIT_COMMENT + "I go to die in 3 seconds. I should life 6 seconds :(");

        try {
            sleep(6000);
            Log.e("cancellableTaskBackground", INIT_COMMENT + "You won't see me anymore. I'll die before :'(");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.i("cancellableTaskBackground", INIT_COMMENT + "'cancellable_task' is killed");
        }
    }

    @Background
    void iAmTheKillerBackground() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // http://javadox.com/org.androidannotations/androidannotations-api/3.1/org/androidannotations/api/BackgroundExecutor.html#cancelAll(java.lang.String,%20boolean)
        BackgroundExecutor.cancelAll("cancellable_task", true);
        Log.i("iAmTheKillerBackground", INIT_COMMENT + "Sayonara baby 8D");
    }

    @Background//(serial = "serial_example")
    void serial1Background() {
        Log.i("serial1Background","I should be the first");
    }

    @Background//(serial = "serial_example")
    void serial2Background() {
        Log.i("serial2Background","I am the second");
    }

    @Background//(serial = "serial_example")
    void serial3Background() {
        Log.i("serial3Background","Third one");
    }

    @Background//(serial = "serial_example")
    void serial4Background() {
        Log.i("serial4Background","I will be the fourth");
    }

    @Background//(serial = "serial_example")
    void serial5Background() {
        Log.i("serial5Background","I'm the fith");
    }

    @Background//(serial = "serial_example")
    void serial6Background() {
        Log.i("serial6Background","Sixth, dude!");
    }

    @Background(delay=10000)
    void delayerTaskBackground() {
        Log.i("delayerTaskBackground","I am the last one because I am a turtle!");
    }
}
