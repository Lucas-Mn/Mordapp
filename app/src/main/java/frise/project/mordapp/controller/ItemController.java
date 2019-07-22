package frise.project.mordapp.controller;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import java.util.List;

import frise.project.mordapp.model.Item;
import frise.project.mordapp.model.Row;
import frise.project.mordapp.model.RowContainer;
import frise.project.mordapp.retrofit.GSX2JSON;
import frise.project.mordapp.retrofit.HELPER;
import frise.project.mordapp.retrofit.ItemDAO;
import frise.project.mordapp.retrofit.ResultListener;
import frise.project.mordapp.room.RoomDatabase;
import frise.project.mordapp.room.RowEntity;
import frise.project.mordapp.room.RowRoomDAO;

public class ItemController {

    private ItemDAO daoGSX;
    private ItemDAO daoSheety;
    private RoomDatabase db;
    private RowRoomDAO roomDao;

    public ItemController(Context context) {
        daoGSX = new ItemDAO(ItemDAO.API.GSX);
        //daoSheety = new ItemDAO(ItemDAO.API.SHEETY);
        db = Room.databaseBuilder(context, RoomDatabase.class, "db")
                .allowMainThreadQueries().build();
        roomDao = db.dao();
    }

    public void getItems(final ResultListener<List<Item>> listener) {
        daoGSX.getRowContainer(new ResultListener<RowContainer>() {
            @Override
            public void finish(RowContainer container) {
                //store in cache
                roomDao.clearTable();
                for(Row row : container.getRows())
                    roomDao.insertRow(new RowEntity(row));
                //send to listener
                listener.finish(container.getItems());
            }

            @Override
            public void error(String message) {
                Log.d(HELPER.DEBUG, message); }});
    }

    public List<Item> getItemsRoom() {
        return RowEntity.buildContainer(roomDao.getAll()).getItems();
    }

}