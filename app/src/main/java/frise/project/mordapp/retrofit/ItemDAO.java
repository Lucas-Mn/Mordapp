package frise.project.mordapp.retrofit;

import android.util.Log;

import frise.project.mordapp.model.Row;
import frise.project.mordapp.model.RowContainer;
import frise.project.mordapp.retrofit.MyRetrofit;
import frise.project.mordapp.retrofit.RowService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDAO extends MyRetrofit {

    private RowService service;

    private API api;
    public enum API { GSX, SHEETY }
    public ItemDAO(API api) {
        super( api.equals(API.GSX) ? GSX2JSON.BASE_URL : SHEETY.BASE_URL);
        this.api = api;
        service = retrofit.create(RowService.class);
    }

    public void getRowContainer(final ResultListener<RowContainer> listener){
        if(api.equals(API.GSX))
            getRowContainerGSX(listener);
//        else if(api.equals(API.SHEETY))
//            getRowContainerSheety(listener);
    }

    private void getRowContainerGSX(final ResultListener<RowContainer> listener) {
        Call<RowContainer> call = service.getRowsGSX(GSX2JSON.GSID, false);
        call.enqueue(new Callback<RowContainer>() {
            @Override
            public void onResponse(Call<RowContainer> call, Response<RowContainer> response) {
                if(response.body()!=null)
                    listener.finish(response.body());
                else {
                    Log.d(HELPER.DEBUG, "response with null body, message: " + response.message());
                    listener.error(response.message()); }
            }

            @Override
            public void onFailure(Call<RowContainer> call, Throwable t) {
                Log.d(HELPER.DEBUG, "call fail: "+t.getMessage());
                listener.error(t.getMessage()); }});
        Log.d(HELPER.DEBUG, "Request to GSX: " + call.request().toString());
    }

//    private void getRowContainerSheety(final ResultListener<RowContainer> listener) {
//        Call<Row[]> call = service.getRowsSheety();
//        call.enqueue(new Callback<Row[]>() {
//            @Override
//            public void onResponse(Call<Row[]> call, Response<Row[]> response) {
//                if(response.body()!=null)
//                    listener.finish(new RowContainer(response.body()));
//                else{
//                    Log.d(HELPER.DEBUG, "response with null body, message: " + response.message());
//                    listener.error(response.message()); }
//            }
//
//            @Override
//            public void onFailure(Call<Row[]> call, Throwable t) {
//                Log.d(HELPER.DEBUG, "call fail: "+t.getMessage());
//                listener.error(t.getMessage()); }});
//        Log.d(HELPER.DEBUG, call.request().toString());
//    }
}
