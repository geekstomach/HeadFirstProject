package ru.geekstomach.headfirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivity extends AppCompatActivity {

    private int seconds=0;
    private boolean running;
    private boolean wasRunning;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        if(savedInstanceState!=null){
        seconds = savedInstanceState.getInt("seconds");
        running = savedInstanceState.getBoolean("running");
        wasRunning = savedInstanceState.getBoolean("wasRunning");
        }


        runTimer();
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning",wasRunning);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning){
        running = true;
        }
    }

    public void onClickStart(View view){
        running=true;
    }
    public void onClickStop(View view){
        running=false;
    }
    public void onClickRestart(View view){
        running=false;
        seconds = 0;
    }
    public void runTimer(){
        final TextView dialView = findViewById(R.id.dial);
        final Handler handler = new Handler();
       handler.post(new Runnable(){
           @Override
           public void run() {

               int hours = seconds/3600;
               int minutes = (seconds%3600)/60;
               int secs = seconds%60;

               String dialString = String.format(Locale.getDefault(), "%d:%02d:%02d",hours,minutes,secs);
               dialView.setText(dialString);

               if(running){
                    seconds++;
               }

               handler.postDelayed(this,1000);

           }
       });
    }

}
