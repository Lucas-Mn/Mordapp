package frise.project.mordapp.retrofit;

import frise.project.mordapp.model.RowContainer;
import frise.project.mordapp.retrofit.HELPER;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RowService {

    @GET(HELPER.API_ENDPOINT)
    Call<RowContainer> getRows(@Query(HELPER.ID_KEY) String id);

}
