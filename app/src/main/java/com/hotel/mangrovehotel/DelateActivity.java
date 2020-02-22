package com.hotel.mangrovehotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DelateActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DatabaseReference Mpostdatabase;
    private String messageget;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delate);

        recyclerView = findViewById(R.id.DelateViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Mpostdatabase = FirebaseDatabase.getInstance().getReference().child("Post");

        toolbar = findViewById(R.id.DelateToolbarID);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Delate");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {

        FirebaseRecyclerAdapter<PostHolder, BestDeals.PostViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<PostHolder, BestDeals.PostViewHolder>(
                PostHolder.class,
                R.layout.offer_design,
                BestDeals.PostViewHolder.class,
                Mpostdatabase
        ) {

            protected void populateViewHolder(final BestDeals.PostViewHolder postViewholder, final PostHolder postHolder, int i) {

                final String UID = getRef(i).getKey();
                Mpostdatabase.child(UID).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.exists()) {


                            if (dataSnapshot.hasChild("current_date") || dataSnapshot.hasChild("current_time")) {
                                String current_dateget = dataSnapshot.child("current_date").getValue().toString();
                                String current_timeget = dataSnapshot.child("current_time").getValue().toString();
                                postViewholder.setdate_time(current_timeget+" | "+current_dateget);
                            }

                            if (dataSnapshot.hasChild("image")) {
                                String imageget = dataSnapshot.child("image").getValue().toString();
                                postViewholder.setImage(imageget);
                            }
                            if (dataSnapshot.hasChild("message")) {
                                messageget = dataSnapshot.child("message").getValue().toString();
                                postViewholder.seturlset(messageget);
                            }


                            postViewholder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                                @Override
                                public boolean onLongClick(View v) {

                                    AlertDialog.Builder Mbuiler = new AlertDialog.Builder(DelateActivity.this);

                                    Mbuiler.setTitle("Select Option");
                                    CharSequence charSequence[] = new CharSequence[]{
                                            "Delate"
                                    };

                                    Mbuiler.setItems(charSequence, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if(which == 0){
                                               // Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
                                                Mpostdatabase.child(UID)
                                                        .removeValue()
                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if(task.isSuccessful()){
                                                                    Toast.makeText(getApplicationContext(), "Item Remove", Toast.LENGTH_LONG).show();
                                                                }
                                                                else {
                                                                    Toast.makeText(getApplicationContext(), task.getException().getMessage().toString(), Toast.LENGTH_LONG).show();
                                                                }
                                                            }
                                                        }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                            }
                                        }
                                    });

                                    AlertDialog alertDialog = Mbuiler.create();
                                    alertDialog.show();


                                    return true;
                                }
                            });

                        } else {
                            Toast.makeText(getApplicationContext(), "no data found", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
        super.onStart();
    }


    static public class PostViewHolder extends RecyclerView.ViewHolder {

        private View Mview;
        private TextView url;
        private ImageView postimage;
        private Context context;
        private TextView time_date;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            Mview = itemView;

            url = Mview.findViewById(R.id.OnlineUrlID);
            postimage = Mview.findViewById(R.id.ToDayOfferImageID);
            context = Mview.getContext();
            time_date = Mview.findViewById(R.id.Timage_DateID);
        }



        public void seturlset(String ur) {
            url.setText(ur);
        }

        public void setImage(String img) {
            Picasso.with(context).load(img).placeholder(R.drawable.defaultgalleryimage).into(postimage);
        }

        public void setdate_time(String time){
            time_date.setText(time);
        }
    }
}
