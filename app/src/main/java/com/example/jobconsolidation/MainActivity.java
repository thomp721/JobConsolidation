package com.example.jobconsolidation;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    private ArrayList<Company> array = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        spinner = (Spinner) findViewById(R.id.spinner2);


        mDatabaseReference = mDatabase.getReference();
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int iterate = 0;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Company company = dataSnapshot.getValue(Company.class);
                    array.add(company);
                    iterate++;
                    if (company.getName() != "failure") {
                        System.out.println(company.getName());
                    }
                }
                for (int i = 0; i < 100; i++) {
                    if (array.size() <= i) {
                        break;
                    }
                    names.add(array.get(i).getName());
                }
                ArrayAdapter adapt = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, names);
                adapt.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner.setAdapter(adapt);


                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String toString = array.get(spinner.getSelectedItemPosition()).toString();
                        TextView helloTextView = (TextView) findViewById(R.id.textView);
                        helloTextView.setText(toString);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                String toString = array.get(spinner.getSelectedItemPosition()).toString();
                TextView helloTextView = (TextView) findViewById(R.id.textView);
                helloTextView.setText(toString);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                for (int i = 0; i < 5; i++) {
                    if (array.size() > i) {
                        System.out.println(array.get(i).getName());
                    }
                    else {
                        System.out.println("god damn it");
                    }
                }

                for (int i = 0; i < 100; i++) {
                    if (array.size() <= i) {
                        break;
                    }
                    names.add(array.get(i).getName());
                }


                  /*
                mDatabaseReference = mDatabaseReference.child("Company");
                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Company company = dataSnapshot.getValue(Company.class);
                            System.out.println(company.getName());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }); */


            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();

}
