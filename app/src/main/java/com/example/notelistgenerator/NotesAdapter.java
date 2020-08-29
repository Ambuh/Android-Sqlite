package com.example.notelistgenerator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private final Context mContext;
    private final LayoutInflater mInflater;
    private final List<NoteInfo> mNotes;

    public NotesAdapter(Context mContext,/*notes*/ List<NoteInfo> mNotes) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mNotes = mNotes;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=mInflater.inflate(R.layout.data_list,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NoteInfo note=mNotes.get(position);
        holder.TextTitle.setText(note.getTitle());
        holder.TextCourse.setText(note.getCourse().getTitle());
        holder.mCurrentPosition=position;
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public final TextView TextTitle;
        public final TextView TextCourse;
        public int mCurrentPosition;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TextTitle=(TextView) itemView.findViewById(R.id.text_title);
            TextCourse=(TextView) itemView.findViewById(R.id.text_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE_POSITION, mCurrentPosition);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}
