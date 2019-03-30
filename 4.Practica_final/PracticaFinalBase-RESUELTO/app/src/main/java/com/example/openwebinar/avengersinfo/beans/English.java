package com.example.openwebinar.avengersinfo.beans;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringRes;

@EBean
public class English {

    @StringRes
    String b_select_en, b_select_sp, app_name;

    public String getBSelectEn() {
        return b_select_en;
    }

    public String getBSelectSp() {
        return b_select_sp;
    }

    public String getAppName() {
        return app_name;
    }
}
