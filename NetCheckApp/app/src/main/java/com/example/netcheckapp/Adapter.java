package com.example.netcheckapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    List<DataModel> dataModels;
    Context context;

    public Adapter(List<DataModel> dataModels, Context context)
    {
        this.dataModels=dataModels;
        this.context=context;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.users_items_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        DataModel dataModel = dataModels.get(position);


        holder.tv2.setText(dataModel.getName());
        Picasso.with(context)
                .load(dataModel.getImageurl())
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                        holder.progressBarImage.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv2;
        private ImageView imageView;

        private ProgressBar progressBarImage;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.imageview);
            tv2=(TextView)itemView.findViewById(R.id.t2);
            progressBarImage=(ProgressBar) itemView.findViewById(R.id.progressbar);
        }
    }
}
