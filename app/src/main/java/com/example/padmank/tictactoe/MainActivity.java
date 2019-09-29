package com.example.padmank.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button reset, b00, b01, b02, b10, b11, b12, b20, b21, b22;
    public TextView p1TV, p2TV;

    private boolean p1Turn = true;

    //counts the number of rounds to see if there's a tie(9 rounds)
    private int roundCount;

    private int p1Points;
    private int p2Points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name1 = intent.getStringExtra(Welcome.EXTRA_TEXT);
        String name2 = intent.getStringExtra(Welcome.EXTRA_TEXT2);


        lifeBringer();
        p1TV.setText(name1 + ": 0");
        p2TV.setText(name2 + ": 0");

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

    }

    @Override
    public void onClick(View view) {
        //if the button is not empty then keep it how it is
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (p1Turn) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("O");
        }

        roundCount++;

        if (checkWin()){
            if(p1Turn){
                p1Wins();
            }
           else {
                p2Wins();
            }
        }
        else if (roundCount == 9){
                tie();
        }
        else{
            p1Turn = !p1Turn;
        }

    }

    private boolean checkWin() {
        if (b00.getText().toString().equals("X") && b01.getText().toString().equals("X") && b02.getText().toString().equals("X")) {
            return true;
        }
        if (b10.getText().toString().equals("X") && b11.getText().toString().equals("X") && b12.getText().toString().equals("X")) {
            return true;
        }
        if (b20.getText().toString().equals("X") && b21.getText().toString().equals("X") && b22.getText().toString().equals("X")) {
            return true;
        }
        if (b00.getText().toString().equals("X") && b10.getText().toString().equals("X") && b20.getText().toString().equals("X")) {
            return true;
        }
        if (b01.getText().toString().equals("X") && b11.getText().toString().equals("X") && b21.getText().toString().equals("X")) {
            return true;
        }
        if (b02.getText().toString().equals("X") && b12.getText().toString().equals("X") && b22.getText().toString().equals("X")) {
            return true;
        }
        if (b00.getText().toString().equals("X") && b11.getText().toString().equals("X") && b22.getText().toString().equals("X")) {
            return true;
        }
        if (b02.getText().toString().equals("X") && b11.getText().toString().equals("X") && b20.getText().toString().equals("X")) {
            return true;
        }


        if (b00.getText().toString().equals("O") && b01.getText().toString().equals("O") && b02.getText().toString().equals("O")) {
            return true;
        }
        if (b10.getText().toString().equals("O") && b11.getText().toString().equals("O") && b12.getText().toString().equals("O")) {
            return true;
        }
        if (b20.getText().toString().equals("O") && b21.getText().toString().equals("O") && b22.getText().toString().equals("O")) {
            return true;
        }
        if (b00.getText().toString().equals("O") && b10.getText().toString().equals("O") && b20.getText().toString().equals("O")) {
            return true;
        }
        if (b01.getText().toString().equals("O") && b11.getText().toString().equals("O") && b21.getText().toString().equals("O")) {
            return true;
        }
        if (b02.getText().toString().equals("O") && b12.getText().toString().equals("O") && b22.getText().toString().equals("O")) {
            return true;
        }
        if (b00.getText().toString().equals("O") && b11.getText().toString().equals("O") && b22.getText().toString().equals("O")) {
            return true;
        }
        if (b02.getText().toString().equals("O") && b11.getText().toString().equals("O") && b20.getText().toString().equals("O")) {
            return true;
        }
        else{
            return false;
        }
    }

    private void p1Wins() {
        Intent intent = getIntent();
        String name1 = intent.getStringExtra(Welcome.EXTRA_TEXT);
        String name2 = intent.getStringExtra(Welcome.EXTRA_TEXT2);

        p1Points++;
        Toast toast =  Toast.makeText(MainActivity.this, name1 + " Wins!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        p1TV.setText(name1 + ":" + p1Points);
        p2TV.setText(name2 + ":" + p2Points);
        resetBoard();
    }

    private void p2Wins() {
        Intent intent = getIntent();
        String name1 = intent.getStringExtra(Welcome.EXTRA_TEXT);
        String name2 = intent.getStringExtra(Welcome.EXTRA_TEXT2);

        p2Points++;
        Toast toast =  Toast.makeText(MainActivity.this, name2 + " Wins!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        p1TV.setText(name1 + ":" + p1Points);
        p2TV.setText(name2 + ":" + p2Points);
        resetBoard();
    }

    private void tie() {
        Intent intent = getIntent();
        String name1 = intent.getStringExtra(Welcome.EXTRA_TEXT);
        String name2 = intent.getStringExtra(Welcome.EXTRA_TEXT2);

        Toast toast =  Toast.makeText(MainActivity.this, "IT'S A TIE!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        p1TV.setText(name1 + ":" + p1Points);
        p2TV.setText(name2 + ":" + p2Points);
        resetBoard();
    }

    private void resetBoard() {
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");

        roundCount = 0;
        p1Turn = true;
    }

    private void resetGame() {
        Intent intent = getIntent();
        String name1 = intent.getStringExtra(Welcome.EXTRA_TEXT);
        String name2 = intent.getStringExtra(Welcome.EXTRA_TEXT2);

        resetBoard();
        p1Points = 0;
        p2Points = 0;
        p1TV.setText(name1 + ": 0");
        p2TV.setText(name2 + ": 0");
    }

    private void lifeBringer() {
        reset = (Button) findViewById(R.id.resetBtn);
        b00 = (Button) findViewById(R.id.btn00);
        b00.setOnClickListener(this);
        b01 = (Button) findViewById(R.id.btn01);
        b01.setOnClickListener(this);
        b02 = (Button) findViewById(R.id.btn02);
        b02.setOnClickListener(this);
        b10 = (Button) findViewById(R.id.btn10);
        b10.setOnClickListener(this);
        b11 = (Button) findViewById(R.id.btn11);
        b11.setOnClickListener(this);
        b12 = (Button) findViewById(R.id.btn12);
        b12.setOnClickListener(this);
        b20 = (Button) findViewById(R.id.btn20);
        b20.setOnClickListener(this);
        b21 = (Button) findViewById(R.id.btn21);
        b21.setOnClickListener(this);
        b22 = (Button) findViewById(R.id.btn22);
        b22.setOnClickListener(this);


        p1TV = (TextView) findViewById(R.id.p1TextView);
        p2TV = (TextView) findViewById(R.id.p2TextView);
    }


}
