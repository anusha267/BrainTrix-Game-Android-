package com.anusha.dev.braintrix.v1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timeLeft,scoreCount,question,comments,difficulty;
    Button startButton,a1,a2,a3,a4,thirty,sixty,onetwenty,easy,medium, hard;
    int[] res=new int[4];
    int locationOfCorrectAnswer;
    int quesNum=0;
    int score=0;
    long t=60000;
    int dif=2;
    public void setEasy(View view)
    {
        dif=1;
        difficulty=findViewById(R.id.difficulty);
        difficulty.setText("Difficulty : Easy");
    }
    public void setMedium(View view)
    {
        dif=2;
        difficulty=findViewById(R.id.difficulty);
        difficulty.setText("Difficulty : Medium");
    }
    public void setHard(View view)
    {
        dif=3;
        difficulty=findViewById(R.id.difficulty);
        difficulty.setText("Difficulty : Hard");
    }

    public void setThirty(View view)
    {
        t=30000;
        comments=findViewById(R.id.comments);
        comments.setText("Game Time : 30s");

    }
    public void setSixty(View view)
    {
        t=60000;
        comments=findViewById(R.id.comments);
        comments.setText("Game Time : 60s");

    }
    public void setOneTwenty(View view)
    {
        t=120000;
        comments=findViewById(R.id.comments);
        comments.setText("Game Time : 120s");

    }

    public void go(View view)
    {
        score=0;
        quesNum=0;
        startButton=findViewById(R.id.goButton);
        startButton.setVisibility(View.INVISIBLE);
        timeLeft=findViewById(R.id.timeLeft);
        timeLeft.setVisibility(View.VISIBLE);
        scoreCount=findViewById(R.id.scoreCount);
        scoreCount.setVisibility(View.VISIBLE);
        question=findViewById(R.id.question);
        question.setVisibility(View.VISIBLE);
        a1=findViewById(R.id.answer1);
        a2=findViewById(R.id.answer2);
        a3=findViewById(R.id.answer3);
        a4=findViewById(R.id.answer4);
        a1.setVisibility(View.VISIBLE);
        a2.setVisibility(View.VISIBLE);
        a3.setVisibility(View.VISIBLE);
        a4.setVisibility(View.VISIBLE);
        comments=findViewById(R.id.comments);
        comments.setText("");
        setQuestion();
        setTimerQ();
        thirty=findViewById(R.id.thirty);
        sixty=findViewById(R.id.sixty);
        onetwenty=findViewById(R.id.onetwenty);
        thirty.setVisibility(View.INVISIBLE);
        sixty.setVisibility(View.INVISIBLE);
        onetwenty.setVisibility(View.INVISIBLE);
        easy=findViewById(R.id.easy);
        easy.setVisibility(View.INVISIBLE);
        medium=findViewById(R.id.medium);
        medium.setVisibility(View.INVISIBLE);
        hard=findViewById(R.id.hard);
        hard.setVisibility(View.INVISIBLE);
        difficulty=findViewById(R.id.difficulty);
        difficulty.setVisibility(View.INVISIBLE);



    }

    public void setQuestion()
    {
        quesNum+=1;
        scoreCount=findViewById(R.id.scoreCount);
        String sc=Integer.toString(score)+"/"+Integer.toString(quesNum);
        scoreCount.setText(sc);
        Random rand=new Random();
        int op=rand.nextInt(5);
        int a,b;
        if(dif==1) {
            a = rand.nextInt(20)+1;
            b = rand.nextInt(20)+1;
        }
        else if(dif==2) {
            a = rand.nextInt(50)+1;
            b = rand.nextInt(50)+1;
        }
        else{
            a = rand.nextInt(100)+1;
            b = rand.nextInt(100)+1;
        }
        int result;
        String s;
        question = findViewById(R.id.question);
        if (op==0)
        {
            s = a + "+" + b + "=____";
            result = a + b;
        }
        else if(op==1)
        {
            if (a>b){
                result = a-b;
                s = a + "-" + b + "=____";
            }
            else
            {
                result = b-a;
                s = b + "-" + a + "=____";
            }
        }
        else if(op==2)
        {
            s = a + "*" + b + "=____";
            result = a * b;
        }
        else if(op==3)
        {
            if (a>b){
                result = a/b;
                s = a + "/" + b + "=____";
            }
            else
            {
                result = b/a;
                s = b + "/" + a + "=____";
            }

        }
        else
        {
            if (a>b){
                result = a%b;
                s = a + "%" + b + "=____";
            }
            else
            {
                result = b%a;
                s = b + "%" + a + "=____";
            }
        }
        question.setText(s);
        locationOfCorrectAnswer=rand.nextInt(4);
        int j;
        for(int i=0;i<4;i++)
        {
            if (dif==1) {
                j=rand.nextInt(40);
            }
            else if(dif==2)
            {
                j=rand.nextInt(100);
            }
            else{
                j=rand.nextInt(200);
            }
            if(i==locationOfCorrectAnswer)
            {
                res[i]=result;
            }
            else
            {
                if (dif==1) {
                    while (j == rand.nextInt(40)) ;
                    res[i] = j;
                }
                else if(dif==2)
                {
                    while (j == rand.nextInt(100)) ;
                    res[i] = j;
                }
                else{
                    while (j == rand.nextInt(200)) ;
                    res[i] = j;
                }

            }
            setResult(locationOfCorrectAnswer);


        }
        setResult();
    }

    public void check(View view)
    {
        comments=findViewById(R.id.comments);
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))
        {
            comments.setVisibility(View.VISIBLE);
            comments.setText("CORRECT! Keep Going!");
            score+=1;
        }
        else
        {
            comments.setVisibility(View.VISIBLE);
            comments.setText("WRONG! Focus Buddy!");
        }
        setQuestion();
    }



    public void setResult()
    {
        a1=findViewById(R.id.answer1);
        a2=findViewById(R.id.answer2);
        a3=findViewById(R.id.answer3);
        a4=findViewById(R.id.answer4);
        a1.setText(Integer.toString(res[0]));
        a2.setText(Integer.toString(res[1]));
        a3.setText(Integer.toString(res[2]));
        a4.setText(Integer.toString(res[3]));

    }


    public void setTimerQ()
    {
        CountDownTimer c=new CountDownTimer(t,1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {

                timeLeft=findViewById(R.id.timeLeft);
                timeLeft.setText(Long.toString(l/1000)+"s");

            }

            @Override
            public void onFinish() {

                startButton=findViewById(R.id.goButton);
                startButton.setVisibility(View.VISIBLE);
                startButton.setText("Play Again?!");
                timeLeft=findViewById(R.id.timeLeft);
                timeLeft.setVisibility(View.INVISIBLE);
                scoreCount=findViewById(R.id.scoreCount);
                scoreCount.setVisibility(View.INVISIBLE);
                question=findViewById(R.id.question);
                question.setVisibility(View.INVISIBLE);
                a1=findViewById(R.id.answer1);
                a2=findViewById(R.id.answer2);
                a3=findViewById(R.id.answer3);
                a4=findViewById(R.id.answer4);
                a1.setVisibility(View.INVISIBLE);
                a2.setVisibility(View.INVISIBLE);
                a3.setVisibility(View.INVISIBLE);
                a4.setVisibility(View.INVISIBLE);
                comments=findViewById(R.id.comments);
                String st="You scored "+Integer.toString(score)+" out of "+Integer.toString(quesNum)+"!";
                comments.setText(st);
                thirty=findViewById(R.id.thirty);
                sixty=findViewById(R.id.sixty);
                onetwenty=findViewById(R.id.onetwenty);
                thirty.setVisibility(View.VISIBLE);
                sixty.setVisibility(View.VISIBLE);
                onetwenty.setVisibility(View.VISIBLE);
                easy=findViewById(R.id.easy);
                easy.setVisibility(View.VISIBLE);
                medium=findViewById(R.id.medium);
                medium.setVisibility(View.VISIBLE);
                hard=findViewById(R.id.hard);
                hard.setVisibility(View.VISIBLE);
                difficulty=findViewById(R.id.difficulty);
                difficulty.setVisibility(View.VISIBLE);

            }
        };
        c.start();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}