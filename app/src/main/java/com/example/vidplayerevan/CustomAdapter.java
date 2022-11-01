package com.example.vidplayerevan;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private final Context context;
    private List<File> files;
    private  SelectListner listner;

    public CustomAdapter(Context context, List<File> files, SelectListner listner) {
        this.context = context;
        this.files = files;
        this.listner = listner;
    }


    @NonNull

    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.custum_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        holder.txtName.setText(files.get(position).getName());
        holder.txtName.setSelected(true);


        Bitmap thumb = ThumbnailUtils.createVideoThumbnail(String.valueOf(files.get(position).getAbsoluteFile()),
                MediaStore.Images.Thumbnails.MICRO_KIND);

        holder.img.setImageBitmap(thumb);

//*********************************************************************************
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onFileClicked(files.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return files.size();
    }
}
