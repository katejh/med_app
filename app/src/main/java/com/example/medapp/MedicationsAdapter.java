package com.example.medapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicationsAdapter extends RecyclerView.Adapter<MedicationsAdapter.MedicationsMenuHolder> {
    public static class MedicationsMenuHolder extends RecyclerView.ViewHolder {
        LinearLayout containerView;
        TextView medNameView;
        TextView medInstructionsView;

        MedicationsMenuHolder(View view){
            super(view);
            containerView = view.findViewById(R.id.medications_row);
            medNameView = view.findViewById(R.id.medications_row_name);
            medInstructionsView = view.findViewById(R.id.medications_row_instructions);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Medication current = (Medication) containerView.getTag();

                    Intent intent = new Intent(view.getContext(), EditMedicationActivity.class);
                    intent.putExtra("id", current.id);
                    intent.putExtra("name", current.name);
                    intent.putExtra("instructions", current.instructions);

                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    private List<Medication> medications = new ArrayList<>();

    @NonNull
    @Override
    public MedicationsMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medications_row, parent, false);
        return new MedicationsMenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationsMenuHolder holder, int position) {
        Medication current = medications.get(position);
        holder.medNameView.setText(current.name);
        holder.medInstructionsView.setText(current.instructions);
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return medications.size();
    }

    public void reload() {
        medications = MedicationsMenuActivity.medicationsDatabase.medicationDao().getAllMedications();
    }
}
