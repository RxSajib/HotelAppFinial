package com.hotel.mangrovehotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SwmmingPoolActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textViewone;
    private TextView textViewtwo;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swmming_pool);

        toolbar = findViewById(R.id.SwmmingToolbarID);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        getSupportActionBar().setTitle("Swimming Pool");


        textViewone = findViewById(R.id.SConrnercafeID);
        textViewtwo = findViewById(R.id.SConnertextID);
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
