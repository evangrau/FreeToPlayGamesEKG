 package com.example.freetoplaygamesekg;

 import android.content.Intent;
 import android.graphics.drawable.Drawable;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.TextView;

 import androidx.appcompat.app.AppCompatActivity;

 import com.android.volley.AuthFailureError;
 import com.android.volley.Cache;
 import com.android.volley.Network;
 import com.android.volley.Request;
 import com.android.volley.RequestQueue;
 import com.android.volley.Response;
 import com.android.volley.VolleyError;
 import com.android.volley.toolbox.BasicNetwork;
 import com.android.volley.toolbox.DiskBasedCache;
 import com.android.volley.toolbox.HurlStack;
 import com.android.volley.toolbox.JsonObjectRequest;

 import org.json.JSONException;
 import org.json.JSONObject;

 import java.io.InputStream;
 import java.net.URL;
 import java.util.HashMap;
 import java.util.Map;

 public class MainActivity extends AppCompatActivity {

     Button gameButton;
     Button webButton;
     TextView gameContent;
     TextView gameTitle;

     // Gets a random id number to generate a random game from the API
     int min = 1, max = 540;
     int id;

     GameModel gameModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameContent = (TextView) findViewById(R.id.gameContent);
        gameTitle = (TextView) findViewById(R.id.gameTitle);

        webButton = (Button) findViewById(R.id.webButton);
        gameButton = (Button) findViewById(R.id.gameButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJson();
                webButton.setVisibility(View.VISIBLE);
            }
        });
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView();
            }
        });
    }

    private void getJson() {
        id = (int) Math.floor(Math.random()*(max-min+1)+min);
        String url = "https://free-to-play-games-database.p.rapidapi.com/api/game?id=" + id;

        RequestQueue requestQueue;

        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);

        // Start the queue
        requestQueue.start();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        // Initializing params for GameModel b/c Gson isn't working
                        // properly and I don't have the time to fix it
                        int gameId = 0;
                        String title = "";
                        String thumbnail = "";
                        String status = "";
                        String sDesc = "";
                        String desc = "";
                        String gameUrl = "";
                        String genre = "";
                        String platform = "";
                        String publisher = "";
                        String developer = "";
                        String releaseDate = "";
                        String freeGameUrl = "";

                        try {
                            // Getting all of the objects from the JSON
                            // b/c Gson is being dumb
                            gameId = response.getInt("id");
                            title = response.getString("title");
                            thumbnail = response.getString("thumbnail");
                            status = response.getString("status");
                            sDesc = response.getString("short_description");
                            desc = response.getString("description");
                            gameUrl = response.getString("game_url");
                            genre = response.getString("genre");
                            platform = response.getString("platform");
                            developer = response.getString("developer");
                            releaseDate = response.getString("release_date");
                            freeGameUrl = response.getString("freetogame_profile_url");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // Initializing the GameModel
                        gameModel = new GameModel(gameId, title, thumbnail, status, sDesc, desc, gameUrl, genre, platform, publisher, developer, releaseDate, freeGameUrl);
                        gameTitle.setText(gameModel.getTitle());
                        gameContent.setText(gameModel.printGameModelDetails());
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
                headers.put("X-RapidAPI-Key", "3dd8cbd195msh5a03844d8648d59p144f23jsna6f80a74792b");
                headers.put("X-RapidAPI-Host", "free-to-play-games-database.p.rapidapi.com");
                return headers;
            }
        };

        requestQueue.add(request);
    }

    private void openWebView() {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", gameModel.getGameUrl());
        startActivity(intent);
    }
 }