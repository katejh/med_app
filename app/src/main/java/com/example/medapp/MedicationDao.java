package com.example.medapp;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

/*
 * Medication data access object
 * Each function has a related SQL query for a Medication object in the database
 */
@Dao
public interface MedicationDao {
    @Query("INSERT INTO medications (name, amount_left, instructions) VALUES ('New medication', '0', 'instructions')")
    void create();

    @Query("SELECT * FROM medications")
    List<Medication> getAllMedications();

    @Query("UPDATE medications SET name = :name, instructions = :instructions WHERE id = :id")
    void save(String name, String instructions, int id);
}
