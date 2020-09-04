package com.example.medapp;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.View;

/*
 * Handles displaying all the necessary views inside activity_medications_menu.xml
 *
 * TODO: for some reason new edited data won't load when returning to medications menu page from edit page. Investigate later please
 */

public class MedicationsMenuActivity extends AppCompatActivity {

    private RecyclerView medicationsMenuRecyclerView;
    private MedicationsAdapter medicationsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static MedicationsDatabase medicationsDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_medications_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        // initialize database of medications
        medicationsDatabase = Room.databaseBuilder(getApplicationContext(), MedicationsDatabase.class, "medications")
                .allowMainThreadQueries() // allow the database to run queries in the foreground (since the database shouldn't be so heavy as to need it in the background)
                .build();

        // handles all the stuff to set up the display of the medications recycler view and the data within it
        medicationsMenuRecyclerView = findViewById(R.id.medications_menu_recycler);
        layoutManager = new LinearLayoutManager(this);
        medicationsAdapter = new MedicationsAdapter();

        medicationsMenuRecyclerView.setLayoutManager(layoutManager);
        medicationsMenuRecyclerView.setAdapter(medicationsAdapter);

        // button for the ability to add a new medication to the database
        FloatingActionButton add_medication_button = (FloatingActionButton) findViewById(R.id.add_medication_button);
        add_medication_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create a new medication
                medicationsDatabase.medicationDao().create();
                medicationsAdapter.reload();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // queries database for all existing medications
        medicationsAdapter.reload();
    }
}