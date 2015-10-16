package com.vara.learningapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vara.learningapp.downloader.DownloaderActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textUpdate;
    private int noOfTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        return true;
    }

    /// Options Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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
}
