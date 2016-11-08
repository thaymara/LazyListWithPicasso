package com.example.tmara.lazylistpicasso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<RowModel> mListRowModel;
    private RowListAdapter mAadapterView;

    private static String[] mArraySeries = new String[] { "Supernatural", "Game of Thrones", "Sherlock", "New Girl", "Breaking Bad",
            "Dexter", "House", "Friends", "Gotham", "The Walking Dead",
            "The Killing", "The Big Bang Theory", "Arrow", "The Flash", "The Originals" };

    private static String[] mArrayGeneros = new String[]{ "Terror, Drama, Fantasia", "Aventura, Drama", "Drama", "Comedia", "Drama, Crime, Suspense, Romance Policial",
            "Drama, Suspense, Romance Policial", "Drama, Comedia, Misterio", "Comedia, Romance", "Suspense, Aventura, Drama", "Terror, Drama, Suspense",
            "Drama", "Comedia", "Drama, Aventura", "Aventura, Drama", "Drama" };

    private static String[] mArrayImages = new String[] {
            "http://www.supernaturalwiki.com/images/2/2a/Supernatural_S5_Poster_02.jpg",
            "http://images4.fanpop.com/image/photos/20000000/Game-of-Thrones-Poster-game-of-thrones-20026735-1728-2560.jpg",
            "http://stuffpoint.com/sherlock/image/111943-sherlock-sherlock-poster.jpg",
            "http://a69.g.akamai.net/n/69/10688/v1/img5.allocine.fr/acmedia/medias/nmedia/19/03/05/79/20672331.jpg",
            "http://www.queroposters.com.br/media/catalog/product/cache/1/image/800x800/9df78eab33525d08d6e5fb8d27136e95/s/p/sp0185-breaking-bad.jpg",
            "http://cdn2-www.comingsoon.net/assets/uploads/2013/05/file_103758_1_dexter-8.jpg",
            "https://verseries.files.wordpress.com/2008/09/cartaz1dddd1.jpg",
            "https://www.movieposter.com/posters/archive/main/78/MPW-39449",
            "http://www.ligadoemserie.com.br/wp-content/uploads/2015/08/Gotham2.jpg",
            "http://mlb-s2-p.mlstatic.com/the-walking-dead-poster-grande-60x84cm-twd-cartaz-decorativo-164511-MLB20568981046_012016-F.jpg",
            "http://images.amcnetworks.com/amc.com/wp-content/uploads/mt-legacy/the-killing/keyart-560.jpg",
            "http://s-cdn.serienjunkies.de/big-bang-theory/poster/the-big-bang-theory-poster-season7.jpg",
            "https://cbscwdetroit2.files.wordpress.com/2015/09/arrow-season-1-posters-3.jpg",
            "http://mlb-s1-p.mlstatic.com/poster-hd-84x60cm-serie-tv-the-flash-supernatural-twd-gotham-20961-MLB20199934020_112014-F.jpg",
            "https://uauposters.com.br/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/2/7/277720140617-uau-posters-series-the-originals.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);

        LoadItems();
        mAadapterView = new RowListAdapter(getBaseContext(), mListRowModel);

        mListView.setAdapter(mAadapterView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RowModel mObjRowModel = (RowModel) mListView.getItemAtPosition(position);
                //Toast.makeText(MainActivity.this, "teste", Toast.LENGTH_SHORT).show();
                NextView(mObjRowModel.getImage(), mObjRowModel.getTitle());
            }
        });
    }

    private void LoadItems(){
        mListRowModel = new ArrayList<RowModel>(mArraySeries.length);
        for(int x=0; x<mArraySeries.length; x++){
            RowModel mRowModel = new RowModel(
                    mArrayImages[x],
                    mArraySeries[x],
                    mArrayGeneros[x]
            );
            mListRowModel.add(mRowModel);
        }
    }

    private void NextView(String image, String title){
        Intent myIntent = new Intent(MainActivity.this, ViewImage.class);
        myIntent.putExtra("fullImage", image);
        myIntent.putExtra("title", title);
        startActivity(myIntent);
    }
}