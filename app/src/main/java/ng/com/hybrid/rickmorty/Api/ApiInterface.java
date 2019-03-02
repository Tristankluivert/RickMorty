package ng.com.hybrid.rickmorty.Api;

import ng.com.hybrid.rickmorty.Model.Info;
import ng.com.hybrid.rickmorty.Model.InfoCha;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("episode")
    Call<Info> getEpisodes(

             @Query("page") String page

    );

    @GET("character")
    Call<InfoCha> getCharacters(
            @Query("page") String page

    );


}
