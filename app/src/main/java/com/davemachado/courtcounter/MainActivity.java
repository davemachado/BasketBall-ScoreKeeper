package com.davemachado.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.os.SystemClock;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {

    int score_TeamA = 0, score_TeamB = 0;

    Button butnstart, butnreset;
    TextView time;
    long starttime = 0L;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedtime = 0L;
    int t = 1;
    int secs = 0;
    int mins = 0;
    int milliseconds = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butnstart = (Button) findViewById(R.id.start);
        butnreset = (Button) findViewById(R.id.reset);
        time = (TextView) findViewById(R.id.timer);

        butnstart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub

                if (t == 1) {
                    butnstart.setText("Pause");
                    starttime = SystemClock.uptimeMillis();
                    handler.postDelayed(updateTimer, 0);
                    t = 0;
                } else {
                    butnstart.setText("Start");
                    time.setTextColor(Color.BLUE);
                    timeSwapBuff += timeInMilliseconds;
                    handler.removeCallbacks(updateTimer);
                    t = 1;
                }}
        });

        butnreset.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                starttime = 0L;
                timeInMilliseconds = 0L;
                timeSwapBuff = 0L;
                updatedtime = 0L;
                t = 1;
                secs = 0;
                mins = 0;
                milliseconds = 0;
                butnstart.setText("Start");
                handler.removeCallbacks(updateTimer);
                time.setText("00:00:00");
            }});
    }

    public Runnable updateTimer = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - starttime;
            updatedtime = timeSwapBuff + timeInMilliseconds;
            secs = (int) (updatedtime / 1000);
            mins = secs / 60;
            secs = secs % 60;
            milliseconds = (int) (updatedtime % 1000);
            time.setText("" + mins + ":" + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            time.setTextColor(Color.RED);
            handler.postDelayed(this, 0);
        }};

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
