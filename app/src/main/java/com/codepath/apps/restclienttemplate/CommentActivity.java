package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class CommentActivity extends AppCompatActivity {
    String value;
    TextView replyUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);



        replyUser = findViewById(R.id.replyUser);
        Bundle  extra = getIntent().getExtras();
        value = getIntent().getStringExtra("key");
        replyUser.setText(value);

    }
}