package com.palapol.tsp_sesaminar_team02;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.palapol.tsp_sesaminar_team02.model.ResObj;

import java.util.List;

class SerchFileAdapter extends RecyclerView.Adapter<SerchFileHolder>{

    SerchFileSeminar serchFileSeminar;
    List<ResObj> resObj;

    public SerchFileAdapter(SerchFileSeminar serchFileSeminar, List<ResObj> resObj) {
        this.serchFileSeminar = serchFileSeminar;
        this.resObj = resObj;
    }

    @NonNull
    @Override
    public SerchFileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        SerchFileHolder prodiceViewHolder = new SerchFileHolder(view);
        return prodiceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SerchFileHolder holder, int position) {
//        if(resObj.get(position).getProIndex().equals("")) {
            holder.tvIndex.setText(resObj.get(position).getJouIndex());
            holder.tvTitle.setText(resObj.get(position).getJouTitle());
//        }if(resObj.get(position).getJouIndex().equals("")){
//            holder.tvIndex.setText(resObj.get(position).getProIndex());
//            holder.tvTitle.setText(resObj.get(position).getProTitle());
//        }
    }

    @Override
    public int getItemCount() {
        if(resObj != null)
            return resObj.size();

        return 0;
    }
}
