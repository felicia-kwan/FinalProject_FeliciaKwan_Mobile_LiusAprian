package com.mobileproject.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Toast;

import com.mobileproject.finalproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private static final String PREFER_NAME = "Registration";
    UserSession session;
    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnRegister.setOnClickListener(this);
        session = new UserSession(getApplicationContext());
        sharedPreferences = getSharedPreferences("Registration", MODE_PRIVATE);
        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == binding.btnRegister.getId()){
            Intent moveToRegistrationActivity = new Intent(this,RegistrationActivity.class);
            startActivity(moveToRegistrationActivity);
        }else if(v.getId() == binding.btnLogin.getId()){
            String getEmail = binding.etEmailLogin.getText().toString();
            String getPassword = binding.etPasswordLogin.getText().toString();

            if(getEmail.isEmpty()){
                binding.etEmailLogin.setError("Please fill the username");
            }else if(getPassword.isEmpty()){
                binding.etPasswordLogin.setError("Please fill the password");
            }else{
                String uEmail = null;
                String uPassword = null;
                if(sharedPreferences.contains("Email")){
                    uEmail = sharedPreferences.getString("Email", "");
                }
                if(sharedPreferences.contains("Password")){
                    uPassword = sharedPreferences.getString("Password", "");
                }
                if(getEmail.equals(uEmail) && getPassword.equals(uPassword)){
                    session.createUserLoginSession(uEmail,uPassword);
                    Intent moveToHomeActivity = new Intent(this, HomeActivity.class);
                    moveToHomeActivity.putExtra("User name",sharedPreferences.getString("Name", ""));
                    startActivity(moveToHomeActivity);
                    finish();
                }else{
                    Toast.makeText(this,"Wrong username or password", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}