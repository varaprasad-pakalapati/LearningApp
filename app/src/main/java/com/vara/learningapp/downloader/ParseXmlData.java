package com.vara.learningapp.downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Vara.Pakalapati on 05/10/2015.
 */
public class ParseXmlData {

    private String xmlData;
    private ArrayList<Application> applications;

    public ParseXmlData(String xmlData) {
        this.xmlData = xmlData;
        this.applications = new ArrayList<Application>();
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public boolean process() {
        boolean status = true;
        Application currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        if (this.xmlData == null) {
            return false;
        }

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("entry")) {
                            inEntry = true;
                            currentRecord = new Application();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (inEntry) {
                            if (tagName.equalsIgnoreCase("entry")) {
                                applications.add(currentRecord);
                                inEntry = false;
                            } else if (tagName.equalsIgnoreCase("name")) {
                                currentRecord.setName(textValue);
                            } else if (tagName.equalsIgnoreCase("artist")) {
                                currentRecord.setArtist(textValue);
                            } else if (tagName.equalsIgnoreCase("releaseDate")) {
                                currentRecord.setReleaseDate(textValue);
                            }
                        }
                        break;
                    default:
                        // Nothing to do
                }

                eventType = xpp.next();
            }
        }catch (Exception e) {
            status = false;
            e.printStackTrace();
        }

        for (Application app : applications) {
            Log.d("ParseXmlDaata", "****************");
            Log.d("ParseXmlDaata", "Name: " + app.getName());
            Log.d("ParseXmlDaata", "Artist: " + app.getArtist());
            Log.d("ParseXmlDaata", "Release Date: " + app.getReleaseDate());
        }

        return true;
    }
}
