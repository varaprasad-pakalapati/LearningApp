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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "The settings menu got tapped", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_login:
                Intent loginActivity = new Intent(this, LoginActivity.class);
                startActivity(loginActivity);
                return true;
            case R.id.action_calculator:
                Intent calculatorActivity = new Intent(this, CalculatorActivity.class);
                startActivity(calculatorActivity);
                return true;
            case R.id.action_downloader:
                Intent downloaderActivity = new Intent(this, DownloaderActivity.class);
                startActivity(downloaderActivity);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
