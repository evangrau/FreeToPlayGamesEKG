 package com.example.freetoplaygamesekg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;

 public class MainActivity extends AppCompatActivity {

     Button gameButton;
     TextView textView;

     // Gets a random id number to generate a random game from the API
     int min = 1, max = 540;
     int id = (int) Math.floor(Math.random()*(max-min+1)+min);

     GameModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameButton = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJson();
//                startNewActivity();
            }
        });
    }

    private void getJson() {
        String url = "https://free-to-play-games-database.p.rapidapi.com/api/game?id=" + id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        Gson gson = new Gson();
//                        String json = String.valueOf(response);
//                        model = gson.fromJson(json, GameModel.class);
                        textView.setText("Response is: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        })

        {

            /** Passing some request headers* */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("X-RapidAPI-Host", "free-to-play-games-database.p.rapidapi.com");
                headers.put("X-RapidAPI-Key", "3dd8cbd195msh5a03844d8648d59p144f23jsna6f80a74792b");
                return headers;
            }
        };

        // Adding the request to the queue along with a unique string tag
        App.getInstance().addToRequestQueue(jsonObjectRequest,"headerRequest");
    }

    private void startNewActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
 }