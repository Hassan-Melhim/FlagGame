package edu.birzeit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    int score, index;

    ArrayList <Question> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing variables
        recyclerView = findViewById(R.id.recyclerview);

        score = 0;
        index = 0;

        //load data
        this.list = loadQuestions(this);
        Collections.shuffle(this.list);



        //was used to save the mock up data
        //saveQuestions(this, this.list);

        //RecylerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(this, this.list));




        runTest();
    }

    private void runTest() {
        Question current = this.list.get(index);
        Adapter adapter = (Adapter) recyclerView.getAdapter();
        adapter.notifyDataSetChanged();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                index ++;
                if(score <= 1000 || score >= -100){
                    if(index >= list.size()){
                        //check if user has ran through the list of questions or not
                        Collections.shuffle(list);
                        index = 0;
                        runTest();
                    }
                }
                else if(score > 1000){
                    //win prompt
                }

                else if (score < -100){
                    //lose prompt
                }

            }
        }, 2000);
    }

    private static void saveQuestions(Context context, ArrayList<Question> qList){
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "Quiz Question", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(qList);

        editor.putString("Question List", json);
        editor.commit();
    }

    private ArrayList<Question> loadQuestions(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                "Quiz Question", MODE_PRIVATE);
        String json = sharedPreferences.getString("Question List"
                , null);

        if (json != null) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Question>>() {}.getType();
            return gson.fromJson(json, listType);
        }
        return null;
    }

}