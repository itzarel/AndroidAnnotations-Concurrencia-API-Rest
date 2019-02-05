package com.example.openwebinar.avengersinfo.beans;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringRes;

@EBean
public class Spanish {

    @StringRes
    String b_select_en_sp, b_select_sp_sp, app_name_sp;
    

    public String getBSelectEn() {
        return b_select_en_sp;
    }

    public String getBSelectSp() {
        return b_select_sp_sp;
    }

    public String getAppName() {
        return app_name_sp;
    }
}
