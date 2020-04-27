package com.homathon.homecamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.homathon.homecamp.fragment.RealTimeVideoFragment;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class WatchActivity extends AppCompatActivity {
    Button assessButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        assessButton = findViewById(R.id.AssessmentButton);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "3TnzujXQ1PU";
                youTubePlayer.loadVideo(videoId, 0f);
            }
        });

        assessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(WatchActivity.this, AssessActivity.class);
                WatchActivity.this.startActivity(myIntent);
            }
        });
    }
}
