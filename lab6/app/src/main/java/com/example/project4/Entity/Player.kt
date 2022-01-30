package com.example.project4.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Player(
    @ColumnInfo(name = "player_name")
    var name: String?,
    @ColumnInfo(name = "player_surname")
    var surname: String?,
    @ColumnInfo(name = "player_position")
    var position: String?,
    @ColumnInfo(name = "player_club")
    var club: String?,
    @ColumnInfo(name = "player_nationality")
    var nationality: String?,
    @ColumnInfo(name = "player_birth_year")
    var birthYear: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}