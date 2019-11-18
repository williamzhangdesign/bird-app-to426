package com.example.bird;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText birdname2, personname2, zipcode2;
    Button searchbutton2, submitbutton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        birdname2 = findViewById(R.id.birdname2);
        personname2 = findViewById(R.id.personname2);
        zipcode2 = findViewById(R.id.zipcode2);

        searchbutton2 = findViewById(R.id.back);
        submitbutton2 = findViewById(R.id.submitbutton2);

        searchbutton2.setOnClickListener(this);
        submitbutton2.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId() == R.id.report) {

            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);

        }

        else if (item.getItemId() == R.id.search);
        {

            Intent intent = new Intent(this, Report.class);

            startActivity(intent);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Birds");

        if (view == searchbutton2) {

            Intent searchintent = new Intent(this, Report.class);

            startActivity(searchintent);

        } else if (view == submitbutton2) {

            String birdname = birdname2.getText().toString();

            String personname = personname2.getText().toString();

            int zipcode1 = Integer.parseInt(zipcode2.getText().toString());

            Bird bird1 = new Bird(birdname, zipcode1, personname);

            myRef.push().setValue(bird1);

        }
    }

}
