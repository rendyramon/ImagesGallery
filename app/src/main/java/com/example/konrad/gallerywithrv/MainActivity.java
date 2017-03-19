package com.example.konrad.gallerywithrv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView albumRecycler = (RecyclerView) findViewById(R.id.album_recycler);
        albumRecycler.setHasFixedSize(true);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(albumRecycler);

        int[] albumImages = new int[ImageAlbum.musicAlbums.length];
        for (int i = 0; i < albumImages.length; i++) {
            albumImages[i] = ImageAlbum.musicAlbums[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(albumImages, this);
        albumRecycler.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        albumRecycler.setLayoutManager(gridLayoutManager);


    }
}
