package com.example.android.tennisarbiter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int playerApoints = 0;
    int playerAgems = 0;
    int playerAsets = 0;

    int playerBpoints = 0;
    int playerBgems = 0;
    int playerBsets = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForPlayerA(0);
    }
    // adds points for player A, when reaches over 40 goes
    // back to 0 and triggers method adding a gem
    public void playerAscores (View v) {
        if (playerApoints == 30) {
            playerApoints = playerApoints + 10;
            displayForPlayerA(playerApoints);
        }
        else {
            if (playerApoints < 40) {
                playerApoints = playerApoints + 15;
                displayForPlayerA(playerApoints);
            }
            else {
                playerApoints = 0;
                playerBpoints = 0;
                displayForPlayerA(playerApoints);
                displayForPlayerB(playerBpoints);
                addOneGemPlayerA ();
            }
        }
    }
    // adds gems for player A, when reaches over 5
    // goes back to 0 and triggers method adding a set
    public void addOneGemPlayerA () {
        playerAgems++;
        if (playerAgems <6)
            displayForPlayerAgems(playerAgems);
        else {
            displayForPlayerAgems(0);
            playerAgems = 0;
            displayForPlayerBgems(0);
            playerBgems = 0;
            addOneSetPlayerA ();
        }

    }
    // adds sets for player B, when reaches over 2
    // announces Player A as a winner
    public void addOneSetPlayerA() {
        playerAsets++;
        if (playerAsets <3)
            displayForPlayerAsets(playerAsets);
        else {
            displayForPlayerBsets(playerAsets);
            displayResult("Player A wins");
        }
    }

    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.pointsA);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForPlayerAgems(int score) {
        TextView scoreView = (TextView) findViewById(R.id.gemsA);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForPlayerAsets(int score) {
        TextView scoreView = (TextView) findViewById(R.id.setsA);
        scoreView.setText(String.valueOf(score));
    }

    public void displayResult(String score) {
        TextView scoreView = (TextView) findViewById(R.id.result);
        scoreView.setText(String.valueOf(score));
    }


    // -------------------------------------
    // ---------- player B -----------------
    // -------------------------------------


    // adds points for player B, when reaches over 40 goes
    // back to 0 and triggers method adding a gem
    public void playerBscores (View v) {
        if (playerBpoints == 30) {
            playerBpoints = playerBpoints + 10;
            displayForPlayerB(playerBpoints);
        }
        else {
            if (playerBpoints < 40) {
                playerBpoints = playerBpoints + 15;
                displayForPlayerB(playerBpoints);
            }
            else {
                playerBpoints = 0;
                playerApoints = 0;
                displayForPlayerA(playerApoints);
                displayForPlayerB(playerBpoints);
                addOneGemPlayerB ();
            }
        }
    }
    // adds gems for player B, when reaches over 5
    // goes back to 0 and triggers method adding a set
    public void addOneGemPlayerB () {
        playerBgems++;
        if (playerBgems <6)
            displayForPlayerBgems(playerBgems);
        else {
            displayForPlayerBgems(0);
            playerBgems = 0;
            displayForPlayerAgems(0);
            playerAgems = 0;
            addOneSetPlayerB ();
        }

    }
    // adds sets for player B, when reaches over 2
    // announces Player B as a winner
    public void addOneSetPlayerB() {
        playerBsets++;
        if (playerBpoints > 40 && playerBgems > 5 && playerBsets == 2)
            displayResult("Match ball for Player B!");
        if (playerBsets <3)
            displayForPlayerBsets(playerBsets);
        else {
            displayForPlayerBsets(playerBsets);
            displayResult("Player B wins");
        }

    }

    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.pointsB);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForPlayerBgems(int score) {
        TextView scoreView = (TextView) findViewById(R.id.gemsB);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForPlayerBsets(int score) {
        TextView scoreView = (TextView) findViewById(R.id.setsB);
        scoreView.setText(String.valueOf(score));
    }

    public void reset (View v) {

        playerApoints = 0;
        playerAgems = 0;
        playerAsets = 0;

        playerBpoints = 0;
        playerBgems = 0;
        playerBsets = 0;

        displayForPlayerA(0);
        displayForPlayerAgems(0);
        displayForPlayerAsets(0);

        displayForPlayerB(0);
        displayForPlayerBgems(0);
        displayForPlayerBsets(0);

        displayResult("");
    }

}
