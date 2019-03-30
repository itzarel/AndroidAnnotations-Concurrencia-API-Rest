package com.example.openwebinar.avengersinfo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.openwebinar.avengersinfo.R;
import com.example.openwebinar.avengersinfo.recoverinfo.dto.HeroInfo;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.Touch;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;

@EViewGroup(R.layout.custom_avenger_view)
public class CustomView extends RelativeLayout {

    @ViewById(R.id.iv_avenger_avatar)
    ImageView imageView;

    @ViewById(R.id.ctv_avenger_info)
    CustomTextView customTextView;

    @ViewById
    View custom_avenger_view;

    @ViewById
    Button button1, button2, button3, button4, button5;

    @AnimationRes(R.anim.blink)
    Animation blink;


    int[] colors;


    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setInfo(HeroInfo heroInfo) {
        colors = heroInfo.getColors();
        imageView.setImageResource(heroInfo.getImage());
        customTextView.setText(heroInfo.getHero(), heroInfo.getActor(), heroInfo.getDescription(), heroInfo.getLanguage());
        button1.setBackgroundColor(heroInfo.getColors()[0]);
        button2.setBackgroundColor(heroInfo.getColors()[1]);
        button3.setBackgroundColor(heroInfo.getColors()[2]);
        button4.setBackgroundColor(heroInfo.getColors()[3]);
        button5.setBackgroundColor(heroInfo.getColors()[4]);
    }

    @Touch({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    void bOperationsButtons(View v, MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            v.setAnimation(blink);

            int color = generateColor( v.getId() );
            custom_avenger_view.setBackgroundColor(color);
        } else {
            v.clearAnimation();
        }
    }

    private int generateColor(int id) {
        int color;

        switch (id) {
            case R.id.button1:
                color = colors[0];
                break;
            case R.id.button2:
                color = colors[1];
                break;
            case R.id.button3:
                color = colors[2];
                break;
            case R.id.button4:
                color = colors[3];
                break;
            default:
                color = colors[4];
                break;
        }

        return color;
    }
}
