package com.example.medapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicationsMenuAdapter extends RecyclerView.Adapter<MedicationsMenuAdapter.MedicationsMenuHolder> {
    public static class MedicationsMenuHolder extends RecyclerView.ViewHolder {
        CoordinatorLayout containerView;
        EditText medNameView;

        MedicationsMenuHolder(View view){
            super(view);
            containerView = view.findViewById(R.id.activity_edit_medication);
            medNameView = view.findViewById(R.id.medname_field);
        }
    }

    private List<Medication> medications = new ArrayList<>();

    @NonNull
    @Override
    public MedicationsMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_edit_medication, parent, false);
        return new MedicationsMenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationsMenuHolder holder, int position) {
        Medication current = medications.get(position);
        holder.medNameView.setText(current.name);
    }

    @Override
    public int getItemCount() {
        return medications.size();
    }
}
