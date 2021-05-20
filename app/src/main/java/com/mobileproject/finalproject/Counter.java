package com.mobileproject.finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileproject.finalproject.databinding.FragmentCounterBinding;


public class Counter extends Fragment implements View.OnClickListener {
    private FragmentCounterBinding binding;
    private SharedPreferences sp;
    private int currentCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCounterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sp = this.getActivity().getSharedPreferences("COUNT", Context.MODE_PRIVATE);
        showCount();
        binding.kurang.setOnClickListener(this);
        binding.tambah.setOnClickListener(this);
        binding.reset.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == binding.kurang.getId()){
            currentCount = sp.getInt("Current", 0);
            currentCount--;
            saveCount(currentCount);
            showCount();
        }else if(v.getId() == binding.tambah.getId()){
            currentCount = sp.getInt("Current", 0);
            currentCount++;
            saveCount(currentCount);
            showCount();
        }else if(v.getId() == binding.reset.getId()){
            saveCount(0);
            showCount();
        }
    }

    private void saveCount(int currentCount){
        SharedPreferences.Editor editor  = sp.edit();
        editor.putInt("Current", currentCount);
        editor.apply();
    }
    private void showCount(){
        binding.count.setText(String.valueOf(sp.getInt("Current", 0)));
    }
}