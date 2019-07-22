package frise.project.mordapp.room;

import androidx.room.Database;

@Database(entities = {RowEntity.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    public abstract RowRoomDAO dao();

}
