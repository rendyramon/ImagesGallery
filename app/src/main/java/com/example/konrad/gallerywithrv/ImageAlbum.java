package com.example.konrad.gallerywithrv;


public class ImageAlbum {

    private String name;
    private int imageResourceId;


    public static final ImageAlbum[] musicAlbums = {
            new ImageAlbum("Album 1", R.drawable.cover1),
            new ImageAlbum("Album 2", R.drawable.cover2),
            new ImageAlbum("Album 3", R.drawable.cover3),
            new ImageAlbum("Album 4", R.drawable.cover4),
            new ImageAlbum("Album 5", R.drawable.cover5),
            new ImageAlbum("Album 6", R.drawable.cover6),
            new ImageAlbum("Album 7", R.drawable.cover7),
            new ImageAlbum("Album 8", R.drawable.cover8),
            new ImageAlbum("Album 9", R.drawable.cover9),
            new ImageAlbum("Album 10", R.drawable.cover10),
            new ImageAlbum("Album 11", R.drawable.cover11),
            new ImageAlbum("Album 12", R.drawable.cover12)
    };


    private ImageAlbum(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;

    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }


}
