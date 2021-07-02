package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tictactoe.databinding.ActivityMainBinding;
import com.example.tictactoe.databinding.ActivityNameBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    TextView headerText;

    int PLAYER_O = 0;
    int PLAYER_X = 1;

    int activePlayer = PLAYER_O;

    int[] filledPos = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    boolean isGameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initClick();






    }

    private void initClick() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    private void initView() {
        headerText = findViewById(R.id.win_text);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        // logic for button press

        if(!isGameActive)
            return;

        Button clickedBtn = findViewById(v.getId());
        int clickedTag = Integer.parseInt(v.getTag().toString());

        if(filledPos[clickedTag] != -1){
            return;
        }

        filledPos[clickedTag] = activePlayer;

        if(activePlayer == PLAYER_O){
            clickedBtn.setText("O");
            clickedBtn.setBackgroundColor(Color.parseColor("#fdd31d"));
            activePlayer = PLAYER_X;
        }else{
            clickedBtn.setText("X");
            clickedBtn.setBackgroundColor(Color.parseColor("#5587e5"));
            activePlayer = PLAYER_O;
        }

        checkForWin();

    }

    private void checkForWin(){
        //we will check who is winner and show
        int[][] winningPos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        for(int i =0 ;i<8;i++){
            int val0  = winningPos[i][0];
            int val1  = winningPos[i][1];
            int val2  = winningPos[i][2];

            if(filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2]){
                if(filledPos[val0] != -1){
                    //winner declare

                    isGameActive = false;

                    if(filledPos[val0] == PLAYER_O)
                         showDialog("Player 1 win");
                    else
                        showDialog("PLayer 2 win");
                }
            }
        }
    }
     private  void showDialog (String winnerText){
        new AlertDialog.Builder(this).setTitle(winnerText).setPositiveButton("Restart game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                restartGame();
            }
        }).show();
     }

    private void restartGame() {
        activePlayer = PLAYER_O;
        filledPos = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        initButton();
        isGameActive = true;
    }

    private void initButton() {
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");

//        btn0.setBackgroundColor(Color.parseColor("#b8bfc2"));
//        btn1.setBackgroundColor(Color.parseColor("#b8bfc2"));
//        btn2.setBackgroundColor(Color.parseColor("#b8bfc2"));
//        btn3.setBackgroundColor(Color.parseColor("#b8bfc2"));
//        btn4.setBackgroundColor(Color.parseColor("#b8bfc2"));
//        btn5.setBackgroundColor(Color.parseColor("#b8bfc2"));
//        btn6.setBackgroundColor(Color.parseColor("#b8bfc2"));
//        btn7.setBackgroundColor(Color.parseColor("#b8bfc2"));
//        btn8.setBackgroundColor(Color.parseColor("#$b8bfc2"));
    }
}