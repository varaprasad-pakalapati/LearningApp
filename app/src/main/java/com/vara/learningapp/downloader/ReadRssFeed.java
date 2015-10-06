package com.vara.learningapp.downloader;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Vara.Pakalapati on 05/10/2015.
 */
public class ReadRssFeed extends AsyncTask<String, Void, String> {

    private String mfileContents;
    private Context context;

    public String getMfileContents() {
        return mfileContents;
    }

    public ReadRssFeed(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        mfileContents = ParseResult(params[0]);
        if (mfileContents == null)
        {
            Log.d("ReadRssFeed", "Error downloading");
        }

        return mfileContents;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d("ReadRssFeed", "Result was: " + result);
        if (result == null) {
            Toast.makeText(context, "Unable to get the feed. Check your data connection", Toast.LENGTH_LONG).show();
        }
    }

    private String ParseResult(String urlPath)
    {
        StringBuffer tempBuffer = new StringBuffer();
        try
        {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Log.d("ReadRssFeed", "Response code: " + connection.getResponseCode());
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int charRead;
            char[] inputBuffer = new char[500];
            while (true)
            {
                charRead = isr.read(inputBuffer);
                if (charRead <= 0)
                {
                    break;
                }
                tempBuffer.append(String.copyValueOf(inputBuffer, 0, charRead));
            }

            return tempBuffer.toString();

        } catch (IOException e) {
            Log.d("ReadRssFeed", "IO Exception reading data: " + e.getMessage());
        } catch (SecurityException e) {
            Log.d("ReadRssFeed", " Security Exception " + e.getMessage());
        }

        return null;
    }
}
