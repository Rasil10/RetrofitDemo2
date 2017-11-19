package helpinghand.retrofitdemo2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private View parentView;

    private List<Contact> contactList = new ArrayList<>();
    private List<PostalCode> postalCodeList = new ArrayList<>();
    private MyContactAdapter adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        final Api api = retrofit.create(Api.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
//        Call<ContactList> call=api.getContact();
//       call.enqueue(new Callback<ContactList>() {
//           @Override
//           public void onResponse(Call<ContactList> call, Response<ContactList> response) {
//               if (response.isSuccessful()){
//                   Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
//                   contactList=response.body().getContacts();
//                   progressDialog.dismiss();
//                   recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                   adapter=new MyContactAdapter(MainActivity.this,contactList);
//                   recyclerView.setAdapter(adapter);
//               }
//               else{
//                   Toast.makeText(MainActivity.this, "Something wrong at Call...", Toast.LENGTH_SHORT).show();
//               }
//
//           }
//
//           @Override
//           public void onFailure(Call<ContactList> call, Throwable t) {
//               Toast.makeText(MainActivity.this, "Failure...."+t.getMessage(), Toast.LENGTH_SHORT).show();
//
//           }
//       });

        Call<PostalCode> call = api.getPostalCodes();
        call.enqueue(new Callback<PostalCode>() {
            @Override
            public void onResponse(Call<PostalCode> call, Response<PostalCode> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    PostalCode postalCode = response.body();
                    List<PostalCode.PostalData> postalDataList = postalCode.getData().getPostalData();

                    progressDialog.dismiss();
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    adapter = new MyContactAdapter(MainActivity.this, postalDataList);
                    Log.d("count----",String.valueOf(adapter.getItemCount()));
                    recyclerView.setAdapter(adapter);
                }


            }

            @Override
            public void onFailure(Call<PostalCode> call, Throwable t) {

            }
        });

    }
}
