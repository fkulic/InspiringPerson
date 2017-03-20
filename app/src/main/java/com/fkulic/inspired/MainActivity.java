package com.fkulic.inspired;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    ArrayList<InspiringPerson> inspiringPeople = new ArrayList<InspiringPerson>();
    ListView lwInspiringPeople;
    PersonAdapter mPersonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lwInspiringPeople = (ListView) findViewById(R.id.lwInspiringPeople);
        parseJSON(loadJSON());
        mPersonAdapter = new PersonAdapter(this, inspiringPeople);
        lwInspiringPeople.setAdapter(mPersonAdapter);
        lwInspiringPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InspiringPerson person = (InspiringPerson) mPersonAdapter.getItem(position);
                Toast.makeText(getApplicationContext(), "\"" + person.getQuote() + "\"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String loadJSON() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            Log.d(TAG, "loadJSON: read " + is.read(buffer) + " bytes.");
            is.close();
            json = new String(buffer);
            Log.d("data", json);

        } catch (IOException e) {
            Toast.makeText(this, "Unable to load JSON", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "loadJSON: Unable to load JSON: " + e.getMessage());
        }

        return json;
    }

    private void parseJSON(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String lifespan = jsonObject.getString("lifespan");
                String img = jsonObject.getString("img");
                int imgLoc = getResources().getIdentifier(img, "drawable", getPackageName());
                String bio = jsonObject.getString("shortbio");
                String quote = jsonObject.getString("quote");

                InspiringPerson ip = new InspiringPerson(name, lifespan, imgLoc, bio, quote);
                inspiringPeople.add(ip);
            }

        } catch (JSONException e) {
            Toast.makeText(this, "Unable to parse JSON", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "parseJSON: Unable to parse JSON: " + e.getMessage());
        }


    }

}
