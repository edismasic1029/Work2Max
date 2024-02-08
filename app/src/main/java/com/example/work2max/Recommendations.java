package com.example.work2max;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class Recommendations extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Integer> mPhotoPool;
    private ArrayList<String> mWorkoutNames;
    private ArrayList<String> mWorkoutInfo;
    private RecommendationsAdapter mAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        mListView = findViewById(R.id.listView);
        mPhotoPool = new ArrayList<>();
        mWorkoutNames = new ArrayList<>();
        mWorkoutInfo = new ArrayList<>();

        setupPhotoPool();
        setupWorkoutNames();
        setupWorkoutInfo();

        mAdapter = new RecommendationsAdapter(this, mWorkoutNames, mWorkoutInfo, mPhotoPool);
        mListView.setAdapter(mAdapter);
    }

    private void setupPhotoPool() {
        mPhotoPool.add(R.drawable.benchpress);
        mPhotoPool.add(R.drawable.legpress);
        mPhotoPool.add(R.drawable.shoulderpress);
        mPhotoPool.add(R.drawable.inclinedb);
        mPhotoPool.add(R.drawable.overhead_press);
        mPhotoPool.add(R.drawable.calfraise);
        mPhotoPool.add(R.drawable.pushup);
        mPhotoPool.add(R.drawable.lat);
        mPhotoPool.add(R.drawable.squat);
    }

    private void setupWorkoutNames() {
        mWorkoutNames.add("Bench Press");
        mWorkoutNames.add("Leg Press");
        mWorkoutNames.add("Shoulder Press");
        mWorkoutNames.add("Incline Dumbbell Press");
        mWorkoutNames.add("Overhead Press");
        mWorkoutNames.add("Calf Raise");
        mWorkoutNames.add("Pushup");
        mWorkoutNames.add("Lat Pulldown");
        mWorkoutNames.add("Squat");
    }

    private void setupWorkoutInfo() {
        mWorkoutInfo.add("The bench press is a classic exercise for building a strong chest, shoulders, and triceps.");
        mWorkoutInfo.add("The leg press is a great exercise for strengthening the quads, hamstrings, and glutes.");
        mWorkoutInfo.add("The shoulder press is an effective exercise for building strong shoulders and upper back.");
        mWorkoutInfo.add("The incline dumbbell press targets the upper chest muscles and is a great variation on the standard bench press.");
        mWorkoutInfo.add("The overhead press is a compound exercise that targets the shoulders and triceps.");
        mWorkoutInfo.add("The calf raise is an isolation exercise that targets the calf muscles.");
        mWorkoutInfo.add("Pushups are a classic bodyweight exercise that target the chest, shoulders, and triceps.");
        mWorkoutInfo.add("The lat pulldown is a machine exercise that targets the back and biceps.");
        mWorkoutInfo.add("The squat is a compound exercise that targets the quads, hamstrings, and glutes.");
    }
}