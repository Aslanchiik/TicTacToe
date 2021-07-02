package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.tictactoe.databinding.ActivityNameBinding;

public class NameActiv extends AppCompatActivity {

    ActivityNameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        enterNames();
    }

    public void enterNames() {
        String player1 = binding.playerOne.getText().toString();
        String player2 = binding.playerTwo.getText().toString();
        Intent transfer = new Intent(NameActiv.this, MainActivity.class);
        transfer.putExtra("nameOfPLayers", new String[]{player1, player2});
        startActivity(transfer);

    }
}