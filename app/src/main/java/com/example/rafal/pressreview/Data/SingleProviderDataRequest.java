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
 * Created by Rafal on 7/14/2017.
 */

public class SingleProviderDataRequest {

    private final OkHttpClient client = new OkHttpClient();
    private String jsonResponse;
    Uri BASE_CONTENT_URI = Uri.parse("content://rafal.pressreview/providerNews");
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
                }

                jsonResponse = response.body().string();

                try {
                    JSONObject rootJsonObject = new JSONObject(jsonResponse);
                    JSONArray articleJsonArray = rootJsonObject.getJSONArray("articles");

                    for (int i = 0; i < articleJsonArray.length(); i++) {
                        JSONObject articleDataJsonObject = articleJsonArray.getJSONObject(i);
                        String title = articleDataJsonObject.getString("title");
                        String articleUrl = articleDataJsonObject.getString("url");
                        String imageUrl = articleDataJsonObject.getString("urlToImage");

                        values.put(NewsDatabaseHelper.PROVIDER_NEWS_TITLE, title);
                        values.put(NewsDatabaseHelper.PROVIDER_ARTICLE_URL, articleUrl);
                        values.put(NewsDatabaseHelper.PROVIDER_IMAGE_URL, imageUrl);

                        resolver.insert(BASE_CONTENT_URI, values);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

