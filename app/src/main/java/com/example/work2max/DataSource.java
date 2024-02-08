package com.example.work2max;

import java.util.ArrayList;

public class DataSource {
    private ArrayList<Integer> mPhotoPool;
    private ArrayList<Integer> mQuotePool;




    public ArrayList<Integer> getmPhotoPool() {
        return mPhotoPool;
    }

    public ArrayList<Integer> getmQuotePool() {
        return mQuotePool;
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
    private void setupQuotePool() {
        mQuotePool.add(R.string.quote_1);
        mQuotePool.add(R.string.quote_2);
        mQuotePool.add(R.string.quote_3);
        mQuotePool.add(R.string.quote_4);
        mQuotePool.add(R.string.quote_5);
        mQuotePool.add(R.string.quote_6);
        mQuotePool.add(R.string.quote_7);
        mQuotePool.add(R.string.quote_8);
        mQuotePool.add(R.string.quote_9);
        mQuotePool.add(R.string.quote_10);

    }

    public int getDataSourceLength() {
        return mPhotoPool.size();
    }



    public DataSource() {
        mPhotoPool = new ArrayList();
        mQuotePool = new ArrayList();

        setupPhotoPool();
        setupQuotePool();


    }

}
