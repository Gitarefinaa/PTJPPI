package com.example.wallpaperapp;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;


import com.squareup.picasso.Picasso;

import java.io.IOException;

public class dialogFragment extends DialogFragment {

    private ImageView imageview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_fragment, container,
                false);

        imageview = (ImageView) rootView.findViewById(R.id.imageView);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);


        Picasso.with(getContext()).load( getArguments().getString("a"))
                .into(imageview);

        Button btn=(Button)rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallpaper();
            }
        });

        return rootView;
    }



    private void setWallpaper() {


        Bitmap bm = ((BitmapDrawable)imageview.getDrawable()).getBitmap();
        WallpaperManager manager = WallpaperManager.getInstance(getContext());
        try{
            manager.setBitmap(bm);
            Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }




}
