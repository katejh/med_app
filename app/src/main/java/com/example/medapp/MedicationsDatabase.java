package com.example.medapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/*
 * Entry point for all the data access objects to use the Room database of medications
 */

@Database(entities = {Medication.class}, version = 1)
public abstract class MedicationsDatabase extends RoomDatabase {
    public abstract MedicationDao medicationDao();
}
