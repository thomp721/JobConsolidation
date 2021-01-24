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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Company c = new Company("Google", "google.com", "CS", "04/04", "high", "false", "", "false");
        Company d = new Company("Sony", "sony.com", "Game Dev", "01/02", "high", "true", "SQL, Node JS", "false");

        /*DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.someplace.com");
        ResponseHandler<String> resHandler = new BasicResponseHandler();
        String page = httpClient.execute(httpGet, resHandler);*/
        mDatabaseReference = mDatabase.getReference().child(c.getName()).child("URL:");
        mDatabaseReference.setValue(c.getUrl());
        mDatabaseReference = mDatabase.getReference().child(c.getName()).child("Field:");
        mDatabaseReference.setValue(c.getField());
        mDatabaseReference = mDatabase.getReference().child(c.getName()).child("Response Date:");
        mDatabaseReference.setValue(c.getResponseDate());
        mDatabaseReference = mDatabase.getReference().child(c.getName()).child("Competitiveness:");
        mDatabaseReference.setValue(c.getCompetitiveness());
        mDatabaseReference = mDatabase.getReference().child(c.getName()).child("Has Preference:");
        mDatabaseReference.setValue(c.isHasPreference());
        mDatabaseReference = mDatabase.getReference().child(c.getName()).child("Preference:");
        mDatabaseReference.setValue(c.getPreference());
        mDatabaseReference = mDatabase.getReference().child(c.getName()).child("Requires Prior Experience:");
        mDatabaseReference.setValue(c.isRequiresPriorExperience());
        //mDatabaseReference.child("URL:").push().setValue(c.getUrl());
        mDatabaseReference = mDatabase.getReference().child(d.getName()).child("Date:");
        mDatabaseReference.setValue(d.getResponseDate());
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
