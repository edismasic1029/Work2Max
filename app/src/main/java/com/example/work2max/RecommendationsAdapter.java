package com.example.work2max;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RecommendationsAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private ArrayList<String> mWorkoutNames;
    private ArrayList<String> mWorkoutInfo;
    private ArrayList<Integer> mPhotoPool;

    public RecommendationsAdapter(Context context, ArrayList<String> workoutNames, ArrayList<String> workoutInfo, ArrayList<Integer> photoPool) {
        super(context, 0, workoutNames);
        mContext = context;
        mWorkoutNames = workoutNames;
        mWorkoutInfo = workoutInfo;
        mPhotoPool = photoPool;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.recommendations_list_item, parent, false);
        }

        String currentWorkoutName = mWorkoutNames.get(position);
        String currentWorkoutInfo = mWorkoutInfo.get(position);
        int currentPhoto = mPhotoPool.get(position);

        TextView workoutNameTextView = listItem.findViewById(R.id.workout_name_textview);
        workoutNameTextView.setText(currentWorkoutName);

        TextView workoutInfoTextView = listItem.findViewById(R.id.workout_info_textview);
        workoutInfoTextView.setText(currentWorkoutInfo);

        ImageView workoutImageView = listItem.findViewById(R.id.workout_imageview);
        workoutImageView.setImageResource(currentPhoto);

        return listItem;
    }
}