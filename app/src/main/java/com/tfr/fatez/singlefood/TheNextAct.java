package com.tfr.fatez.singlefood;

/**
 * Created by miku1 on 9/21/2016.
 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class TheNextAct extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;
    final Uri imageUri = Uri.parse("res:///" + R.drawable.ic_keyboard_backspace_white_24dp);

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    private AppBarLayout appbar;
    private CollapsingToolbarLayout collapsing;
    private ImageView coverImage;
    private FrameLayout framelayoutTitle;
    private LinearLayout linearlayoutTitle;
    private Toolbar toolbar;
    private TextView textviewTitle;
    private SimpleDraweeView avatar;
    private TextView textHead, textIngrediats, textHowTo, textHead2;
    private AdView mAdView;


    private void findViews() {
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        coverImage = (ImageView) findViewById(R.id.imageview_placeholder);
        framelayoutTitle = (FrameLayout) findViewById(R.id.framelayout_title);
        linearlayoutTitle = (LinearLayout) findViewById(R.id.linearlayout_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        avatar = (SimpleDraweeView) findViewById(R.id.avatar);
        textviewTitle = (TextView) findViewById(R.id.textview_title);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.second);
        findViews();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        toolbar.setTitle("");
        appbar.addOnOffsetChangedListener(this);

        setSupportActionBar(toolbar);
        startAlphaAnimation(textviewTitle, 0, View.INVISIBLE);

        //set avatar and cover
        avatar.setImageURI(imageUri);
        coverImage.setImageResource(R.drawable.cover);

        textHead = (TextView) findViewById(R.id.textHead);
        textIngrediats = (TextView) findViewById(R.id.ingredients);
        textHowTo = (TextView) findViewById(R.id.text_how_to);
        textHead2 = (TextView) findViewById(R.id.textHead2);

        Bundle bundle = getIntent().getExtras();
        String mFood = bundle.getString("mFood");

        // Check value the pass form MainActivity the position of card view id.

        if (mFood.equals("0")) {
            textHead.setText("ข้าวหน้าไก่");
            textHead2.setText("ข้าวหน้าไก่");
            textviewTitle.setText("ข้าวหน้าไก่");
            coverImage.setImageResource(R.drawable.face_chicken);
            textIngrediats.setText(getString(R.string.facechikchen_ingre));
            textHowTo.setText(getString(R.string.facechikchen_how));
        }
        if (mFood.equals("1")) {
            textHead.setText("หอยทอด");
            textHead2.setText("หอยทอด");
            textviewTitle.setText("หอยทอด");
            coverImage.setImageResource(R.drawable.hoi_frie);
            textIngrediats.setText(getString(R.string.hoitod_ingre));
            textHowTo.setText(getString(R.string.hoitod_how));
        }
        if (mFood.equals("2")) {
            textHead.setText("ผัดกะเพราหมูย่าง");
            textHead2.setText("ผัดกะเพราหมูย่าง");
            textviewTitle.setText("ผัดกะเพราหมูย่าง");
            coverImage.setImageResource(R.drawable.ka_pao_pork_yark);
            textIngrediats.setText(getString(R.string.kapao_pork_yak_ingre));
            textHowTo.setText(getString(R.string.kapao_pork_yak_ingre));
        }
        if (mFood.equals("3")) {
            textHead.setText("ผัดกะเพราวุ้นเส้น");
            textHead2.setText("ผัดกะเพราวุ้นเส้น");
            textviewTitle.setText("ผัดกะเพราวุ้นเส้น");
            coverImage.setImageResource(R.drawable.ka_pao_vont_send);
            textIngrediats.setText(getString(R.string.von_send_ingre));
            textHowTo.setText(getString(R.string.von_send_how));
        }
        if (mFood.equals("4")) {
            textHead.setText("ข้าวขาหมู");
            textHead2.setText("ข้าวขาหมู");
            textviewTitle.setText("ข้าวขาหมู");
            coverImage.setImageResource(R.drawable.ka_pork);
            textIngrediats.setText(getString(R.string.kapork_ingre));
            textHowTo.setText(getString(R.string.kapork_how));
        }
        if (mFood.equals("5")) {
            textHead.setText("ก๋วยเตี๋ยวคั่วไก่");
            textHead2.setText("ก๋วยเตี๋ยวคั่วไก่");
            textviewTitle.setText("ก๋วยเตี๋ยวคั่วไก่");
            coverImage.setImageResource(R.drawable.kua_kai);
            textIngrediats.setText(getString(R.string.kapork_ingre));
            textHowTo.setText(getString(R.string.kaukai_how));
        }
        if (mFood.equals("6")) {
            textHead.setText("ข้าวกะเพรากุนเชียง");
            textHead2.setText("ข้าวกะเพรากุนเชียง");
            textviewTitle.setText("ข้าวกะเพรากุนเชียง");
            coverImage.setImageResource(R.drawable.kun_charing);
            textIngrediats.setText(getString(R.string.kunchaing_ingre));
            textHowTo.setText(getString(R.string.kunchaing_how));
        }
        if (mFood.equals("7")) {
            textHead.setText("ก๋วยเตี๋ยวหลอด");
            textHead2.setText("ก๋วยเตี๋ยวหลอด");
            textviewTitle.setText("ก๋วยเตี๋ยวหลอด");
            coverImage.setImageResource(R.drawable.noodle_lord);
            textIngrediats.setText(getString(R.string.noodlelord_ingre));
            textHowTo.setText(getString(R.string.noodlelord_how));
        }
        if (mFood.equals("8")) {
            textHead.setText("ข้าวหมูทอดกระเทียม");
            textHead2.setText("ข้าวหมูทอดกระเทียม");
            textviewTitle.setText("ข้าวหมูทอดกระเทียม");
            coverImage.setImageResource(R.drawable.pork_garilc);
            textIngrediats.setText(getString(R.string.porkgralic_ingre));
            textHowTo.setText(getString(R.string.porkgralic_how));
        }
        if (mFood.equals("9")) {
            textHead.setText("หมี่กรอบราดหน้าหมูหมัก");
            textHead2.setText("หมี่กรอบราดหน้าหมูหมัก");
            textviewTitle.setText("หมี่กรอบราดหน้าหมูหมัก");
            coverImage.setImageResource(R.drawable.rad_na);
            textIngrediats.setText(getString(R.string.mekop_ingre));
            textHowTo.setText(getString(R.string.mekop_how));
        }


        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TheNextAct.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(textviewTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(textviewTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(linearlayoutTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(linearlayoutTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }


    // Back button on the user device
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TheNextAct.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}

