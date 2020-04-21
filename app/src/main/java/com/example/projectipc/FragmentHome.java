package com.example.projectipc;

import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {
    private List<LokasiAsset> Lokasi;

    AdapterAsset AssetAdapter;
    APIService apiService;
    @NonNull
    @BindView(R.id.AssetRecycle)
    RecyclerView Recycler;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View frame = inflater.inflate(R.layout.activity_fragment_home, container,false);
        Recycler =(RecyclerView) frame.findViewById(R.id.AssetRecycle);
        ButterKnife.bind(this,frame);

        Call<ResponLogin> assetCall =  apiService.ShowAsset();
        assetCall.enqueue(new Callback<ResponLogin>() {
            @Override
            public void onResponse(Call<ResponLogin> call, Response<ResponLogin> response) {

                Lokasi = response.body().getHasil();
                Recycler.setHasFixedSize(true);
                final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
                Recycler.setLayoutManager(linearLayoutManager);
                AssetAdapter = new AdapterAsset(getActivity(),Lokasi);
                Recycler.setAdapter(AssetAdapter);

            }

            @Override
            public void onFailure(Call<ResponLogin> call, Throwable t) {

            }
        });












        return frame;




    }






    }




