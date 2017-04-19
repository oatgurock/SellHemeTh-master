package com.example.oat.sellhemeth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        Spinner provincet, detail, price;

        private  Okhttp okhttp;
        private  String[] member_arr = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        okhttp = new Okhttp();
        String url = "http://10.0.2.2/co/echojson.php";
        String response = okhttp.getServerResult(url,null);
        List<String> member_list_img = new ArrayList<String>();
        List<String> member_list_user = new ArrayList<String>();
        List<String> member_list_phone = new ArrayList<String>();
        List<String> member_list_id = new ArrayList<String>();


        try {
            JSONArray data = new JSONArray(response);
            member_arr = new String[data.length()];


            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);
                member_list_img.add(c.getString("n"));
                member_list_user.add(c.getString("n1"));
                member_list_phone.add(c.getString("n2"));
                member_list_id.add(c.getString("n3"));
                String  a = String.valueOf(data.length());
                Toast.makeText(getApplicationContext(),a ,Toast.LENGTH_LONG).show();

            }


            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), member_list_img,member_list_user,member_list_phone);


            ListView l = (ListView) findViewById(R.id.lv1);
            l.setAdapter(adapter);
            l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {

                  //  Intent intent = new Intent(main.this, MainActivity.class);
                  //  startActivity(intent);

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }





    /*
*/




        provincet = (Spinner) findViewById(R.id.dropdow);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.province, android.R.layout.simple_spinner_item);
        provincet.setAdapter(adapter);
        detail = (Spinner) findViewById(R.id.dropdow2);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.detail, android.R.layout.simple_spinner_item);
        detail.setAdapter(adapter1);
        price = (Spinner) findViewById(R.id.dropdow3);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.price, android.R.layout.simple_spinner_item);
        price.setAdapter(adapter2);







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;



    }


}
