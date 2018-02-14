package com.example.ianulanday.jsongetstuff;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;


/**
 * Created by ianulanday on 2/13/2018.
 */

public class RetrieveJSONData extends AsyncTask<Void, Void, Void>{
    JSONParser parser;
    JSONObject jobject;
    @SuppressLint("StaticFieldLeak")
    Context context;

    /*
     * Using an overloaded constructor here so that I
     * can get the context MainActivity.this from
     * MainAcitivty. I can't just call MainActivity.this
     * here.
     */
    public RetrieveJSONData(Context context){
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        jobject = new JSONObject();
        parser = new JSONParser();
        jobject = parser.getJSONObject("http://api.giphy.com/v1/gifs/search?q=dogs&api_key=dc6zaTOxFJmzC");
        return null;
    }

    /*
    ==========JSON NOTES==============
    Specify JSON object: .getJSONObject("name" or index)
    Specify JSON array: same as above
    Specify JSON something: .getThing
     */

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Random rand = new Random();
        int someIndex = rand.nextInt(25);

        if (jobject != null) {
            try {
                Uri addressUri = Uri.parse(jobject.getJSONArray("data").getJSONObject(someIndex).getString("url"));
                Intent go2doggo = new Intent(Intent.ACTION_VIEW, addressUri);
                context.startActivity(go2doggo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
