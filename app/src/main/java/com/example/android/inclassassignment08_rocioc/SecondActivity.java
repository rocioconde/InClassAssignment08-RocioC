package com.example.android.inclassassignment08_rocioc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference familyRef = database.getReference("family");


    private EditText lastName;
    private EditText numberOfMembers;
    private CheckBox comingToParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lastName = (EditText) findViewById(R.id.family_last_name);
        numberOfMembers = (EditText) findViewById(R.id.number_of_members);
        comingToParty = (CheckBox) findViewById(R.id.coming_to_party);
    }

    public void addToFirebase(View view) {

        String familyLastName = lastName.getText().toString();
        String members = numberOfMembers.getText().toString();
        int numberOfMembers1 = Integer.parseInt(members);
        boolean comingToTheParty;
        comingToTheParty = comingToParty.isChecked();

        Family f = new Family(familyLastName, numberOfMembers1, comingToTheParty);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        familyRef.push().setValue(new Family(familyLastName, numberOfMembers1, comingToTheParty));
    }
}
