package com.example.smeetbhatt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;//0 for cross
    int gameState[]={2,2,2,2,2,2,2,2,2};//2 for not played
    int tappedLocation;
    int winningLocations[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameOver=false;
    int c1=0,c2=0;
    int count=0;
    TextView player1Name,player2Name,player1s,player2s,playerTurn;

    public void gameLogic(View view){
        ImageView imageView=(ImageView) view;
        tappedLocation = Integer.parseInt(view.getTag().toString());

        if(gameState[tappedLocation]==2 && !gameOver){
            gameState[tappedLocation]=activePlayer;
            if(activePlayer==0){

                imageView.setImageResource(R.drawable.tictactoecross);
                activePlayer=1;
            }

            else if(activePlayer==1){

                imageView.setImageResource(R.drawable.tictactoecircle);
                activePlayer=0;
            }

        }

        for (int[] winningPosition : winningLocations) {

            if(gameState[winningPosition[0]] == gameState[winningPosition[1]]
                    && gameState[winningPosition[1]] == gameState[winningPosition[2]]&& gameState[winningPosition[0]]!=2){

                if(activePlayer==0) {
                   if(count%2==0 && !gameOver) {
                        c2++;
                        player2s.setText(String.valueOf(c2));
                        Toast.makeText(getApplicationContext(), player2Name.getText().toString()+" is winner", Toast.LENGTH_LONG).show();
                    }
                    else if(gameOver){
                       return;
                   }
                    else {
                        c1++;
                        player1s.setText(String.valueOf(c1));
                        Toast.makeText(getApplicationContext(), player1Name.getText().toString()+" is winner", Toast.LENGTH_LONG).show();
                    }
                    count++;

                }

                if(activePlayer==1) {
                    if(count%2==0 && !gameOver) {
                        c1++;
                        player1s.setText(String.valueOf(c1));
                        Toast.makeText(getApplicationContext(), player1Name.getText().toString()+" is winner", Toast.LENGTH_LONG).show();
                    }
                    else if(gameOver){
                        return;
                    }
                    else {
                        c2++;
                        player2s.setText(String.valueOf(c2));
                        Toast.makeText(getApplicationContext(), player2Name.getText().toString()+" is winner", Toast.LENGTH_LONG).show();
                    }
                    count++;
                }
                gameOver=true;
            }

            
        }
    }

    public void playAgain(View view){
        gameOver=false;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
            gameState[i]=2;

        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++)
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);

        if(count%2==0)
            playerTurn.setText("First Move: "+player1Name.getText().toString());
        else
            playerTurn.setText("First Move: "+player2Name.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        player1Name = (TextView) findViewById(R.id.player1);
        player2Name = (TextView) findViewById(R.id.player2);
        player1s = (TextView) findViewById(R.id.player1s);
        player2s = (TextView) findViewById(R.id.player2s);
        playerTurn = (TextView) findViewById(R.id.playerTurn);

        Intent intent=getIntent();
        player1Name.setText(intent.getStringExtra("firstPlayer").toString());
        player2Name.setText(intent.getStringExtra("secondPlayer").toString());
        playerTurn.setText("First Move: "+player1Name.getText().toString());


    }
}
