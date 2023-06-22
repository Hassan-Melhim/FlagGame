package edu.birzeit.myapplication;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView flag;
    Button opt1,opt2,opt3,opt4;
    TextView scoreField;
    int score;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        flag = (ImageView) itemView.findViewById(R.id.Flag);
        opt1 = (Button) itemView.findViewById(R.id.Button1);
        opt2 = (Button) itemView.findViewById(R.id.Button2);
        opt3 = (Button) itemView.findViewById(R.id.Button3);
        opt4 = (Button) itemView.findViewById(R.id.Button4);
        scoreField = (TextView) itemView.findViewById(R.id.Score);

    }

    public static void checkAnswer(Button btn, Question question) {

        if (btn.getText().toString().equals(question.getCorrectAns())) {
            btn.setBackgroundColor(Color.BLUE);
        } else {
            btn.setBackgroundColor(Color.RED);

        }
    }
}
