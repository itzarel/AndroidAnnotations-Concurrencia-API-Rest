package com.example.openwebinar.avengersinfo.recoverinfo;

import android.app.Application;

import com.example.openwebinar.avengersinfo.R;
import com.example.openwebinar.avengersinfo.beans.English;
import com.example.openwebinar.avengersinfo.beans.Spanish;
import com.example.openwebinar.avengersinfo.recoverinfo.dto.HeroInfo;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.res.IntArrayRes;

import static com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants.CAP_AMERICA;
import static com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants.EN;
import static com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants.HULK;
import static com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants.IRON_MAN;
import static com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants.SPIDER_MAN;
import static com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants.THOR;
import static com.example.openwebinar.avengersinfo.recoverinfo.constants.Constants.VIUDA;

@EApplication
public class RequestInfoActivity extends Application {

    @Bean
    English english;
    @Bean
    Spanish spanish;

    @IntArrayRes
    int [] iron_man_colors, sprider_man_colors, capitan_america_colors, viuda_negra_colors, thor_colors, hulk_colors;


    public HeroInfo callHero(int heroId, String language) {
        HeroInfo heroInfo = null;

        switch (heroId) {
            case IRON_MAN:
                if (EN.equals(language)) {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.ironman, english.getIronMan(), english.getIronManActor(), english.getIronManDesc(), iron_man_colors);
                } else {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.ironman, english.getIronMan(), english.getIronManActor(), spanish.getIronManDesc(), iron_man_colors);
                }
                break;
            case SPIDER_MAN:
                if (EN.equals(language)) {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.spriderman, english.getSpiderMan(), english.getSpiderManActor(), english.getSpiderManDesc(), sprider_man_colors);
                } else {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.spriderman, english.getSpiderMan(), english.getSpiderManActor(), spanish.getSpiderManDesc(), sprider_man_colors);
                }
                break;
            case CAP_AMERICA:
                if (EN.equals(language)) {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.capam, english.getCapitanAmerica(), english.getCapitanAmericaActor(), english.getCapitanAmericaDesc(), capitan_america_colors);
                } else {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.capam, spanish.getCapitanAmerica(), english.getCapitanAmericaActor(), spanish.getCapitanAmericaDesc(), capitan_america_colors);
                }
                break;
            case VIUDA:
                if (EN.equals(language)) {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.viuda, english.getViudaNegra(), english.getViudaNegraActor(), english.getViudaNegraDesc(), viuda_negra_colors);
                } else {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.viuda, spanish.getViudaNegra(), english.getViudaNegraActor(), spanish.getViudaNegraDesc(), viuda_negra_colors);
                }
                break;
            case THOR:
                if (EN.equals(language)) {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.thor, english.getThor(), english.getThorActor(), english.getThorDesc(), thor_colors);
                } else {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.thor, english.getThor(), english.getThorActor(), spanish.getThorDesc(), thor_colors);
                }
                break;
            case HULK:
                if (EN.equals(language)) {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.hulk, english.getHulk(), english.getHulkActor(), english.getHulkDesc(), hulk_colors);
                } else {
                    heroInfo = new HeroInfo(heroId, language, R.drawable.hulk, english.getHulk(), english.getHulkActor(), spanish.getHulkDesc(), hulk_colors);
                }
                break;
        }

        return heroInfo;
    }
}
