package frise.project.mordapp.retrofit;

import frise.project.mordapp.model.Row;
import frise.project.mordapp.model.RowContainer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RowService {

    @GET(GSX2JSON.API_ENDPOINT)
    Call<RowContainer> getRowsGSX(@Query(GSX2JSON.ID_KEY) String id, @Query(GSX2JSON.COLUMNS_KEY) Boolean columns);

    @GET(SHEETY.ID)
    Call<Row[]> getRowsSheety();

}
