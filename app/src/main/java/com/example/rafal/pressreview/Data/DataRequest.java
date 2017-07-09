package com.example.rafal.pressreview.Data;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.rafal.pressreview.Utilities.RetriveMyApplicationContext.getAppContext;

/**
 * Created by Rafal on 6/27/2017.
 */

public class DataRequest {

    //NewsDatabaseHelper newsDatabaseHelper = new NewsDatabaseHelper(getAppContext());
    private final OkHttpClient client = new OkHttpClient();
    private String jsonResponse;
    private final String LOG_TAG = DataRequest.class.getSimpleName();
    Uri BASE_CONTENT_URI = Uri.parse("content://rafal.pressreview/news");
    ContentResolver resolver = getAppContext().getContentResolver();
    ContentValues values = new ContentValues();

    public void run(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    Log.v(LOG_TAG, responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                jsonResponse = response.body().string();
                Log.v("TRY ME", jsonResponse);
                try {
                    JSONObject rootJsonObject = new JSONObject(jsonResponse);
                    JSONArray articleJsonArray = rootJsonObject.getJSONArray("articles");
                    //newsDatabaseHelper.dropAndRecreateDatabase();
                    for (int i = 0; i < articleJsonArray.length(); i++){
                        JSONObject articleDataJsonObject = articleJsonArray.getJSONObject(i);
                        String title = articleDataJsonObject.getString("title");
                        String description = articleDataJsonObject.getString("description");
                        String articleUrl = articleDataJsonObject.getString("url");
                        String imageUrl = articleDataJsonObject.getString("urlToImage");

                        values.put(NewsDatabaseHelper.TITLE, title);
                        values.put(NewsDatabaseHelper.DESCRIPTION, description);
                        values.put(NewsDatabaseHelper.ARTICLE_URL, articleUrl);
                        values.put(NewsDatabaseHelper.IMAGE_URL, imageUrl);

                        resolver.insert(BASE_CONTENT_URI, values);
                    }
                    //TODO: add SQLite, save the data there
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}



