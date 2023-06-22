package edu.birzeit.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

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
        //intializing variables
        holder.flag.setImageResource(questions.get(position).getFlagID());
        holder.opt1.setText(questions.get(position).getOption1());
        holder.opt2.setText(questions.get(position).getOption2());
        holder.opt3.setText(questions.get(position).getOption3());
        holder.opt4.setText(questions.get(position).getOption4());
        Question current = questions.get(position);

        //setting up action events
        holder.opt1.setOnClickListener(view -> {
            ViewHolder.checkAnswer(holder.opt1, current);
        });
        holder.opt2.setOnClickListener(view -> {
            ViewHolder.checkAnswer(holder.opt2, current);
        });
        holder.opt3.setOnClickListener(view -> {
            ViewHolder.checkAnswer(holder.opt3, current);
        });
        holder.opt4.setOnClickListener(view -> {
            ViewHolder.checkAnswer(holder.opt4, current);
        });

    }


    @Override
    public int getItemCount() {
        return questions.size();
    }
}

/*
//Delay before going to the next question
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //reset button colours
                holder.opt1.setBackgroundColor(getResources().getColor(R.color.AcademicGreen));
                opt2.setBackgroundColor(getResources().getColor(R.color.AcademicGreen));
                opt3.setBackgroundColor(getResources().getColor(R.color.AcademicGreen));
                opt4.setBackgroundColor(getResources().getColor(R.color.AcademicGreen));

                if(score >= 1000){//win condition reached
                    scoreFeild.setText("!!!!!Congrats!!!!!");
                    flag.setImageResource(R.drawable.win);
                    holder.opt1.setText("Wooooooo");
                    opt2.setText("ooooooW");
                    opt3.setText("Yaaaaaa");
                    opt4.setText("aaaaaaaY");
                }

                else if(score <= -100){//win condition reached
                    scoreFeild.setText("Try Again :(");
                    flag.setImageResource(R.drawable.loss);
                    holder.opt1.setText("Loooo");
                    opt2.setText("ooser");
                    opt3.setText("Booooo");
                    opt4.setText("hooooo");
                }

                else{
                    //enable button clicks again
                    holder.opt1.setEnabled(true);
                    opt2.setEnabled(true);
                    opt3.setEnabled(true);
                    opt4.setEnabled(true);

                    runTest();
                }
            }
        }, delayAmount);
    }
 */