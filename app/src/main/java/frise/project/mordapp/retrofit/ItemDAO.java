package frise.project.mordapp.retrofit;

import android.util.Log;

import frise.project.mordapp.model.RowContainer;
import frise.project.mordapp.retrofit.MyRetrofit;
import frise.project.mordapp.retrofit.RowService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDAO extends MyRetrofit {

    private RowService service;

    public ItemDAO()
    {
        super();
        service = retrofit.create(RowService.class);
    }

    public void getRowContainer(final ResultListener<RowContainer> listener)
    {
        Call<RowContainer> call = service.getRows(HELPER.GSID);
        call.enqueue(new Callback<RowContainer>() {
            @Override
            public void onResponse(Call<RowContainer> call, Response<RowContainer> response) {
                listener.finish(response.body());
            }

            @Override
            public void onFailure(Call<RowContainer> call, Throwable t) {
                Log.d(HELPER.DEBUG, "call fail: "+t.getMessage());
            }
        });
        Log.d(HELPER.DEBUG, call.request().toString());

    }
}
