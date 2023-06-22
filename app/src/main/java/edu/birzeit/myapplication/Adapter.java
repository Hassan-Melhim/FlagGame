package edu.birzeit.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Question> questions;

    public Adapter(Context context, List<Question> questions) {
        this.context = context;
        this.questions = questions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.flagcard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.flag.setImageResource(questions.get(position).getFlagID());
        holder.opt1.setText(questions.get(position).getOption1());
        holder.opt2.setText(questions.get(position).getOption2());
        holder.opt3.setText(questions.get(position).getOption3());
        holder.opt4.setText(questions.get(position).getOption4());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
