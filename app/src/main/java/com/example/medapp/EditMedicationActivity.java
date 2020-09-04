package com.example.medapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditMedicationActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editInstructions;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_medication);

        Spinner spinner = (Spinner) findViewById(R.id.frequency_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.frequency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        editName = findViewById(R.id.medname_field);
        editInstructions = findViewById(R.id.medinstructions_field);
        String medName = getIntent().getStringExtra("name");
        String instructions = getIntent().getStringExtra("instructions");
        id = getIntent().getIntExtra("id", 0);
        editName.setText(medName);
        editInstructions.setText(instructions);

    }

    @Override
    protected void onPause() {
        super.onPause();

        MedicationsMenuActivity.medicationsDatabase.medicationDao().save(editName.getText().toString(), editInstructions.getText().toString(), id);
    }
}