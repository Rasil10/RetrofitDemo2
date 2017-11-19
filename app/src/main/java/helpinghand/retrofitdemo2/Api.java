package helpinghand.retrofitdemo2;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rasil10 on 2017-11-16.
 */

public interface Api {

//    String BASE_URL="http://pratikbutani.x10.mx";
//
//    @GET("/json_data.json")
//    Call<ContactList> getContact();
    String BASE_URL="http://thesunbi.com/demo/inscid/api/";

    @GET("postal-codes")
    Call<PostalCode> getPostalCodes();
}
