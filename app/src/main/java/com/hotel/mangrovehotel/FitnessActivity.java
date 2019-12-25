package com.hotel.mangrovehotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class FitnessActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textViewone;
    private  TextView textViewtwo;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        toolbar = findViewById(R.id.FitnessToolbarID);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        getSupportActionBar().setTitle("Fitness Center");


        textViewone = findViewById(R.id.ConrnercafeID);
        textViewtwo = findViewById(R.id.ConnertextID);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.frombutton);
        textViewtwo.setAnimation(animation);
        textViewone.setAnimation(animation);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
