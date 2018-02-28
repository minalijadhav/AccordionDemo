package com.example.admin.accordiondemo.activity;

import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.admin.accordiondemo.R;
import com.example.admin.accordiondemo.adapter.ViewPagerAdapter;
import com.example.admin.accordiondemo.other.ScaleAnimationToHide;
import com.example.admin.accordiondemo.other.ScaleAnimationToShow;

public class MainActivity extends AppCompatActivity
{
    private RelativeLayout relativeLayout;
    private RelativeLayout natureRelative, flowersRelative, babiesRelative, roadsRelative;
    private TextView natureText, flowersText, babiesText, roadsText;
    private ViewPager natureViewPager, flowersViewPager, babiesViewPager, roadsViewPager;
    private ScrollView scrollView;
    private Typeface typeface;
    private int[] image_array_1, image_array_2, image_array_3, image_array_4;
    private PagerAdapter pagerAdapter;
    private View openLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialization
        initialize();

        // Setting up listeners
        addListeners();
    }

    private void addListeners()
    {
        natureRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideOtherLayouts(natureRelative);
            }
        });

        flowersRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideOtherLayouts(flowersRelative);
            }
        });

        babiesRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideOtherLayouts(babiesRelative);
            }
        });

        roadsRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideOtherLayouts(roadsRelative);
            }
        });
    }

    private void initialize()
    {
        // Finding IDs of all the Views
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);

        natureRelative = (RelativeLayout) findViewById(R.id.nature_relative_layout);
        flowersRelative = (RelativeLayout) findViewById(R.id.flowers_relative_layout);
        babiesRelative = (RelativeLayout) findViewById(R.id.babies_relative_layout);
        roadsRelative = (RelativeLayout) findViewById(R.id.roads_relative_layout);

        natureText = (TextView) findViewById(R.id.nature_text_view_2);
        flowersText = (TextView) findViewById(R.id.flowers_text_view_2);
        babiesText = (TextView) findViewById(R.id.babies_text_view_2);
        roadsText = (TextView) findViewById(R.id.roads_text_view_2);

        natureViewPager = (ViewPager) findViewById(R.id.nature_view_pager);
        flowersViewPager = (ViewPager) findViewById(R.id.flowers_view_pager);
        babiesViewPager = (ViewPager) findViewById(R.id.babies_view_pager);
        roadsViewPager = (ViewPager) findViewById(R.id.roads_view_pager);

        scrollView = (ScrollView) findViewById(R.id.scroll_view);

        // Setting Custom font to the Text Views
        typeface = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        natureText.setTypeface(typeface);
        flowersText.setTypeface(typeface);
        babiesText.setTypeface(typeface);
        roadsText.setTypeface(typeface);

        // Setting Adapter to View Pager

        // 1. Nature
        image_array_1 = new int[]
                {
                        R.drawable.nature_1,
                        R.drawable.nature_3,
                        R.drawable.nature_4,
                        R.drawable.nature_5
                };
        pagerAdapter = new ViewPagerAdapter(MainActivity.this, image_array_1);
        natureViewPager.setAdapter(pagerAdapter);

        // 2. Flowers
        image_array_2 = new int[]
                {
                        R.drawable.flowers_1,
                        R.drawable.flowers_2,
                        R.drawable.flowers_3,
                        R.drawable.flowers_5
                };
        pagerAdapter = new ViewPagerAdapter(MainActivity.this, image_array_2);
        flowersViewPager.setAdapter(pagerAdapter);

        // 3. Babies
        image_array_3 = new int[]
                {
                        R.drawable.babies_2,
                        R.drawable.babies_3,
                        R.drawable.babies_4,
                        R.drawable.babies_5
                };
        pagerAdapter = new ViewPagerAdapter(MainActivity.this, image_array_3);
        babiesViewPager.setAdapter(pagerAdapter);

        // 4. Roads
        image_array_4 = new int[]
                {
                        R.drawable.roads_1,
                        R.drawable.roads_3,
                        R.drawable.roads_4,
                        R.drawable.roads_5
                };
        pagerAdapter = new ViewPagerAdapter(MainActivity.this, image_array_4);
        roadsViewPager.setAdapter(pagerAdapter);

        // Letting Nature images to appear on screen
        natureText.setText(getString(R.string.icon_up_arrow));
        natureRelative.setBackgroundResource(R.color.colorPrimary);
        natureViewPager.startAnimation(new ScaleAnimationToShow(1.0f, 1.0f, 0.0f, 1.0f, 1000, natureViewPager, true));
        openLayout = ScaleAnimationToShow.openLayout;

        scrollView.smoothScrollTo(0, relativeLayout.getTop());
    }

    private void hideOtherLayouts(View view)
    {
        int visibility;

        if(view == natureRelative)
        {
            visibility = natureViewPager.getVisibility();

            if(visibility != View.VISIBLE)
            {
                natureViewPager.setVisibility(View.VISIBLE);
            }

            hideAllLayouts();

            if(visibility != View.VISIBLE)
            {
                natureText.setText(getString(R.string.icon_up_arrow));
                natureRelative.setBackgroundResource(R.color.colorPrimary);
                natureViewPager.startAnimation(new ScaleAnimationToShow(1.0f, 1.0f, 0.0f, 1.0f, 1000, natureViewPager, true));
                openLayout = ScaleAnimationToShow.openLayout;

                scrollView.smoothScrollTo(0, relativeLayout.getTop());
            }
        }
        else if(view == flowersRelative)
        {
            visibility = flowersViewPager.getVisibility();

            if(visibility != View.VISIBLE)
            {
                flowersViewPager.setVisibility(View.VISIBLE);
            }

            hideAllLayouts();

            if(visibility != View.VISIBLE)
            {
                flowersText.setText(getString(R.string.icon_up_arrow));
                flowersRelative.setBackgroundResource(R.color.colorPrimary);
                flowersViewPager.startAnimation(new ScaleAnimationToShow(1.0f, 1.0f, 0.0f, 1.0f, 1000, flowersViewPager, true));
                openLayout = ScaleAnimationToShow.openLayout;

                scrollView.smoothScrollTo(0, relativeLayout.getTop());
            }
        }
        else if(view == babiesRelative)
        {
            visibility = babiesViewPager.getVisibility();

            if(visibility != View.VISIBLE)
            {
                babiesViewPager.setVisibility(View.VISIBLE);
            }

            hideAllLayouts();

            if(visibility != View.VISIBLE)
            {
                babiesText.setText(getString(R.string.icon_up_arrow));
                babiesRelative.setBackgroundResource(R.color.colorPrimary);
                babiesViewPager.startAnimation(new ScaleAnimationToShow(1.0f, 1.0f, 0.0f, 1.0f, 1000, babiesViewPager, true));
                openLayout = ScaleAnimationToShow.openLayout;

                scrollView.smoothScrollTo(0, relativeLayout.getTop());
            }
        }
        else if(view == roadsRelative)
        {
            visibility = roadsViewPager.getVisibility();

            if(visibility != View.VISIBLE)
            {
                roadsViewPager.setVisibility(View.VISIBLE);
            }

            hideAllLayouts();

            if(visibility != View.VISIBLE)
            {
                roadsText.setText(getString(R.string.icon_up_arrow));
                roadsRelative.setBackgroundResource(R.color.colorPrimary);
                roadsViewPager.startAnimation(new ScaleAnimationToShow(1.0f, 1.0f, 0.0f, 1.0f, 1000, roadsViewPager, true));
                openLayout = ScaleAnimationToShow.openLayout;

                scrollView.smoothScrollTo(0, relativeLayout.getTop());
            }
        }
    }

    private void hideAllLayouts()
    {
        if(openLayout == null)
            return;

        if(openLayout == natureViewPager)
        {
            natureText.setText(getString(R.string.icon_down_arrow));
            natureRelative.setBackgroundResource(android.R.color.black);
            natureViewPager.startAnimation(new ScaleAnimationToHide(1.0f, 1.0f, 1.0f, 0.0f, 1000, natureViewPager, true));
            openLayout = ScaleAnimationToHide.openLayout;
        }
        if(openLayout == flowersViewPager)
        {
            flowersText.setText(getString(R.string.icon_down_arrow));
            flowersRelative.setBackgroundResource(android.R.color.black);
            flowersViewPager.startAnimation(new ScaleAnimationToHide(1.0f, 1.0f, 1.0f, 0.0f, 1000, flowersViewPager, true));
            openLayout = ScaleAnimationToHide.openLayout;
        }
        if(openLayout == babiesViewPager)
        {
            babiesText.setText(getString(R.string.icon_down_arrow));
            babiesRelative.setBackgroundResource(android.R.color.black);
            babiesViewPager.startAnimation(new ScaleAnimationToHide(1.0f, 1.0f, 1.0f, 0.0f, 1000, babiesViewPager, true));
            openLayout = ScaleAnimationToHide.openLayout;
        }
        if(openLayout == roadsViewPager)
        {
            roadsText.setText(getString(R.string.icon_down_arrow));
            roadsRelative.setBackgroundResource(android.R.color.black);
            roadsViewPager.startAnimation(new ScaleAnimationToHide(1.0f, 1.0f, 1.0f, 0.0f, 1000, roadsViewPager, true));
            openLayout = ScaleAnimationToHide.openLayout;
        }
    }
}
