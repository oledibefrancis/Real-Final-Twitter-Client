package com.codepath.apps.restclienttemplate.models;

import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Parcel
public class Tweet {
    public String body;
    public String createdAt;
    public User user;
    public String imageurl;



    public Tweet() {
    }

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.createdAt=jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.imageurl ="";



        if(jsonObject.has("full_text")) {
            tweet.body = jsonObject.getString("full_text");
        }
        else {
            tweet.body = jsonObject.getString("text");
        }
        tweet.imageurl = getEntity(jsonObject.getJSONObject("entities"));
        return tweet;

    }

    public static String getEntity(JSONObject jsonObject) throws JSONException{
        JSONArray allMedia = jsonObject.has("media") ? jsonObject.getJSONArray("media"):null;
        String url = "";
        if (allMedia != null){
            url = allMedia.getJSONObject(0).getString("media_url_https");
        }
        return url;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
}