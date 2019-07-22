package frise.project.mordapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import frise.project.mordapp.model.Row;

@Dao
public interface RowRoomDAO {

    @Query("SELECT * FROM [row]")
    List<RowEntity> getAll();

    @Insert
    void insertRow(RowEntity row);

    @Query("DELETE FROM [row]")
    void clearTable();

}
