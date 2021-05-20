package com.mobileproject.finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileproject.finalproject.databinding.FragmentAreaBinding;


public class Area extends Fragment implements View.OnClickListener {

    private FragmentAreaBinding binding;
    private int persegi = 0, segitiga = 1, lingkaran = 2, bentuk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAreaBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnPersegi.setOnClickListener(this);
        binding.btnSegitiga.setOnClickListener(this);
        binding.btnLingkaran.setOnClickListener(this);
        binding.btnHitung.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == binding.btnPersegi.getId()){
            binding.bentuk.setText("PERSEGI");
            binding.bentuk.setVisibility(View.VISIBLE);
            binding.tvPersegi.setVisibility(View.VISIBLE);
            binding.etPersegi.setVisibility(View.VISIBLE);
            binding.tvAlasSegitiga.setVisibility(View.GONE);
            binding.tvTinggiSegitiga.setVisibility(View.GONE);
            binding.etAlasSegitiga.setVisibility(View.GONE);
            binding.etTinggiSegitiga.setVisibility(View.GONE);
            binding.tvLingkaran.setVisibility(View.GONE);
            binding.etLingkaran.setVisibility(View.GONE);
            bentuk = 0;
            binding.btnHitung.setVisibility(View.VISIBLE);
        }else if(v.getId() == binding.btnSegitiga.getId()){
            binding.bentuk.setText("SEGITIGA");
            binding.bentuk.setVisibility(View.VISIBLE);
            binding.tvPersegi.setVisibility(View.GONE);
            binding.etPersegi.setVisibility(View.GONE);
            binding.tvAlasSegitiga.setVisibility(View.VISIBLE);
            binding.tvTinggiSegitiga.setVisibility(View.VISIBLE);
            binding.etAlasSegitiga.setVisibility(View.VISIBLE);
            binding.etTinggiSegitiga.setVisibility(View.VISIBLE);
            binding.tvLingkaran.setVisibility(View.GONE);
            binding.etLingkaran.setVisibility(View.GONE);
            bentuk = 1;
            binding.btnHitung.setVisibility(View.VISIBLE);
        }else if(v.getId() == binding.btnLingkaran.getId()){
            binding.bentuk.setText("LINGKARAN");
            binding.bentuk.setVisibility(View.VISIBLE);
            binding.tvPersegi.setVisibility(View.GONE);
            binding.etPersegi.setVisibility(View.GONE);
            binding.tvAlasSegitiga.setVisibility(View.GONE);
            binding.tvTinggiSegitiga.setVisibility(View.GONE);
            binding.etAlasSegitiga.setVisibility(View.GONE);
            binding.etTinggiSegitiga.setVisibility(View.GONE);
            binding.tvLingkaran.setVisibility(View.VISIBLE);
            binding.etLingkaran.setVisibility(View.VISIBLE);
            bentuk = 2;
            binding.btnHitung.setVisibility(View.VISIBLE);
        }else if(v.getId() == binding.btnHitung.getId()){
            if(bentuk == persegi){
                String panjang = binding.etPersegi.getText().toString();
                int sisi;
                int hasil;
                if(panjang.isEmpty()){
                    binding.etPersegi.setError("Panjang sisi belum diisi");
                }else{
                    sisi = Integer.parseInt(panjang);
                    hasil = sisi*sisi;
                    showResult(hasil);
                }
            }else if(bentuk == segitiga){
                String alas = binding.etAlasSegitiga.getText().toString();
                String tinggi = binding.etTinggiSegitiga.getText().toString();
                int alasx, tinggix, hasil;
                if(alas.isEmpty()){
                    binding.etAlasSegitiga.setError("Alas Segitiga belum diisi");
                }else if(tinggi.isEmpty()){
                    binding.etTinggiSegitiga.setError("Tinggi Segitiga belum diisi");
                }else{
                    alasx = Integer.parseInt(alas);
                    tinggix = Integer.parseInt(tinggi);
                    hasil = (alasx * tinggix)/2;
                    showResult(hasil);
                }
            }else if(bentuk == lingkaran){
                String lingkaran = binding.etLingkaran.getText().toString();
                int lingkaranx;
                double kuadrat,hasil;
                if(lingkaran.isEmpty()){
                    binding.etLingkaran.setError("Jari-jari belum diisi");
                }else{
                    lingkaranx = Integer.parseInt(lingkaran);
                    kuadrat = lingkaranx*lingkaranx;
                    hasil = 3.14*kuadrat;
                    showResultLingkaran(hasil);
                }
            }
        }
    }

    private void showResult(int hasil){
        binding.tvTulisanHasil.setVisibility(View.VISIBLE);
        binding.tvHasil.setText(String.valueOf(hasil));
        binding.tvHasil.setVisibility(View.VISIBLE);
    }
    private void showResultLingkaran(double hasil){
        binding.tvTulisanHasil.setVisibility(View.VISIBLE);
        binding.tvHasil.setText(String.valueOf(hasil));
        binding.tvHasil.setVisibility(View.VISIBLE);
    }
}