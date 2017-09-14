package com.example.smeetbhatt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NamesActivity extends AppCompatActivity {

    EditText firstPlayer,secondPlayer;
    Button playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        firstPlayer = (EditText) findViewById(R.id.firstPlayerEditText);
        secondPlayer = (EditText) findViewById(R.id.secondPlayerEditText);
        playButton = (Button) findViewById(R.id.playButton);

        secondPlayer.setOnEditorActionListener(new EditText.OnEditorActionListener() {


            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    playButton.performClick();
                    return true;
                }
                return false;
            }
        });

            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(!firstPlayer.getText().toString().isEmpty() &&
                            !secondPlayer.getText().toString().isEmpty() &&
                                !firstPlayer.getText().toString().equals(secondPlayer.getText().toString())) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("firstPlayer", firstPlayer.getText().toString());
                        intent.putExtra("secondPlayer", secondPlayer.getText().toString());
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Please Enter Name",Toast.LENGTH_SHORT).show();
                    }


                }
            });
    }
}

