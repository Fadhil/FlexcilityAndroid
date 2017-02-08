package com.jomcode.flexcility;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jomcode.flexcility.project.dummy.ProjectContent;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, DashboardFragment.OnFragmentInteractionListener,
    com.jomcode.flexcility.project.ProjectFragment.OnListFragmentInteractionListener {
    public static final String PREFS_NAME = "FlexcilityPrefs";
    public static final String USER_PHONE_NUMBER = "com.jomcode.flexcility.USER_PHONE_NUMBER";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        Integer userId = settings.getInt("userId", 0);
        if(userId > 0){
            // Setup the Nav drawer and things
            Log.d("DEBUG", "Setting up Nav Drawer and things");
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            DashboardFragment dashboard = new DashboardFragment();
            dashboard.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, dashboard).commit();
            navigationView.getMenu().getItem(0).setChecked(true);
        } else {
            // Go to Login
            Log.d("DEBUG", "Going to Login");

            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        }



    }

    @Override
    protected void onRestart(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        Integer userId = settings.getInt("userId", 0);
        Log.d("DEBUG", "Restarting main activity" + userId);
        super.onRestart();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        Fragment fragment = new Fragment();


        if (id == R.id.nav_dashboard) {
            Log.d("DEBUG", "In Dashboard Menu");
            fragment = new DashboardFragment();
        } else if (id == R.id.nav_projects) {
            Log.d("DEBUG", "In Projects Index");
            fragment = new com.jomcode.flexcility.project.ProjectFragment();
        } else if (id == R.id.nav_work_requests) {

        } else if (id == R.id.nav_work_orders) {

        }

        showFragment(fragment);

        closeDrawer(item);
        return true;
    }

    public void showFragment(Fragment fragment) {
        fragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).addToBackStack(fragment.toString()).commit();
    }

    private void closeDrawer(MenuItem item) {
        item.setChecked(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void onFragmentInteraction(Uri uri){

        //you can leave it empty
    }
//    @Override
//    public void onListFragmentInteraction(ProjectContent.DummyItem item) {
//        //DisplayMetrics metrics = getResources().getDisplayMetrics();
//
//        //String message = Float.toString(metrics.density);
//
//        Toast toast = Toast.makeText(this,item.toString(),Toast.LENGTH_SHORT);
//        toast.show();
//    }

    @Override
    public void onListFragmentInteraction(ProjectContent.ProjectItem item) {
        Toast toast = Toast.makeText(this,item.toString(), Toast.LENGTH_SHORT);
        toast.show();
    }
}

