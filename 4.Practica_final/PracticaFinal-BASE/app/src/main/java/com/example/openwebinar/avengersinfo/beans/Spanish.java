package com.example.openwebinar.avengersinfo.beans;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringRes;

@EBean
public class Spanish {

    @StringRes
    String b_select_en_sp, b_select_sp_sp, app_name_sp;

    @StringRes
    String iron_man_desc_sp;
    @StringRes
    String spider_man_desc_sp;
    @StringRes
    String capitan_america_sp, capitan_america_desc_sp;
    @StringRes
    String viuda_negra_sp, viuda_negra_desc_sp;
    @StringRes
    String thor_desc_sp;
    @StringRes
    String hulk_desc_sp;
    

    public String getBSelectEn() {
        return b_select_en_sp;
    }

    public String getBSelectSp() {
        return b_select_sp_sp;
    }

    public String getAppName() {
        return app_name_sp;
    }

    public String getIronManDesc() {
        return iron_man_desc_sp;
    }

    public String getSpiderManDesc() {
        return spider_man_desc_sp;
    }

    public String getCapitanAmerica() {
        return capitan_america_sp;
    }

    public String getCapitanAmericaDesc() {
        return capitan_america_desc_sp;
    }

    public String getViudaNegra() {
        return viuda_negra_sp;
    }

    public String getViudaNegraDesc() {
        return viuda_negra_desc_sp;
    }

    public String getThorDesc() {
        return thor_desc_sp;
    }

    public String getHulkDesc() {
        return hulk_desc_sp;
    }
}
