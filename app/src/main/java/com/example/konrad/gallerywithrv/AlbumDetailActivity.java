package com.example.konrad.gallerywithrv;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AlbumDetailActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    public static final String EXTRA_ALBUMNO = "albumNo";
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    private ImageView imageView;
    private TextView nameTextView;
    private String albumName;
    private int albumImage;
    private int albumNo;
    private int albumLength;

//    large heap, hardwareacceleration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        AlphaAnimation animationAlpha = new AlphaAnimation(0.2f, 1.0f);
        animationAlpha.setDuration(700);

        albumLength = ImageAlbum.musicAlbums.length;
        Log.d(DEBUG_TAG, "oalbumLen: " + albumLength);
        albumNo = (Integer) getIntent().getExtras().get(EXTRA_ALBUMNO);
        albumName = ImageAlbum.musicAlbums[albumNo].getName();
        nameTextView = (TextView) findViewById(R.id.album_name);
        nameTextView.setText(albumName);

        albumImage = ImageAlbum.musicAlbums[albumNo].getImageResourceId();
        imageView = (ImageView) findViewById(R.id.album_image);
//        imageView.setAnimation(animationAlpha);
//        imageView.setImageDrawable(getResources().getDrawable(albumImage));

        Glide.with(this).load(albumImage).animate(animationAlpha).into(imageView);

        mDetector = new GestureDetectorCompat(this, this);
    }

    public void onSwipeRight() {
        if (albumNo >= 1) {
            albumNo--;
            updateScreen();
        }
    }

    public void onSwipeLeft() {
        if (albumNo <= albumLength - 2) {
            albumNo++;
            updateScreen();
        }
    }

    private void updateScreen() {
        albumName = ImageAlbum.musicAlbums[albumNo].getName();
        nameTextView.setText(albumName);

        albumImage = ImageAlbum.musicAlbums[albumNo].getImageResourceId();
        AlphaAnimation animationAlpha = new AlphaAnimation(0.2f, 1.0f);
        animationAlpha.setDuration(700);

//        imageView.setAnimation(animationAlpha);
//        imageView.setImageDrawable(getResources().getDrawable(albumImage));
        Glide.with(this).load(albumImage).animate(animationAlpha).into(imageView);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                    result = true;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public void onLongPress(MotionEvent event) {

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }

    public void onBackAction(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {

    }
}


