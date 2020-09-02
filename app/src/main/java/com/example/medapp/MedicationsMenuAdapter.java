package com.example.medapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MedicationsMenuAdapter extends RecyclerView.Adapter<MedicationsMenuAdapter.MedicationsMenuHolder> {
    public static class MedicationsMenuHolder extends RecyclerView.ViewHolder {
        CoordinatorLayout containerView;

        MedicationsMenuHolder(View view){
            super(view);
            containerView = view.findViewById(R.id.menu_scrolling);
        }
    }

    @NonNull
    @Override
    public MedicationsMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_scrolling, parent, false);
        return MedicationsMenuHolder(view);
    }
}
