package com.example.projectipc;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.UUID;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Login extends AppCompatActivity  {
    APIService serviceAPI;
    EditText Username;
    EditText Password;

    ProgressDialog message;
    Button Login;
    Context context;
    String Uname;
    String pass;
    Toolbar toolbar;
    ProgressBar progressBar;
    protected void onCreate(Bundle savedInstanceState) {

        serviceAPI = RequestAPI.getAPI().create(APIService.class);
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
         Username = (EditText) findViewById(R.id.username);
         Password =(EditText)findViewById(R.id.password);

        Login = (Button) findViewById(R.id.login);
        progressBar = (ProgressBar)findViewById(R.id.progress);
        progressBar.setVisibility(View.GONE);
        Login.setVisibility(View.VISIBLE);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);



                serviceAPI.LoginUser(username(),password()).enqueue(new Callback<UserModel>() {

                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                        if(response.isSuccessful()){

                            Intent intent = new Intent(com.example.projectipc.Login.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Login.this,"User tidak ditemukan",Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
    public String username(){
        if(Username.isInEditMode() || Username.isClickable()){
            return Uname=Username.getText().toString();
        }else{
            return Uname=" ";
        }
    } public String password(){
        if(Password.isInEditMode() || Password.isClickable()){
            return Uname=Password.getText().toString();
        }else{
            return Uname=" ";
        }
    }




}
