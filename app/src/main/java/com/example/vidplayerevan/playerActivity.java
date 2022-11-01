package com.example.vidplayerevan;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;

import com.halilibo.bvpkotlin.BetterVideoPlayer;

public class playerActivity extends AppCompatActivity {

    BetterVideoPlayer player;
    String filepath;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_player);



        player= findViewById(R.id.player);
        filepath= getIntent().getStringExtra("VIDEO");
        Uri videoUri= Uri.parse(filepath);
        player.setSource(videoUri);

    }


    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }
}