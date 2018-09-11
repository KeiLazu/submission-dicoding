package com.github.placesinindonesia.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.placesinindonesia.R;
import com.github.placesinindonesia.fragments.DashboardFragment;
import com.github.placesinindonesia.fragments.DetailFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstTimeLoad();

    }

    public void FirstTimeLoad() {
        ToDashboard();
    }

    public void ToDashboard(){
        Fragment fragment = DashboardFragment.newInstance();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_fragment_holder, fragment)
                .commit();
    }

    public void ToDetailFragment(int position) {
        Fragment fragment = DetailFragment.newInstance(position);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_fragment_holder, fragment)
                .addToBackStack(DetailFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudisplay, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.display_list:
                if (getFragmentInMain() instanceof DashboardFragment) {
                    DashboardFragment fragmentInMain = (DashboardFragment) getFragmentInMain();
                    fragmentInMain.UseLinearList();
                }
                break;
            case R.id.display_grid:
                if (getFragmentInMain() instanceof DashboardFragment) {
                    DashboardFragment fragmentInMain = (DashboardFragment) getFragmentInMain();
                    fragmentInMain.UseGridList();
                }
                break;
            case R.id.display_card:
                if (getFragmentInMain() instanceof DashboardFragment) {
                    DashboardFragment fragmentInMain = (DashboardFragment) getFragmentInMain();
                    fragmentInMain.UseCardList();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    Fragment getFragmentInMain() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_fragment_holder);
        if (fragment instanceof DashboardFragment && fragment != null) {
            DashboardFragment dashboardFragment = (DashboardFragment) fragment;
            return dashboardFragment;
        } else {
            return null;
        }
    }

}
