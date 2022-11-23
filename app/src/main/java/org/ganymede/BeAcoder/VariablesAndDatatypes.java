package org.ganymede.BeAcoder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ganymede.BeAcoder.Api.ApiHandler;
import org.ganymede.BeAcoder.Api.ApiService;
import org.ganymede.BeAcoder.Api.PostData;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VariablesAndDatatypes extends AppCompatActivity {

    TextView tvResult;
    EditText etInput;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variables_and_datatypes);

        tvResult  = findViewById(R.id.tv_result);
        etInput   = findViewById(R.id.et_input);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiService apiService = ApiHandler.getRetrofitInstance();
                Call<String> execute = apiService.execute(new PostData(etInput.getText().toString()));

                tvResult.setText("Loading...");

                execute.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        tvResult.setText("");

                        try {

                            if(response.isSuccessful()){


                                JSONObject responseJson = new JSONObject(response.body().toString());
                                String output = responseJson.getString("output");
                                tvResult.setText(output);

                            }else{

                                Toast.makeText(VariablesAndDatatypes.this, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(VariablesAndDatatypes.this, "Gagal Parsing JSON : " + e.getMessage(), Toast.LENGTH_SHORT).show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                        tvResult.setText("Failed");
                        Toast.makeText(VariablesAndDatatypes.this, "Gagal : " + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }

}