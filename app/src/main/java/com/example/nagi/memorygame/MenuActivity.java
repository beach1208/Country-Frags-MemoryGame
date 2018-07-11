package com.example.nagi.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.nagi.memorygame";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void level_1_onClick(View view) {
        Intent intent = new Intent(this,MainGameActivity.class);
        intent.putExtra(EXTRA_MESSAGE,20);
        startActivity(intent);
    }

    public void level_2_onClick(View view) {
    }

    public void level_3_onClick(View view) {
        Intent intent = new Intent(this,MainGameActivity.class);
        intent.putExtra(EXTRA_MESSAGE,10);
        startActivity(intent);
    }
}
