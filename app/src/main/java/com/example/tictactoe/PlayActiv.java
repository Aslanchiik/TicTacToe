package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class PlayActiv extends AppCompatActivity {


    TextView txtTic;
    Button btnAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        txtTic = findViewById(R.id.text_tictac);
        btnAnim = findViewById(R.id.animation_btn);
        btnAnim.setOnClickListener(v -> {
            startAnimation();
            Intent intent = new Intent(PlayActiv.this, NameActiv.class);
            startActivity(intent);
        });
    }
    public  void  startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        txtTic.startAnimation(animation);
    }
}