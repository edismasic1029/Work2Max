package com.example.work2max;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class QuoteReaderActivity extends AppCompatActivity {

    public class QuoteAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mDataSource.getDataSourceLength();
        }

        @Override
        public Object getItem(int position) { return position; }

        @Override
        public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup
                parent)
        {
            ImageView thumbnail;
            TextView quote;

            if(convertView == null) {
                convertView = mInflator.inflate(R.layout.list_item_layout,
                        parent,false);
            }

            thumbnail = convertView.findViewById(R.id.thumb);   thumbnail.setImageResource(mDataSource.getmPhotoPool()
                .get(position));
            quote = convertView.findViewById(R.id.text);
            quote.setText(mDataSource.getmQuotePool().get(position));

            return convertView;
        }

        private Context mContext;
        private LayoutInflater mInflator;
        private DataSource mDataSource;

        public QuoteAdapter(Context c) {
            mContext = c;
            mInflator = (LayoutInflater)
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mDataSource = new DataSource();
        }

    }
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_reader);
        ListView mListView = findViewById(R.id.quotes_list);
        mListView.setAdapter(new QuoteAdapter(this));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View arg1, int
                    position,long arg3) {
                Intent i = new Intent(QuoteReaderActivity.this,
                        QuoteDetail.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });


    }
}
