package com.example.saveme;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class listBencanaAdapter extends RecyclerView.Adapter<listBencanaAdapter.listBencanaViewHolder>{

    private ArrayList<Bencana> dataList;
    Context context;


    public listBencanaAdapter(ArrayList<Bencana> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public listBencanaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_list, parent, false);
        return new listBencanaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(listBencanaViewHolder holder, int position) {
        final Bencana model = dataList.get(position);
        holder.txtJudul.setText(model.getJudul());
        holder.txtJenis.setText(model.getBencana());
        holder.txtLokasi.setText(model.getLokasi());
        Picasso.get().load(model.getGambar()).into(holder.imgBencana);
        holder.constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfilBencana.class);
                intent.putExtra("objek",model);
                Log.d("waktu",model.getWaktu());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class listBencanaViewHolder extends RecyclerView.ViewHolder{
        TextView txtJudul, txtJenis, txtLokasi;
        ImageView imgBencana;
        ConstraintLayout constraint;

        public listBencanaViewHolder(View itemView) {
            super(itemView);
            txtJudul = (TextView) itemView.findViewById(R.id.txtJudul);
            txtJenis = (TextView) itemView.findViewById(R.id.txtJenis);
            txtLokasi = itemView.findViewById(R.id.txtLokasi);
            imgBencana = (ImageView) itemView.findViewById(R.id.imageView2);
            constraint = (ConstraintLayout) itemView.findViewById(R.id.constraint);

        }
    }
}