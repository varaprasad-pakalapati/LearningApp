package com.vara.learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    private String GOOGLE_API_KEY = "AIzaSyBAlXbT6FFnEwiOmjfcN8_BU8zOmN8bCHA";
    private String YOUTUBE_VIDEO_ID = "Zc7SeDL-0uE";
    private String YOUTUBE_PLAYLIST_ID = "PLXtTjtWmQhg3aTiE0y_iO_DRlKtTiv519";

    private Button btnPlayVideo;
    private Button btnPlayPlaylist;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayvideo);
        btnPlayPlaylist = (Button) findViewById(R.id.btnPlaylist);

        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);

        // Creates items on action bar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // Adds parent activity navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()) {
            case R.id.btnPlayvideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST_ID);
                break;
            default:
        }

        if(intent != null)
            startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
            Toast toastMessage = Toast.makeText(this, "The settings menu got tapped", Toast.LENGTH_LONG);
            toastMessage.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
