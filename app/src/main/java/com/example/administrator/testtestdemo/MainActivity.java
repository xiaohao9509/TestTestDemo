package com.example.administrator.testtestdemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private DemoAdapter adapter;
    private AppBarLayout app_bar;
    private View toolbar1;
    private View toolbar2;

    private ImageView zhangdan;
    private TextView zhangdan_txt;
    private ImageView tongxunlu;
    private ImageView jiahao;
    private ImageView zhangdan2;
    private ImageView shaoyishao;
    private ImageView search;
    private ImageView zhaoxiang;
    private RecyclerView.OnScrollListener mListener;
    private ViewPager pager;
    private View bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app_bar = (AppBarLayout) findViewById(R.id.app_bar);

        zhangdan = (ImageView) findViewById(R.id.img_zhangdan);
        zhangdan_txt = (TextView) findViewById(R.id.img_zhangdan_txt);
        tongxunlu = (ImageView) findViewById(R.id.tongxunlu);
        jiahao = (ImageView) findViewById(R.id.jiahao);
        bottomBar = findViewById(R.id.bottomBar);

        app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float offset = -verticalOffset * 1.0f / appBarLayout.getTotalScrollRange();
                bottomBar.setTranslationY(bottomBar.getHeight() * offset);
            }
        });

        mListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int visiblePosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                    if (visiblePosition == 0) {
                        app_bar.setExpanded(true, true);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        };

        pager = (ViewPager) findViewById(R.id.pager);
        ArrayList<BaseFragment> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            RecyclerFragment recyclerFragment = new RecyclerFragment();
            recyclerFragment.setOnScrollListener(mListener);
            recyclerFragment.setTitle("RecyclerFragment" + i);
            list.add(recyclerFragment);
        }
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        tab.setupWithViewPager(pager);
        pager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), list));
    }

}
