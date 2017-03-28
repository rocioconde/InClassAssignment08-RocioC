package com.example.android.inclassassignment08_rocioc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String displayFamily;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference familyRef = database.getReference("family");
    private ArrayList<Family> familyList = new ArrayList<>();
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = (TextView) findViewById(R.id.display_text);
        displayFamily = displayText.getText().toString();

        familyRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                familyList.add(dataSnapshot.getValue(Family.class));
                displayFamily();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Family.class) + " has changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Family.class) + " is removed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void displayFamily() {
        String text = "";
        for (Family p : familyList)
            text += p + "\n";
        displayText.setText(text);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        displayFamily = displayText.getText().toString();
//    }


    public void addNewFamily(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


}
