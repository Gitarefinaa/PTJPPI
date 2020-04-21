package com.example.projectipc;

import android.content.Context;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
public class AdapterAsset extends RecyclerView.Adapter<AdapterAsset.AssetHolder>  {
    private ArrayList<LokasiAsset>Lokasi;
    private  Context context;

    public AdapterAsset(Context context, ArrayList<LokasiAsset> Lokasi) {
        this.context=context;
        this.Lokasi=Lokasi;


    }



    public class AssetHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.TextLokasi)TextView TextLokasi;
        @BindView(R.id.ImageLokasi)ImageView ImageLokasi;


        public AssetHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public AdapterAsset(FragmentActivity fragmentHome, List<LokasiAsset> Lokasi){
        this.Lokasi=Lokasi;
    }
    @NonNull
    @Override
    public AssetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View HolderView=layoutInflater.inflate(R.layout.list_asset,parent,false);



        return new AssetHolder(HolderView);
    }
    public int getItem(){
        return (Lokasi!=null)?Lokasi.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull AssetHolder holder, int position) {
        LokasiAsset lokasiAsset = Lokasi.get(position);
        holder.TextLokasi.setText(lokasiAsset.getLokasi());
        Picasso.with(context).load(RequestAPI.BASE_URL +"Image"+ Lokasi.get(position).getImageURL())
                .error(R.drawable.ic_person_black_24dp).into(holder.ImageLokasi);


    }
    public int getItemCount() {
        return Lokasi.size();
    }
}
