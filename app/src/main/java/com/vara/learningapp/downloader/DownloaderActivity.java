package com.vara.learningapp.downloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.vara.learningapp.R;

/**
 * Created by Vara.Pakalapati on 05/10/2015.
 */
public class DownloaderActivity extends AppCompatActivity {

    private Button btnParse;
    private ListView xmlListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);

        final ReadRssFeed readRssFeed = new ReadRssFeed(DownloaderActivity.this);
        readRssFeed.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml");

        btnParse = (Button) findViewById(R.id.btnParse);
        xmlListView = (ListView) findViewById(R.id.xmlListView);

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseXmlData parseXmlData = new ParseXmlData(readRssFeed.getMfileContents());
                boolean result = parseXmlData.process();
                if(result) {
                    ArrayAdapter<Application> arrayAdapter = new ArrayAdapter<Application>(
                            DownloaderActivity.this, R.layout.list_item, parseXmlData.getApplications()
                    );
                    xmlListView.setAdapter(arrayAdapter);
                } else {
                    Toast.makeText(DownloaderActivity.this, "Unable to get the feed. Check your data connection", Toast.LENGTH_LONG).show();
                }
            }
        });
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