package com.example.ianulanday.jsongetstuff;

import android.os.AsyncTask;

import org.json.JSONArray;

/**
 * Created by ianulanday on 2/13/2018.
 */

public class RetrieveJSONData extends AsyncTask<Void, Void, Void>{
    JSONParser parser;
    JSONArray jarray;

    @Override
    protected Void doInBackground(Void... voids) {
        /*jarray = new JSONArray();
        parser = new JSONParser();*/
        jarray = parser.getJSONArray("http://api.giphy.com/v1/gifs/search?q=dogs&api_key=dc6zaTOxFJmzC");
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        //TODO: actually do something here.
    }
}
