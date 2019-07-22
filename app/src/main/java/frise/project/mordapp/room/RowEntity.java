package frise.project.mordapp.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

import frise.project.mordapp.model.Row;
import frise.project.mordapp.model.RowContainer;

@Entity(tableName = "row")
public class RowEntity {

    @PrimaryKey
    public Long uid;


    public String data;

    public RowEntity(){}
    public RowEntity(Row row){ this.data = row.toString(); }

    public Row asRow() {
        return new Row(data);
    }

    public static RowContainer buildContainer(List<RowEntity> rows) {
        List<Row> newList = new ArrayList<>();
        for(RowEntity row : rows)
            newList.add(row.asRow());
        return new RowContainer(newList);
    }

}
