package com.palapol.tsp_sesaminar_team02;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class SerchFileHolder extends RecyclerView.ViewHolder {

    TextView tvIndex;
    TextView tvTitle;

    public SerchFileHolder(View itemView) {
        super(itemView);
        tvIndex = itemView.findViewById(R.id.tv_index);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }

}
