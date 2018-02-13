package com.example.ianulanday.jsongetstuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RetrieveJSONData retrieveJSONData;
    Button dogButton;
    JSONArray jsonArray;    //don't think I need this...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogButton = findViewById(R.id.dog_button);
        jsonArray = new JSONArray();
    }

    //TODO: make this actually bring up an imgur of a dog.
    public void getRandomDog(View view) {
        retrieveJSONData = new RetrieveJSONData();
        retrieveJSONData.execute();
        int i = 0;
    }


}
