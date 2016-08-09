package com.davemachado.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score_TeamA = 0, score_TeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add3_TeamA(View view) {
        score_TeamA = score_TeamA + 3;
        displayForTeamA(score_TeamA);
    }

    public void add2_TeamA(View view) {
        score_TeamA = score_TeamA + 2;
        displayForTeamA(score_TeamA);
    }

    public void add1_TeamA(View view) {
        score_TeamA = score_TeamA + 1;
        displayForTeamA(score_TeamA);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add3_TeamB(View view) {
        score_TeamB = score_TeamB + 3;
        displayForTeamB(score_TeamB);
    }

    public void add2_TeamB(View view) {
        score_TeamB = score_TeamB + 2;
        displayForTeamB(score_TeamB);
    }

    public void add1_TeamB(View view) {
        score_TeamB = score_TeamB + 1;
        displayForTeamB(score_TeamB);
    }

    public void resetScores(View view) {
        score_TeamA = 0;
        score_TeamB = 0;
        displayForTeamA(score_TeamA);
        displayForTeamB(score_TeamB);
    }
}
