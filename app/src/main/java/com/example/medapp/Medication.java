package com.example.medapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
 * Medication (object)
 * Attributes:
 *  id
 *  name
 *  amountLeft
 *  instructions
 *
 * This object creates itself in the Room database
 *
 * TODO:
 *  add the following attributes:
        - pattern and frequency of medication
        - end date
        - custom color
 */

@Entity(tableName = "medications")
public class Medication {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "amount_left")
    public int amountLeft;

    @ColumnInfo(name = "instructions")
    public String instructions;

}
