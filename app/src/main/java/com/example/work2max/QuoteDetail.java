package com.example.work2max;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuoteDetail extends AppCompatActivity {
    private ImageView mImageView;
    private TextView mQuote;
    private int mPosition;
    private DataSource mDataSource;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_detail);

        Intent i = getIntent();
        mPosition = i.getIntExtra("position", 0);

        mDataSource = new DataSource();
        mImageView = findViewById(R.id.image);
        mQuote = findViewById(R.id.quote);
        mImageView.setImageResource(mDataSource.getmPhotoPool().
                get(mPosition));

        mQuote.setText(getResources().getString(mDataSource.getmQuotePool()
                .get(mPosition)));
    }
}