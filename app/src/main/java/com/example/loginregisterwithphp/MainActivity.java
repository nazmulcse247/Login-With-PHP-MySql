package com.example.loginregisterwithphp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt,phoneEt,locationEt;
    private MaterialButton submitBtn;
    private ApiService apiService;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameEt = findViewById(R.id.et_name);
        phoneEt = findViewById(R.id.et_phone);
        locationEt = findViewById(R.id.et_location);

        submitBtn = findViewById(R.id.btn_submit);
        productList = new ArrayList<>();
        productList.add(new Product("Gents Pants","120"));
        productList.add(new Product("Ladies Pants","120"));

        String json = new Gson().toJson(productList);



        apiService = ApiClient.getRetrofit().create(ApiService.class);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString();
                String phone = phoneEt.getText().toString();
                String location = locationEt.getText().toString();

                Log.d("input", "onClick:"+name + phone + location);

                Call<RegisterResponse> responseCall = apiService.getRegisterResponse(name,phone,location);
                responseCall.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        RegisterResponse registerResponse = response.body();
                        Toast.makeText(MainActivity.this, ""+ registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}