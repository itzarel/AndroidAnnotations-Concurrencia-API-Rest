package com.example.openwebinar.primeandfibonacci;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.IntegerRes;
import org.androidannotations.annotations.res.StringRes;

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    TextView tv_prime;
    @ViewById
    TextView tv_fibonacci;

    @IntegerRes
    int prime_input_value;
    @IntegerRes
    int fibonacci_size_input_value;

    @StringRes
    String only_natural_numbers;
    @StringRes
    String prime_number;
    @StringRes
    String no_prime_number;
    @StringRes
    String fibonacci_succession;

    final double WRONG_ELEMENT = -1;


    @AfterViews
    void initAfterViews() {
        prime();
        fibonacci();
    }

    @Background
    void prime(){
        boolean isPrime=true;
        String result = "";

        if (prime_input_value < 0) {
            result = only_natural_numbers;
        } else {
            if (prime_input_value <= 3) {
                result = prime_input_value + prime_number;
            } else {
                for (int c = 4; c < prime_input_value; c++) {
                    if (isMultipleNumber(prime_input_value, c)) {
                        result = prime_input_value + no_prime_number;
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    result = prime_input_value + prime_number;
                }
            }
        }

        updateTvPrimeUiThread(result);
    }

    @Background
    public void fibonacci(){
        StringBuilder result = new StringBuilder(fibonacci_succession);

        if (fibonacci_size_input_value > 0) {
            for (double i = 0; i < fibonacci_size_input_value; i++) {
                double calculatedResult = calculateFibonacci(i);
                String singleElement;

                if (WRONG_ELEMENT == calculatedResult) {
                    singleElement = only_natural_numbers;
                } else {
                    singleElement = Double.toString(calculatedResult).replace(".0", "");
                }
                result = result.append(" ").append(singleElement);
            }
        } else {
            result.append(" ").append(only_natural_numbers);
        }

        updateTvFibonacciUiThread( result.toString() );
    }

    @UiThread
    void updateTvPrimeUiThread(String message) {
        tv_prime.setText(message);
    }

    @UiThread
    void updateTvFibonacciUiThread(String message) {
        tv_fibonacci.setText(message);
    }



    private boolean isMultipleNumber(int multiple, int divisor) {
        return (multiple%divisor) == 0;
    }

    private double calculateFibonacci(double fibonacciElement) {
        if (fibonacciElement > 1) {
            return calculateFibonacci(fibonacciElement-1) + calculateFibonacci(fibonacciElement-2);
        }
        else if (fibonacciElement == 1) {
            return 1;
        }
        else if (fibonacciElement == 0) {
            return 0;
        }
        else {
            return WRONG_ELEMENT;
        }
    }
}
