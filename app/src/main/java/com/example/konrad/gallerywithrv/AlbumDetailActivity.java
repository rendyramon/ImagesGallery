package com.example.konrad.gallerywithrv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

public class AlbumDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ALBUMNO = "albumNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        int currentPosition = (Integer) getIntent().getExtras().get(EXTRA_ALBUMNO);

        String[] albumNames = new String[ImageAlbum.musicAlbums.length];
        for (int i = 0; i < albumNames.length; i++) {
            albumNames[i] = ImageAlbum.musicAlbums[i].getName();
        }

        int[] albumImages = new int[ImageAlbum.musicAlbums.length];
        for (int i = 0; i < albumImages.length; i++) {
            albumImages[i] = ImageAlbum.musicAlbums[i].getImageResourceId();
        }

        RecyclerView albumRecycler = (RecyclerView) findViewById(R.id.album_detail_recycler);
        albumRecycler.setHasFixedSize(true);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(albumRecycler);

        DetailActivityAdapter adapter = new DetailActivityAdapter(albumImages, albumNames, this);
        albumRecycler.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AlbumDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
        albumRecycler.setLayoutManager(linearLayoutManager);

        albumRecycler.smoothScrollToPosition(currentPosition);

    }

    public void onBackAction(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {

    }
}


