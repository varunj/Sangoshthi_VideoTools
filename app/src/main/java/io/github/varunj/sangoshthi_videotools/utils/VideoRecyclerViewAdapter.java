package io.github.varunj.sangoshthi_videotools.utils;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.github.varunj.sangoshthi_videotools.R;
import io.github.varunj.sangoshthi_videotools.activities.CreateStory;

/**
 * Created by Varun on 22-04-2017.
 */

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoRecyclerViewAdapter.MyViewHolder> {

    private List<String> imageUriList;
    private CreateStory context;

    public VideoRecyclerViewAdapter(CreateStory context) {
        this.context = context;
        this.imageUriList = Constants.imageUriList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFilmRoll;
        private ImageView ivContainer;

        MyViewHolder(View view) {
            super(view);
            ivFilmRoll = (ImageView) view.findViewById(R.id.iv_film_roll_video);
            ivContainer = (ImageView) view.findViewById(R.id.iv_container_video);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item_video, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.ivFilmRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // load image by starting fileManager intent
//                Toast.makeText(context, "Load Image" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // for for all
                intent.setType("*/*");

                Constants.update_position = holder.getAdapterPosition();
                context.startActivityForResult(intent, Constants.VIDEO_READ_REQUEST_CODE);
            }
        });


        if(!imageUriList.get(position).equals("")) {
            if (imageUriList.get(position).contains("mp4")) {
                holder.ivContainer.setVisibility(View.VISIBLE);
                Picasso.with(context)
                        .load(imageUriList.get(position).replace("mp4", "png"))
                        .resize(148, 98)
                        .centerCrop()
                        .into(holder.ivContainer);
            }
            else {
                holder.ivContainer.setVisibility(View.VISIBLE);
                Picasso.with(context)
                        .load(imageUriList.get(position))
                        .resize(148, 98)
                        .centerCrop()
                        .into(holder.ivContainer);
            }
        } else {
            holder.ivContainer.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return imageUriList.size();
    }
}
