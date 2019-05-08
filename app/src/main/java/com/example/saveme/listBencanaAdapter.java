package com.example.saveme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View view = layoutInflater.inflate(R.layout.layout_list_konsul, parent, false);
        return new listBencanaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(listBencanaViewHolder holder, int position) {
/*        final ListKonsultasi model = dataListKonsul.get(position);
        holder.txtJudul.setText(model.getJudul());
        holder.txtJawaboleh.setText(model.getJawaboleh());
        holder.txtIsi.setText(model.getIsi());
        holder.seseorangImg.setImageDrawable(context.getResources().getDrawable(model.getSeseorangImg()));
        holder.constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, jawabanKonsul.class);
                intent.putExtra("seseorang", model.getSeseorangImg());
                intent.putExtra("judul", model.getJudul());
                intent.putExtra("jawab", model.getJawaboleh());
                intent.putExtra("isi", model.getIsi());
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return  dataList.size();
        /*return (dataList != null) ? dataList.size() : 0;*/
    }

    public class listBencanaViewHolder extends RecyclerView.ViewHolder{
        TextView txtJudul, txtJawaboleh, txtIsi;
        ImageView seseorangImg;
        ConstraintLayout constraint;

        public listBencanaViewHolder(View itemView) {
            super(itemView);
            txtJudul = (TextView) itemView.findViewById(R.id.txtJudul);
            txtJawaboleh = (TextView) itemView.findViewById(R.id.txtJawaboleh);
            txtIsi = (TextView) itemView.findViewById(R.id.txtIsi);
            seseorangImg = (ImageView) itemView.findViewById(R.id.seseorangImg);
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
