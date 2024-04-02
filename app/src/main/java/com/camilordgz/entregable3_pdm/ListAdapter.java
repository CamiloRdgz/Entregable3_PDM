package com.camilordgz.entregable3_pdm;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final IRecyclerInterface recyclerInterface;
    private final List<ElementList> myData;
    private final LayoutInflater myInflater;


    public ListAdapter(List<ElementList> itemList, Context context, IRecyclerInterface recyclerInterface) {
        this.myData = itemList;
        this.myInflater = LayoutInflater.from(context);
        this.recyclerInterface = recyclerInterface;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.listelement,null);
        return new ListAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        ElementList item = myData.get(position);
        holder.bindData(item);

        // Set background color based on seen status
        if (item.getSeenStatus()) {
            holder.itemView.setBackgroundColor(Color.WHITE); // Example background color for seen items
        } else {
            holder.itemView.setBackgroundColor(R.color.notSeen); // Example background color for unseen items
        }
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView avatarPicture;
        TextView name, title, subject, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarPicture = itemView.findViewById(R.id.avatarPicture);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            subject = itemView.findViewById(R.id.subject);
            time = itemView.findViewById(R.id.time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ElementList item = myData.get(position);
                        item.setSeenStatus(true);
                        notifyItemChanged(position);
                        recyclerInterface.OnMailClick(position);
                    }
                }
            });
        }

        void bindData(final ElementList item){
            avatarPicture.setImageResource(item.getAvatarPicture());
            name.setText(item.getFullName());
            title.setText(item.getTitle());
            subject.setText(item.getSubject());
            time.setText(item.getTime());
        }
    }
}
