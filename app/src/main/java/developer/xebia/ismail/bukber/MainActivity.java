package developer.xebia.ismail.bukber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * Created by Helmi on 5/24/2016.
 */
public class MainActivity extends AppCompatActivity {
    private boolean Back = true;

    private Toolbar toolbar;

    private RippleLayout event;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_nav);
        ab.setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),AddActivity.class);
                startActivity(intent);
            }
        });

        viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));
        viewPagerTab.setViewPager(viewPager);


        findViewById(R.id.event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),DetailActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Request.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),AboutActivity.class);
                startActivity(intent);
            }
        });

        //MaterialRippleLayout request = (MaterialRippleLayout)findViewById(R.id.request);
        //request.setOnClickListener(this);
    }


    // aneh FC klo ane buat gini ?
    //@Override
    //public void onClick(View view) {
    //    switch (view.getId()) {
    //        case R.id.event:
    //            startActivity(new Intent(this, DetailActivity.class));
    //           break;
    //        case R.id.request:
    //           startActivity(new Intent(this, DetailActivity.class));
    //            break;
    //    }
    // }

    @Override
    protected void onPause() {
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        super.onPause();
    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, Activity.class));
    }

    class TabsAdapter extends FragmentPagerAdapter {
        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new FragmentEvent();
                case 1:
                    return new FragmentAttended();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "EXPLORE";
                case 1:
                    return "ATTENDED";
            }
            return "";
        }
    }
}
