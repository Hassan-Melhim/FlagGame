package edu.birzeit.myapplication;

import android.widget.ImageView;


public class Question {
    private int flagID;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String correctAns;


    public Question(int id, String opt1,
                    String opt2, String opt3, String opt4, String Ans){
        this.flagID = id;
        this.option1 = opt1;
        this.option2 = opt2;
        this.option3 = opt3;
        this.option4 = opt4;
        this.correctAns = Ans;
    }

    public int getFlagID() {
        return flagID;
    }

    public void setFlagID(int flag) {
        this.flagID = flag;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }
}
