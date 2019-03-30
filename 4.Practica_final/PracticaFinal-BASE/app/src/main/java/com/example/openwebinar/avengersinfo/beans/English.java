package com.example.openwebinar.avengersinfo.beans;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringRes;

@EBean
public class English {

    @StringRes
    String b_select_en, b_select_sp, app_name;

    @StringRes
    String iron_man, iron_man_actor, iron_man_desc;
    @StringRes
    String spider_man, spider_man_actor, spider_man_desc;
    @StringRes
    String capitan_america, capitan_america_actor, capitan_america_desc;
    @StringRes
    String viuda_negra, viuda_negra_actor, viuda_negra_desc;
    @StringRes
    String thor, thor_actor, thor_desc;
    @StringRes
    String hulk, hulk_actor, hulk_desc;

    public String getBSelectEn() {
        return b_select_en;
    }

    public String getBSelectSp() {
        return b_select_sp;
    }

    public String getAppName() {
        return app_name;
    }

    public String getIronMan() {
        return iron_man;
    }

    public String getIronManActor() {
        return iron_man_actor;
    }

    public String getIronManDesc() {
        return iron_man_desc;
    }

    public String getSpiderMan() {
        return spider_man;
    }

    public String getSpiderManActor() {
        return spider_man_actor;
    }

    public String getSpiderManDesc() {
        return spider_man_desc;
    }

    public String getCapitanAmerica() {
        return capitan_america;
    }

    public String getCapitanAmericaActor() {
        return capitan_america_actor;
    }

    public String getCapitanAmericaDesc() {
        return capitan_america_desc;
    }

    public String getViudaNegra() {
        return viuda_negra;
    }

    public String getViudaNegraActor() {
        return viuda_negra_actor;
    }

    public String getViudaNegraDesc() {
        return viuda_negra_desc;
    }

    public String getThor() {
        return thor;
    }

    public String getThorActor() {
        return thor_actor;
    }

    public String getThorDesc() {
        return thor_desc;
    }

    public String getHulk() {
        return hulk;
    }

    public String getHulkActor() {
        return hulk_actor;
    }

    public String getHulkDesc() {
        return hulk_desc;
    }
}
