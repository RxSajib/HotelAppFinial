package com.hotel.mangrovehotel;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hsalf.smilerating.SmileRating;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragement_four extends Fragment {

    private DatabaseReference MRatingDatabase;
    private FirebaseAuth Mauth;
    private String CurrentuserID;
    private SmileRating smileRating;
    private String SmilleText = "";

    public Fragement_four() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragement_four, container, false);


        MRatingDatabase = FirebaseDatabase.getInstance().getReference().child("Rating");
        Mauth = FirebaseAuth.getInstance();
        CurrentuserID = Mauth.getCurrentUser().getUid();
        smileRating = view.findViewById(R.id.DonationSysteam);

        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int i, boolean b) {

                switch (i) {

                    case SmileRating.TERRIBLE:
                        SmilleText = "Terrible";
                        updateFragement(SmilleText);
                        break;

                    case SmileRating.BAD:
                        SmilleText = "Bad";
                        updateFragement(SmilleText);
                        break;

                    case SmileRating.OKAY:
                        SmilleText = "Okay";
                        updateFragement(SmilleText);
                        break;

                    case SmileRating.GOOD:
                        SmilleText = "Good";
                        updateFragement(SmilleText);
                        break;

                    case SmileRating.GREAT:
                        SmilleText = "Great";
                        updateFragement(SmilleText);
                        break;
                }
            }
        });




        return view;
    }

    private void updateFragement(String value) {
        Map usermap = new HashMap();
        usermap.put("Hotel_Staff", value);
        MRatingDatabase.child(CurrentuserID)
                .updateChildren(usermap)
                .addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {

                        } else {
                            Toast.makeText(getContext(), task.getException().getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
