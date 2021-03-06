package com.palapol.tsp_sesaminar_team02;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    ImageView student;
    ImageView teacher;
    String username;
    String WgId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        student.setOnClickListener(this);
        teacher.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        WgId = extras.getString("WgID");
        if (WgId.equals("16")){
            student.setVisibility(View.GONE);

        }else if(WgId.equals("15")){
            teacher.setVisibility(View.GONE);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void init() {
        student = findViewById(R.id.student);
        teacher = findViewById(R.id.theacher);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        Fragment serchCatecgoryFragment;
        Fragment seminarGroupFragment;

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            serchCatecgoryFragment = new SerchCatecgoryFragment();
            FragmentManager fm = getFragmentManager();// อันนี้
            FragmentTransaction ft = fm.beginTransaction(); //อันนี้เป็นคำสั่งเดิมของ Fragment
            ft.replace(R.id.layout_for_Fragment, serchCatecgoryFragment);//เปลี่ยนจากหน้าไหนไปหน้าไหน ไอดีหน้า ที่ต้องการให้เปลี่ยน layout_for_fragment แล้วเลือกหน้าที่เราจะเอามาแทนคือbookStorefragment
            ft.commit();
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student : {
                Toast.makeText(this,"Student",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.theacher : {
                Toast.makeText(this,"Teacher",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
