package com.example.projectipc;

import android.graphics.Bitmap;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LokasiAsset {
private int id_number_lokasi;
private String id_lokasi;
private String lokasi;
private String ImageURL;
ArrayList<LokasiAsset>hasil;


    public String getImageURL() {

        return ImageURL;
    }

    public void setImageURL(String imageURL)
    {
        ImageURL = imageURL;
    }



    public Bitmap getImage() {
        return Image;
    }

    public void setImage(Bitmap image) {
        Image = image;
    }

    private Bitmap Image;



    public int getId_number_lokasi() {
        return id_number_lokasi;
    }

    public void setId_number_lokasi(int id_number_lokasi) {
        this.id_number_lokasi = id_number_lokasi;
    }

    public String getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(String id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }






}
