package com.example.ianulanday.jsongetstuff;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

/**
 * Created by ianulanday on 2/12/2018.
 */

public class JSONParser {

    //TODO read over this code more

    public JSONObject getJSONObject(String url_str) {
        try {
            URL url = new URL(url_str);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            String result = convertStreamToString(in);
            JSONObject json = new JSONObject(result);
            in.close();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // converts the InputStream to a string and add nl
    private String convertStreamToString(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException | OutOfMemoryError ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return sb.toString();
    }
}
