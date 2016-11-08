package com.example.tmara.lazylistpicasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ViewImage extends AppCompatActivity {

    private ImageView mFullImage;
    private String mImage;
    private String mTitle = "Lazy List with Picasso";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        mFullImage = (ImageView) findViewById(R.id.imgFullImage);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            mImage = extras.getString("fullImage");
            mTitle = extras.getString("title");
        }

        //setTitle(mTitle);

        Picasso.with(ViewImage.this)
                .load(mImage)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(mFullImage);
    }
}
