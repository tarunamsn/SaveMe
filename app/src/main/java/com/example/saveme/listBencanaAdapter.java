package com.example.saveme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class listBencanaAdapter extends RecyclerView.Adapter<listBencanaAdapter.listBencanaViewHolder>{

    private ArrayList<listBencana> dataList;
    Context context;


    public listBencanaAdapter(ArrayList<listBencana> dataList, Context context) {
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
        final listBencana model = dataList.get(position);
        holder.txtJudul.setText(model.getJudul());
        holder.txtJawaboleh.setText(model.getLokasi());
        holder.txtIsi.setText(model.getWaktu());
//        Picasso.get().load(model.getGambar()).into(holder.seseorangImg);
        holder.constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfilBencana.class);
                intent.putExtra("objek",model);
//                intent.putExtra("seseorang", model.getSeseorangImg());
//                intent.putExtra("judul", model.getJudul());
//                intent.putExtra("jawab", model.getJawaboleh());
//                intent.putExtra("isi", model.getIsi());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
//        return  dataList.size();
        return (dataList != null) ? dataList.size() : 0;
    }

    public class listBencanaViewHolder extends RecyclerView.ViewHolder{
        TextView txtJudul, txtJawaboleh, txtIsi;
        ImageView seseorangImg;
        ConstraintLayout constraint;

        public listBencanaViewHolder(View itemView) {
            super(itemView);
            txtJudul = (TextView) itemView.findViewById(R.id.txtJudul);
            txtJawaboleh = (TextView) itemView.findViewById(R.id.txtLokasi);
            txtIsi = (TextView) itemView.findViewById(R.id.txtWaktu);
            seseorangImg = (ImageView) itemView.findViewById(R.id.imageView2);
            constraint = (ConstraintLayout) itemView.findViewById(R.id.constraint);

        }
/*
        @Override
        public void onClick(View view) {
*//*            Bundle bundle = new Bundle();
            bundle.putString("nama", txtNama.getText().toString());*//*
            _context.startActivity(new Intent(_context, CvPengacara.class));
        }*/
    }
}