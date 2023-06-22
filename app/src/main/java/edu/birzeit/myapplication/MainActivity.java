package edu.birzeit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView flag;
    Button btn1,btn2,btn3,btn4;
    TextView scoreFeild, title;
    private static final long delayAmount = 1000;
    int score;
    ArrayList <Question> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing variables
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        //flag = (ImageView) findViewById(R.id.Flag);
        //btn1 = (Button) findViewById(R.id.Button1);
        //btn2 = (Button) findViewById(R.id.Button2);
        //btn3 = (Button) findViewById(R.id.Button3);
        //btn4 = (Button) findViewById(R.id.Button4);
        //scoreFeild = (TextView) findViewById(R.id.Score);
        score = 0;

        //Mock-up data

        list.add(new Question(R.drawable.andorra,"Angola", "Algeria",
                "Andorra", "Antigua", "Andorra"));
        list.add(new Question(R.drawable.antigua_barbuda, "Barbados", "Bahamas",
                "Andorra", "Antigua&barbuda", "Antigua&barbuda"));
        list.add(new Question(R.drawable.eritrea, "Ethiopia", "Eritrea",
                "Djibouti", "Congo", "Eritrea"));
        list.add(new Question(R.drawable.montenegro, "Montenegro", "Morocco",
                "Macedonia", "Mozambique", "Montenegro"));
        list.add(new Question(R.drawable.mozambique, "Morocco", "Mozambique",
                "Macedonia", "Montenegro", "Mozambique"));
        list.add(new Question(R.drawable.sri_lanka, "San Marino", "Sri Lanka",
                "Bhutan", "Brunei", "Sri Lanka"));
        list.add(new Question(R.drawable.chile, "Chile", "Puerto Rico",
                "Cuba", "Panama", "Chile"));
        list.add(new Question(R.drawable.comoros, "Cameroon", "Djibouti",
                "Comoros", "Togo", "Comoros"));
        list.add(new Question(R.drawable.el_salvador, "Nicaragua", "Guatemala",
                "Beliz", "El Salvador", "El Salvador"));
        list.add(new Question(R.drawable.estonia, "Estonia", "Latvia",
                "Lithuania", "Belarus", "Estonia"));
        list.add(new Question(R.drawable.fiji, "Palau", "Tuvalu",
                "Fiji", "Kiribati", "Fiji"));

        //save mock up data
        saveQuestions(this, this.list);

        //RecylerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(), this.list));

        //load data
        //this.list = loadQuestions(this);


        //runTest();
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