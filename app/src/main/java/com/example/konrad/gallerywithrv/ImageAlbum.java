package com.example.konrad.gallerywithrv;


public class ImageAlbum {

    private String name;
    private int imageResourceId;


    public static final ImageAlbum[] musicAlbums = {
            new ImageAlbum("Photo 1", R.drawable.image1),
            new ImageAlbum("Photo 2", R.drawable.image2),
            new ImageAlbum("Photo 3", R.drawable.image3),
            new ImageAlbum("Photo 4", R.drawable.image4),
            new ImageAlbum("Photo 5", R.drawable.image5),
            new ImageAlbum("Photo 6", R.drawable.image6),
            new ImageAlbum("Photo 7", R.drawable.image7),
            new ImageAlbum("Photo 8", R.drawable.image8),
            new ImageAlbum("Photo 9", R.drawable.image9),
            new ImageAlbum("Photo 10", R.drawable.image10),
            new ImageAlbum("Photo 11", R.drawable.image11),
            new ImageAlbum("Photo 12", R.drawable.image12)
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
