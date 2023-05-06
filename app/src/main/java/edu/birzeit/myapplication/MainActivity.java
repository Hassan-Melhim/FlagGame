package edu.birzeit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView flag;
    Button btn1,btn2,btn3,btn4;
    TextView scoreFeild;
    private static final long delayAmount = 1000;
    int score;
    ArrayList <Question> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing variables
        flag = (ImageView) findViewById(R.id.Flag);
        btn1 = (Button) findViewById(R.id.Button1);
        btn2 = (Button) findViewById(R.id.Button2);
        btn3 = (Button) findViewById(R.id.Button3);
        btn4 = (Button) findViewById(R.id.Button4);
        scoreFeild = (TextView) findViewById(R.id.Score);
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

        runTest();
    }
    public void runTest (){
        //choosing flag at random
       int random = (int)(Math.random() * this.list.size());

       //presenting score
        scoreFeild.setText("Score: " + score);

       //presenting the randomly generated flag
       flag.setImageResource(list.get(random).getFlagID());
       btn1.setText(list.get(random).getOption1());
       btn2.setText(list.get(random).getOption2());
       btn3.setText(list.get(random).getOption3());
       btn4.setText(list.get(random).getOption4());

       //setting up action for the button click
       btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btn1, list.get(random));
            }
        });

       btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btn2, list.get(random));
            }
        });

       btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btn3, list.get(random));
            }
        });

       btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btn4, list.get(random));
            }
        });
    }

    public void checkAnswer(Button btn, Question question){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);

        if(btn.getText().toString().equals(question.getCorrectAns())){
            btn.setBackgroundColor(Color.BLUE);
            this.score += 100;
        }

        else{
            btn.setBackgroundColor(Color.RED);
            this.score -=50;
        }


        //Delay before going to the next question
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //reset button colours
                btn1.setBackgroundColor(getResources().getColor(R.color.AcademicGreen));
                btn2.setBackgroundColor(getResources().getColor(R.color.AcademicGreen));
                btn3.setBackgroundColor(getResources().getColor(R.color.AcademicGreen));
                btn4.setBackgroundColor(getResources().getColor(R.color.AcademicGreen));

                if(score >= 1000){//win condition reached
                    scoreFeild.setText("!!!!!Congrats!!!!!");
                    flag.setImageResource(R.drawable.win);
                    btn1.setText("Wooooooo");
                    btn2.setText("ooooooW");
                    btn3.setText("Yaaaaaa");
                    btn4.setText("aaaaaaaY");
                }

                else if(score <= -100){//win condition reached
                    scoreFeild.setText("Try Again :(");
                    flag.setImageResource(R.drawable.loss);
                    btn1.setText("Loooo");
                    btn2.setText("ooser");
                    btn3.setText("Booooo");
                    btn4.setText("hooooo");
                }

                else{
                    //enable button clicks again
                    btn1.setEnabled(true);
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                    btn4.setEnabled(true);

                    runTest();
                }
            }
        }, delayAmount);
    }
}