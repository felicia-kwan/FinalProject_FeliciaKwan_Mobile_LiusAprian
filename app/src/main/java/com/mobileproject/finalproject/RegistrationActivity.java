package com.mobileproject.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

import com.mobileproject.finalproject.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegistrationBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("Registration", MODE_PRIVATE);
        binding.btnRegis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == binding.btnRegis.getId()){
            String getBimbelId = binding.etIdbimbel.getText().toString();
            String getName = binding.etName.getText().toString();
            String getPassword = binding.etPasswordRegistration.getText().toString();
            String getEmail = binding.etEmail.getText().toString();
            String confirm = binding.etConfirmpass.getText().toString();
            if(getBimbelId.isEmpty()){
                binding.etIdbimbel.setError("Please fill in the Bimbel Id");
            } else if(getName.isEmpty()){
                binding.etName.setError("Please fill the username");
            }else if(getName.length() < 5){
               binding.etName.setError("Name must be more than 5 letters");
            } else if(getEmail.isEmpty()){
                binding.etEmail.setError("Please fill the email");
            }else if(getPassword.isEmpty()){
                binding.etPasswordRegistration.setError("Please fill the password");
            }else if(!confirm.equals(getPassword)){
                binding.etConfirmpass.setError("Password Confirmation Wrong");
            } else if(!getEmail.contains("@")){
                binding.etEmail.setError("Email must contain @");
            }else if(!getEmail.endsWith(".com")){
                binding.etEmail.setError("Email must ends with .com");
            } else{
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", getName);
                editor.putString("Email", getEmail);
                editor.putString("Password",getPassword);
                editor.putString("Id Bimbel", getBimbelId);
                editor.commit();
                Intent moveToLoginActivity = new Intent(this, MainActivity.class);
                startActivity(moveToLoginActivity);
            }
        }
    }
}