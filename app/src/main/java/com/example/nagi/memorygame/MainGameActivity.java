package com.example.nagi.memorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainGameActivity extends AppCompatActivity {

    TextView textViewp1,timer_View;
    ImageView questionImage11,questionImage12,questionImage13,questionImage14,
            questionImage21,questionImage22,questionImage23,questionImage24,
            questionImage31,questionImage32,questionImage33,questionImage34;

    //array for the images
    Integer[] cardArray = {101,102,103,104,105,106,201,202,203,204,205,206};
    ArrayList<ImageView> imageViewArrayList = new ArrayList<>();

    //actual images
    int image101,image102,image103,image104,image105,image106,
            image201,image202,image203,image204,image205,image206;

    int firstCard,secondCard;
    int clickedFirst,clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_game);

        Intent intent = getIntent();
        String value = intent.getStringExtra("Move");

        textViewp1 = findViewById(R.id.tv_p1);
        timer_View = findViewById(R.id.timer_View);

        //CountDown timer
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer_View.setText(millisUntilFinished / 1000+ " seconds remaining");
            }

            public void onFinish() {
                timer_View.setText("END!");
                if (!isFinishing()){
                    alertDialog();
                }

                }


        }.start();


        questionImage11 = findViewById(R.id.questionImageView11);
        questionImage12 = findViewById(R.id.questionImageView12);
        questionImage13 = findViewById(R.id.questionImageView13);
        questionImage14 = findViewById(R.id.questionImageView14);

        questionImage21 = findViewById(R.id.questionImageView21);
        questionImage22 = findViewById(R.id.questionImageView22);
        questionImage23 = findViewById(R.id.questionImageView23);
        questionImage24 = findViewById(R.id.questionImageView24);

        questionImage31 = findViewById(R.id.questionImageView31);
        questionImage32 = findViewById(R.id.questionImageView32);
        questionImage33 = findViewById(R.id.questionImageView33);
        questionImage34 = findViewById(R.id.questionImageView34);

        imageViewArrayList.add(questionImage11);
        imageViewArrayList.add(questionImage12);
        imageViewArrayList.add(questionImage13);
        imageViewArrayList.add(questionImage14);
        imageViewArrayList.add(questionImage21);
        imageViewArrayList.add(questionImage22);
        imageViewArrayList.add(questionImage23);
        imageViewArrayList.add(questionImage24);
        imageViewArrayList.add(questionImage31);
        imageViewArrayList.add(questionImage32);
        imageViewArrayList.add(questionImage33);
        imageViewArrayList.add(questionImage34);


        questionImage11.setTag("0");
        questionImage12.setTag("1");
        questionImage13.setTag("2");
        questionImage14.setTag("3");

        questionImage21.setTag("4");
        questionImage22.setTag("5");
        questionImage23.setTag("6");
        questionImage24.setTag("7");

        questionImage31.setTag("8");
        questionImage32.setTag("9");
        questionImage33.setTag("10");
        questionImage34.setTag("11");


        //Load images
        frontOfCardsResources();

        //shuffle images
        Collections.shuffle(Arrays.asList(cardArray));

        //Changing the color of the second player(inactive)

        cardOnclick();


    }

    private void alertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainGameActivity.this);
        alertDialogBuilder
                .setMessage("GAME OVER!\nYou got " + playerPoints + " points")
                .setCancelable(false)
                .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), MainGameActivity.class);
                        startActivity(intent);
                        finish();

                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialogBuilder.show();

    }

    private void cardOnclick(){
        for (int i = 0; i < imageViewArrayList.size(); i++){
            final int c = i;
            imageViewArrayList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    ImageView iv = imageViewArrayList.get(c);
                    setCardImage(iv,theCard);
                }
            });
        }
    }

    private boolean setEnabled(Boolean enable){
        for (int i = 0; i < imageViewArrayList.size(); i++){
            imageViewArrayList.get(i).setEnabled(enable);
        }
        return enable;
    }

    private void setCardImage(ImageView iv, int card){
        switch (cardArray[card]){
            case 101:
                iv.setImageResource(image101);
                Toast.makeText(this,"Turkey",Toast.LENGTH_SHORT).show();
                break;
            case 102:
                iv.setImageResource(image102);
                Toast.makeText(this,"Australia",Toast.LENGTH_SHORT).show();
                break;
            case 103:
                iv.setImageResource(image103);
                Toast.makeText(this,"Tunisia",Toast.LENGTH_SHORT).show();
                break;
            case 104:
                iv.setImageResource(image104);
                Toast.makeText(this,"Cameroon",Toast.LENGTH_SHORT).show();
                break;
            case 105:
                iv.setImageResource(image105);
                Toast.makeText(this,"Senegal",Toast.LENGTH_SHORT).show();
                break;
            case 106:
                iv.setImageResource(image106);
                Toast.makeText(this,"New Zealand",Toast.LENGTH_SHORT).show();
                break;
            case 201:
                iv.setImageResource(image201);
                Toast.makeText(this,"Turkey",Toast.LENGTH_SHORT).show();
                break;
            case 202:
                iv.setImageResource(image202);
                Toast.makeText(this,"Australia",Toast.LENGTH_SHORT).show();
                break;
            case 203:
                iv.setImageResource(image203);
                Toast.makeText(this,"Tunisia",Toast.LENGTH_SHORT).show();
                break;
            case 204:
                iv.setImageResource(image204);
                Toast.makeText(this,"Cameroon",Toast.LENGTH_SHORT).show();
                break;
            case 205:
                iv.setImageResource(image205);
                Toast.makeText(this,"Senegal",Toast.LENGTH_SHORT).show();
                break;
            case 206:
                iv.setImageResource(image206);
                Toast.makeText(this,"New Zealand",Toast.LENGTH_SHORT).show();
        }

        //check which image is selected and save it to temporary variable

        if(cardNumber == 1){
            firstCard = cardArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;
            iv.setEnabled(false);
        }else if(cardNumber == 2){
            secondCard = cardArray[card];
            if (secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;
        }

        setEnabled(false);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //check if the selected images are equal
                calculate();
            }
        },500);

    }

    private void calculate(){
        //if images are eaual remove them
        if (firstCard == secondCard){
            switch (clickedFirst){
                case 0:
                    questionImage11.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    questionImage12.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    questionImage13.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    questionImage14.setVisibility(View.INVISIBLE);
                    break;
                case 4:
                    questionImage21.setVisibility(View.INVISIBLE);
                    break;
                case 5:
                    questionImage22.setVisibility(View.INVISIBLE);
                    break;
                case 6:
                    questionImage23.setVisibility(View.INVISIBLE);
                    break;
                case 7:
                    questionImage24.setVisibility(View.INVISIBLE);
                    break;
                case 8:
                    questionImage31.setVisibility(View.INVISIBLE);
                    break;
                case 9:
                    questionImage32.setVisibility(View.INVISIBLE);
                    break;
                case 10:
                    questionImage33.setVisibility(View.INVISIBLE);
                    break;
                case 11:
                    questionImage34.setVisibility(View.INVISIBLE);
                    break;
                default:
                    break;
            }


            switch (clickedSecond){
                case 0:
                    questionImage11.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    questionImage12.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    questionImage13.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    questionImage14.setVisibility(View.INVISIBLE);
                    break;
                case 4:
                    questionImage21.setVisibility(View.INVISIBLE);
                    break;
                case 5:
                    questionImage22.setVisibility(View.INVISIBLE);
                    break;
                case 6:
                    questionImage23.setVisibility(View.INVISIBLE);
                    break;
                case 7:
                    questionImage24.setVisibility(View.INVISIBLE);
                    break;
                case 8:
                    questionImage31.setVisibility(View.INVISIBLE);
                    break;
                case 9:
                    questionImage32.setVisibility(View.INVISIBLE);
                    break;
                case 10:
                    questionImage33.setVisibility(View.INVISIBLE);
                    break;
                case 11:
                    questionImage34.setVisibility(View.INVISIBLE);
                    break;
                default:
                    break;
            }

            if (turn == 1) {
                playerPoints++;
                textViewp1.setText("Points:" + playerPoints);
            }

        }else {
            //setting Images to question Images
            setQuestionImages();

        }

        //set Enable method
        setEnabled(true);

        //check if game is over
        checkEnd();
    }

    private void setQuestionImages(){
        for (int i = 0; i < imageViewArrayList.size(); i++){
            imageViewArrayList.get(i).setImageResource(R.drawable.world);
        }
    }


    private void checkEnd() {
        if (
                questionImage11.getVisibility() == View.INVISIBLE &&
                        questionImage12.getVisibility() == View.INVISIBLE &&
                        questionImage13.getVisibility() == View.INVISIBLE &&
                        questionImage14.getVisibility() == View.INVISIBLE &&
                        questionImage21.getVisibility() == View.INVISIBLE &&
                        questionImage22.getVisibility() == View.INVISIBLE &&
                        questionImage23.getVisibility() == View.INVISIBLE &&
                        questionImage24.getVisibility() == View.INVISIBLE &&
                        questionImage31.getVisibility() == View.INVISIBLE &&
                        questionImage32.getVisibility() == View.INVISIBLE &&
                        questionImage33.getVisibility() == View.INVISIBLE &&
                        questionImage34.getVisibility() == View.INVISIBLE) {
            {
                alertDialog();
            }
        }
    }

        private void frontOfCardsResources () {
            image101 = R.drawable.image101;
            image102 = R.drawable.image102;
            image103 = R.drawable.image103;
            image104 = R.drawable.image104;
            image105 = R.drawable.image105;
            image106 = R.drawable.image106;

            image201 = R.drawable.image201;
            image202 = R.drawable.image202;
            image203 = R.drawable.image203;
            image204 = R.drawable.image204;
            image205 = R.drawable.image205;
            image206 = R.drawable.image206;

        }

}
