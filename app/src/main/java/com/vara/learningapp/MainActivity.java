package com.vara.learningapp;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vara.learningapp.downloader.DownloaderActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textUpdate;
    private int noOfTimesClicked = 0;

    private Toolbar toolbar;

    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    String mTitle = "";

//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTitle = (String) getTitle();
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.drawer_list);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
//
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                getActionBar().setTitle(mTitle);
//                invalidateOptionsMenu();
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                getActionBar().setTitle("Select a option");
//                invalidateOptionsMenu();
//            }
//        };
//
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.drawer_list_item, getResources().getStringArray(R.array.navigation_items));
//        mDrawerList.setAdapter(adapter);
//
//        getActionBar().setHomeButtonEnabled(true);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String[] options = getResources().getStringArray(R.array.navigation_items);
//                mTitle = options[position];
//                RiverFragment riverFragment = new RiverFragment();
//
//                Bundle data = new Bundle();
//                data.putInt("position", position);
//                riverFragment.setArguments(data);
//                android.app.FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction ft = fragmentManager.beginTransaction();
//                ft.replace(R.id.content_frame, riverFragment);
//                ft.commit();
//
//                mDrawerLayout.closeDrawer(mDrawerList);
//            }
//        });


        Button clickMeButton = (Button) findViewById(R.id.button_clickme);
        textUpdate = (TextView) findViewById(R.id.textview_textUpdate);

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noOfTimesClicked++;
                String result = "'Click Me' Button got clicked " + noOfTimesClicked + " time";
                if (noOfTimesClicked != 1) {
                    result += "s";
                }
                textUpdate.setText(result);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    /// Options Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

//        if(mDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }

        int id = item.getItemId();
        Intent intent = null;

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "The settings menu got tapped", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_login:
                intent = new Intent(this, LoginActivity.class);
                break;
            case R.id.action_calculator:
                intent = new Intent(this, CalculatorActivity.class);
                break;
            case R.id.action_downloader:
                intent = new Intent(this, DownloaderActivity.class);
                break;
            case R.id.action_newyoutube:
                intent = new Intent(this, StandaloneActivity.class);
                break;
            case R.id.action_youtube:
                intent = new Intent(this, YoutubeActivity.class);
                break;
        }

        if(intent != null) {
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
//        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
//        return super.onPrepareOptionsMenu(menu);
//    }
}
