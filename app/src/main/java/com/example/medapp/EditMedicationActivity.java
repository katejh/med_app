package com.example.medapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import android.widget.NumberPicker;

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

        Spinner frequency_spinner = (Spinner) findViewById(R.id.frequency_spinner);
        ArrayAdapter<CharSequence> frequency_adapter = ArrayAdapter.createFromResource(this,
                R.array.frequency_array, android.R.layout.simple_spinner_item);
        frequency_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frequency_spinner.setAdapter(frequency_adapter);

        Spinner end_date_spinner = (Spinner) findViewById(R.id.end_date_spinner);
        ArrayAdapter<CharSequence> end_date_adapter = ArrayAdapter.createFromResource(this,
                R.array.frequency_array, android.R.layout.simple_spinner_item);
        end_date_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        end_date_spinner.setAdapter(end_date_adapter);

        NumberPicker medNumPicker = findViewById(R.id.mednumpicker);

        medNumPicker.setMaxValue(150);
        medNumPicker.setMinValue(0);

        // i don't know what this does or how it works???? but it's important
        // MedicationsAdapter sends data to EditMedicationActivity through the Intent object somehow to display in the necessary fields
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