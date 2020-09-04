package com.example.medapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class EditMedicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_medication);

        Spinner frequency_spinner = (Spinner) findViewById(R.id.frequency_spinner);
        ArrayAdapter<CharSequence> frequecy_adapter = ArrayAdapter.createFromResource(this,
                R.array.frequency_array, android.R.layout.simple_spinner_item);
        frequecy_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frequency_spinner.setAdapter(frequecy_adapter);

        Spinner end_date_spinner = (Spinner) findViewById(R.id.end_date_spinner);
        ArrayAdapter<CharSequence> end_date_adapter = ArrayAdapter.createFromResource(this,
                R.array.frequency_array, android.R.layout.simple_spinner_item);
        end_date_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        end_date_spinner.setAdapter(end_date_adapter);

        NumberPicker mednumpicker = findViewById(R.id.mednumpicker);

        mednumpicker.setMaxValue(150);
        mednumpicker.setMinValue(0);

    }
}