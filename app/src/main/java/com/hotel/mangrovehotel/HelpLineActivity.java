package com.hotel.mangrovehotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HelpLineActivity extends AppCompatActivity {

    private Button button;
    private ImageView facebook, tweeter, googleplus, instragram;
    private Toolbar toolbar;
    private TextView adminbutton;

    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_line);

        toolbar = findViewById(R.id.ToolbarIDd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
        adminbutton = findViewById(R.id.ContactsUsButtonID);

        adminbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Admin_LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        facebook = findViewById(R.id.FacebookButtonID);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://web.facebook.com/MangroveHotelUAE?_rdc=1&_rdr"));
                startActivity(intent);
            }
        });

        tweeter = findViewById(R.id.TweterID);
        tweeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /* Intent intent = new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.addCategory(Intent.CATEGORY_BROWSABLE);
*/


            }
        });

        instragram = findViewById(R.id.InstgramID);
        instragram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.instagram.com/accounts/login/?next=%2Fmangrovehoteluae%2F&source=desktop_nav"));
                startActivity(intent);
            }
        });

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.frombutton);
        facebook.setAnimation(animation);
        tweeter.setAnimation(animation);
        instragram.setAnimation(animation);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
