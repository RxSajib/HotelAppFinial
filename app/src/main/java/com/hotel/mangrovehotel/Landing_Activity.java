package com.hotel.mangrovehotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Landing_Activity extends AppCompatActivity {

    private Button joinbutton;
    private Button siginbutton;
    private Animation animatable;
    private TextView hotelweb;
    private Animation animation;

    private TextView offer;
    private FirebaseAuth Mauth;

    private ImageView cornercafe, mangobar, sevensession, hukalang, olivia, theoli;

    private ImageView navimage;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private ImageView lavespa;

    private RelativeLayout layoutone, layouttwo;

    private Button booknowbutton;
    private LinearLayout relativeLayoutmettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        booknowbutton = findViewById(R.id.BookNowButtonID);
        booknowbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP){
                    booknowbutton.setBackgroundResource(R.drawable.booknow_buttonup);
                    Intent intent = new Intent(getApplicationContext(), BookNowLoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    booknowbutton.setBackgroundResource(R.drawable.book_buttondown);
                }

                return true;
            }
        });

        drawerLayout = findViewById(R.id.LandingDrawerID);
        navigationView = findViewById(R.id.LandingNavagationID);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.LHomeID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }

                if (menuItem.getItemId() == R.id.LMangroveCashID) {
                    Toast.makeText(getApplicationContext(), "First complected login process", Toast.LENGTH_LONG).show();
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }

                if (menuItem.getItemId() == R.id.LFeedbackID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(getApplicationContext(), "First complected login process", Toast.LENGTH_LONG).show();

                }

                if (menuItem.getItemId() == R.id.LBestDealsID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), BestDeals.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.LHelpID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), HelpLineActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.LWhyMangroveID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), TramsAncConditions.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.LTramsConditionID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), TConditionActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.LReferFeiendID) {
                    int counter = 0;
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");

                    String shareMessage = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";

                    String sharebody = shareMessage;
                    String sharesubject = "Hi mangrove hotel provide beast services for you" + "\n\n" + sharebody + "\n";
                    intent.putExtra(Intent.EXTRA_TEXT, sharesubject);
                    //  intent.putExtra(Intent.EXTRA_SUBJECT, sharebody);
                    startActivity(Intent.createChooser(intent, "share with"));
                }

                if(menuItem.getItemId() == R.id.MettingsID){
                    menuItem.setChecked(true);
                    menuItem.setCheckable(true);
                    Intent intent = new Intent(getApplicationContext(), MetingActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if(menuItem.getItemId() == R.id.SWIMMINGPOOLID){
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    Intent intent = new Intent(getApplicationContext(), SwmmingPoolActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if(menuItem.getItemId() == R.id.FITNESSCENTERID){
                    menuItem.setChecked(true);
                    menuItem.setCheckable(true);
                    Intent intent = new Intent(getApplicationContext(), FitnessActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }


                return true;
            }
        });


        lavespa = findViewById(R.id.LaveSpaID);
        lavespa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LaveSpaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        navimage = findViewById(R.id.NavImageID);
        navimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startOpening_navagationmenu();
            }
        });

/*
        offer = findViewById(R.id.PostButtonID);
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BestDeals.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
*/

        cornercafe = findViewById(R.id.CornerCafeID);
        cornercafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CornerCafeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        layoutone = findViewById(R.id.KKK);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.frombutton);
        cornercafe.setAnimation(animation);
        layoutone.setAnimation(animation);


        mangobar = findViewById(R.id.MangobarID);
        mangobar.setAnimation(animation);
        mangobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MangobarActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        sevensession = findViewById(R.id.SevenSessionID);
        sevensession.setAnimation(animation);
        sevensession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SevenSessionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        hukalang = findViewById(R.id.HukalangID);
        hukalang.setAnimation(animation);
        hukalang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HukalangActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        olivia = findViewById(R.id.OliviaID);
        olivia.setAnimation(animation);
        olivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OliviaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        theoli = findViewById(R.id.TheOliID);
        theoli.setAnimation(animation);

        theoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), exceutiveLaungue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        Mauth = FirebaseAuth.getInstance();
     /*
        hotelweb = findViewById(R.id.HotelWebID);
        hotelweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BookNowLoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        */

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        joinbutton = findViewById(R.id.JoinButtonID);
        siginbutton = findViewById(R.id.SiginButtonID);
        layouttwo = findViewById(R.id.Twos);

        animatable = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.frombutton);
        joinbutton.setAnimation(animatable);
        siginbutton.setAnimation(animatable);
        layouttwo.setAnimation(animation);


        joinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Regastation_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        siginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });





    }


    private void startOpening_navagationmenu() {

        drawerLayout.openDrawer(Gravity.LEFT);
    }
}
