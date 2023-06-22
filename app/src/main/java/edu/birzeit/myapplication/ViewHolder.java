package edu.birzeit.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView flag;
    Button opt1,opt2,opt3,opt4;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        flag = (ImageView) itemView.findViewById(R.id.Flag);
        opt1 = (Button) itemView.findViewById(R.id.Button1);
        opt2 = (Button) itemView.findViewById(R.id.Button2);
        opt3 = (Button) itemView.findViewById(R.id.Button3);
        opt4 = (Button) itemView.findViewById(R.id.Button4);
    }
}
