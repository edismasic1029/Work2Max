package com.example.work2max;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyWorkouts extends AppCompatActivity {

    private EditText workoutNameEditText;
    private EditText setsEditText;
    private Button addButton;
    private ListView workoutListView;
    private ArrayList<String> workoutList;
    private ArrayAdapter<String> workoutAdapter;

    private TextView timerText;
    private Button startButton;
    private Button stopButton;
    private Handler handler;
    private boolean isTimerStarted;
    private int secondsElapsed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_workouts);

        workoutNameEditText = findViewById(R.id.workout_name_edittext);
        setsEditText = findViewById(R.id.sets_edittext);
        addButton = findViewById(R.id.add_button);
        workoutListView = findViewById(R.id.workout_list);

        workoutList = new ArrayList<>();
        workoutAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, workoutList);
        workoutListView.setAdapter(workoutAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String workoutName = workoutNameEditText.getText().toString();
                String sets = setsEditText.getText().toString();
                String workout = workoutName + " - " + sets + " sets";
                workoutList.add(workout);
                workoutAdapter.notifyDataSetChanged();
                workoutNameEditText.setText("");
                setsEditText.setText("");
            }
        });

        timerText = findViewById(R.id.timer_text);
        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);
        handler = new Handler();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTimerStarted) {
                    isTimerStarted = true;
                    startButton.setVisibility(View.GONE);
                    stopButton.setVisibility(View.VISIBLE);
                    handler.postDelayed(timerRunnable, 1000);
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTimerStarted = false;
                startButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.GONE);
                handler.removeCallbacks(timerRunnable);
            }
        });
    }

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            secondsElapsed++;
            int hours = secondsElapsed / 3600;
            int minutes = (secondsElapsed % 3600) / 60;
            int seconds = secondsElapsed % 60;

            String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            timerText.setText(time);

            handler.postDelayed(this, 1000);
        }
    };
}