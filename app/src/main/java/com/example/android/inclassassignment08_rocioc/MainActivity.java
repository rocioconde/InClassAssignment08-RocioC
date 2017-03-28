package com.example.android.inclassassignment08_rocioc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    String displayFamily;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = (TextView) findViewById(R.id.display_text);
        displayFamily = displayText.getText().toString();

    }

    @Override
    protected void onResume() {
        super.onResume();
        displayFamily = displayText.getText().toString();
    }


    public void addNewFamily(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, RequestCodes.ADD_FAMILY);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RequestCodes.ADD_FAMILY && resultCode == RESULT_OK) {
            Family family = (Family) data.getSerializableExtra(Keys.FAMILY);
            displayFamily = family.toString();
            String listOfFamilies = displayFamily + "\n" + "\n" + family.toString();
            displayText.setText(listOfFamilies.toString());

        }
    }
}
