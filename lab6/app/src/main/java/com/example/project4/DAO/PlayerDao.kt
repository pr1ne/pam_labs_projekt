package com.example.project4.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.project4.Entity.Player

@Dao
interface PlayerDao {
    @Query("select * from player")
    fun getAll(): List<Player>
    @Query("select * from player where id = :playerId")
    fun getById(playerId: Int): Player
    @Query("select * from player where player_name = :name and player_surname = :surname")
        fun getByNameAndSurname(name: String, surname: String): Player
        @Insert
        fun insert(player: Player)
        @Insert
        fun insertAll(vararg players: Player)
        @Delete
        fun delete(player: Player)
}