package com.example.openwebinar.avengersinfo.views;

import android.content.Context;
import android.util.AttributeSet;

import com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants;

import org.androidannotations.annotations.EView;

@EView
public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setText(String hero, String actor, String desc, String language) {
        String infoToShow;

        if (Constants.EN.equals(language)) {
            infoToShow = "Avenger: " + hero + "\n" +
                    "Actor: " + actor + "\n" +
                    "Description: " + desc;
        } else {
            infoToShow = "Vengador: " + hero + "\n" +
                    "Actor: " + actor + "\n" +
                    "Descripción: " + desc;
        }

        setText(infoToShow);
    }

}
