package com.hotel.mangrovehotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home_Activity extends AppCompatActivity {

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabHolder tabHolder;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private FirebaseAuth Mauth;
    private DatabaseReference MuserDatabase;
    private String CurrentUserID;
    private String usernameget;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);


        Mauth = FirebaseAuth.getInstance();
        MuserDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        CurrentUserID = Mauth.getCurrentUser().getUid();
        toolbar = findViewById(R.id.ToolbarID);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_icon);


        navigationView = findViewById(R.id.navagationID);
        drawerLayout = findViewById(R.id.Dlayout);

        appBarLayout = findViewById(R.id.AppbarLayoutID);
        tabLayout = findViewById(R.id.TablayoutID);
        viewPager = findViewById(R.id.ViewPagerID);


        tabHolder = new TabHolder(getSupportFragmentManager());
        viewPager.setAdapter(tabHolder);
        tabLayout.setupWithViewPager(viewPager);







        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.HomeID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }

                if (menuItem.getItemId() == R.id.BestDealsID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), BestDeals.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.HelpID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), HelpLineActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.WhyMangroveID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), TramsAncConditions.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }



                if (menuItem.getItemId() == R.id.TramsConditionID) {
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), TConditionActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.ReferFeiendID) {
                    int counter = 0;
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");

                    String shareMessage = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";

                    String sharebody = shareMessage;
                    String sharesubject = "WELCOME TO\n"+
                            "MANGROVE HOTEL RAK\n"+
                            "TOP LOCATION\nEVENT LOCATION\nRELAXATION\n" +
                            "Download The link below" + "\n\n" + sharebody + "";
                    intent.putExtra(Intent.EXTRA_TEXT, sharesubject);
                    //  intent.putExtra(Intent.EXTRA_SUBJECT, sharebody);
                    startActivity(Intent.createChooser(intent, "share with"));
                }




                if (menuItem.getItemId() == R.id.LogoutID) {
                    Mauth.signOut();
                    Intent intent = new Intent(Home_Activity.this, Landing_Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }


                if(menuItem.getItemId() == R.id.HomeMettingsID){
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), MetingActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if(menuItem.getItemId() == R.id.HomeSWIMMINGPOOLID){
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), SwmmingPoolActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                if(menuItem.getItemId() == R.id.HomeIDFITNESSCENTERID){
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Intent intent = new Intent(getApplicationContext(), FitnessActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                if(menuItem.getItemId() == R.id.RExctileID){
                    menuItem.setCheckable(true);
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(Gravity.LEFT);

                    Intent intent = new Intent(getApplicationContext(), exceutiveLaungue.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }


                return true;
            }
        });


        View Mview = navigationView.inflateHeaderView(R.layout.header_layout);
        name = Mview.findViewById(R.id.usernameID);
        name.setText(usernameget);
        MuserDatabase.child(CurrentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    if (dataSnapshot.hasChild("username")) {
                        usernameget = dataSnapshot.child("username").getValue().toString();
                        name.setText(usernameget);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(Gravity.LEFT);
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {

        FirebaseUser Muser = Mauth.getCurrentUser();
        if (Muser == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        } else {

            MuserDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (!dataSnapshot.hasChild(CurrentUserID)) {
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

        super.onStart();
    }
}
