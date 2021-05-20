package com.mobileproject.finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileproject.finalproject.databinding.FragmentVolumeBinding;


public class Volume extends Fragment implements View.OnClickListener {

    private FragmentVolumeBinding binding;
    private int balok = 0, piramida = 1, tabung = 2,bentuk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVolumeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnBalok.setOnClickListener(this);
        binding.btnPiramida.setOnClickListener(this);
        binding.btnTabung.setOnClickListener(this);
        binding.btnHitung.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == binding.btnBalok.getId()){
            binding.bentuk.setText("BALOK");
            binding.bentuk.setVisibility(View.VISIBLE);
            binding.tvPanjangBalok.setVisibility(View.VISIBLE);
            binding.tvLebarBalok.setVisibility(View.VISIBLE);
            binding.tvTinggiBalok.setVisibility(View.VISIBLE);
            binding.etPanjangBalok.setVisibility(View.VISIBLE);
            binding.etTinggiBalok.setVisibility(View.VISIBLE);
            binding.etLebarBalok.setVisibility(View.VISIBLE);
            binding.tvPanjangPiramida.setVisibility(View.GONE);
            binding.tvLebarPiramida.setVisibility(View.GONE);
            binding.tvTinggiPiramida.setVisibility(View.GONE);
            binding.etPanjangPiramida.setVisibility(View.GONE);
            binding.etLebarPiramida.setVisibility(View.GONE);
            binding.etTinggiPiramida.setVisibility(View.GONE);
            binding.tvJaritabung.setVisibility(View.GONE);
            binding.tvTinggitabung.setVisibility(View.GONE);
            binding.etJaritabung.setVisibility(View.GONE);
            binding.etTinggitabung.setVisibility(View.GONE);
            bentuk = 0;
            binding.btnHitung.setVisibility(View.VISIBLE);
        }else if(v.getId() == binding.btnPiramida.getId()){
            binding.bentuk.setText("PIRAMIDA");
            binding.bentuk.setVisibility(View.VISIBLE);
            binding.tvPanjangBalok.setVisibility(View.GONE);
            binding.tvLebarBalok.setVisibility(View.GONE);
            binding.tvTinggiBalok.setVisibility(View.GONE);
            binding.etPanjangBalok.setVisibility(View.GONE);
            binding.etTinggiBalok.setVisibility(View.GONE);
            binding.etLebarBalok.setVisibility(View.GONE);
            binding.tvPanjangPiramida.setVisibility(View.VISIBLE);
            binding.tvLebarPiramida.setVisibility(View.VISIBLE);
            binding.tvTinggiPiramida.setVisibility(View.VISIBLE);
            binding.etPanjangPiramida.setVisibility(View.VISIBLE);
            binding.etLebarPiramida.setVisibility(View.VISIBLE);
            binding.etTinggiPiramida.setVisibility(View.VISIBLE);
            binding.tvJaritabung.setVisibility(View.GONE);
            binding.tvTinggitabung.setVisibility(View.GONE);
            binding.etJaritabung.setVisibility(View.GONE);
            binding.etTinggitabung.setVisibility(View.GONE);
            bentuk = 1;
            binding.btnHitung.setVisibility(View.VISIBLE);
        }else if(v.getId() == binding.btnTabung.getId()){
            binding.bentuk.setText("TABUNG");
            binding.bentuk.setVisibility(View.VISIBLE);
            binding.tvPanjangBalok.setVisibility(View.GONE);
            binding.tvLebarBalok.setVisibility(View.GONE);
            binding.tvTinggiBalok.setVisibility(View.GONE);
            binding.etPanjangBalok.setVisibility(View.GONE);
            binding.etTinggiBalok.setVisibility(View.GONE);
            binding.etLebarBalok.setVisibility(View.GONE);
            binding.tvPanjangPiramida.setVisibility(View.GONE);
            binding.tvLebarPiramida.setVisibility(View.GONE);
            binding.tvTinggiPiramida.setVisibility(View.GONE);
            binding.etPanjangPiramida.setVisibility(View.GONE);
            binding.etLebarPiramida.setVisibility(View.GONE);
            binding.etTinggiPiramida.setVisibility(View.GONE);
            binding.tvJaritabung.setVisibility(View.VISIBLE);
            binding.tvTinggitabung.setVisibility(View.VISIBLE);
            binding.etJaritabung.setVisibility(View.VISIBLE);
            binding.etTinggitabung.setVisibility(View.VISIBLE);
            bentuk = 2;
            binding.btnHitung.setVisibility(View.VISIBLE);
        }else if(v.getId() == binding.btnHitung.getId()){
            if(bentuk == balok){
                String panjang = binding.etPanjangBalok.getText().toString();
                String lebar = binding.etLebarBalok.getText().toString();
                String tinggi = binding.etTinggiBalok.getText().toString();

                if(panjang.isEmpty()){
                    binding.etPanjangBalok.setError("Panjang alas belum diisi");
                }else if(lebar.isEmpty()){
                    binding.etLebarBalok.setError("Lebar alas belum diisi");
                }else if(tinggi.isEmpty()){
                    binding.etTinggiBalok.setError("Tinggi Balok belum diisi");
                }else{
                    int panjangx = Integer.parseInt(panjang);
                    int lebarx = Integer.parseInt(lebar);
                    int tinggix = Integer.parseInt(tinggi);
                    int hasil;
                    hasil = panjangx*lebarx*tinggix;
                    showResult(hasil);
                }
            }else if(bentuk == piramida){
                String panjang = binding.etPanjangPiramida.getText().toString();
                String lebar = binding.etLebarPiramida.getText().toString();
                String tinggi = binding.etTinggiPiramida.getText().toString();

                if(panjang.isEmpty()){
                    binding.etPanjangPiramida.setError("Panjang alas belum diisi");
                }else if(lebar.isEmpty()){
                    binding.etLebarPiramida.setError("Lebar alas belum diisi");
                }else if(tinggi.isEmpty()){
                    binding.etTinggiPiramida.setError("Tinggi piramida belum diisi");
                }else{
                    int panjangx = Integer.parseInt(panjang);
                    int lebarx = Integer.parseInt(lebar);
                    int tinggix = Integer.parseInt(tinggi);
                    int hasil;
                    hasil = (panjangx*lebarx*tinggix)/3;
                    showResult(hasil);
                }
            }else if(bentuk == tabung){
                String jari = binding.etJaritabung.getText().toString();
                String tinggi = binding.etTinggitabung.getText().toString();

                if(jari.isEmpty()){
                    binding.etJaritabung.setError("Jari-jari belum diisi");
                }else if(tinggi.isEmpty()){
                    binding.etTinggitabung.setError("Tinggi tabung belum diisi");
                }else{
                    int jarix = Integer.parseInt(jari);
                    int tinggix = Integer.parseInt(tinggi);
                    double kuadrat, hasil;
                    kuadrat = jarix*jarix;
                    hasil = 3.14*kuadrat*tinggix;
                    showResultTabung(hasil);
                }
            }
        }
    }

    private void showResult(int hasil){
        binding.tvTulisanHasil.setVisibility(View.VISIBLE);
        binding.tvHasil.setText(String.valueOf(hasil));
        binding.tvHasil.setVisibility(View.VISIBLE);
    }
    private void showResultTabung(double hasil){
        binding.tvTulisanHasil.setVisibility(View.VISIBLE);
        binding.tvHasil.setText(String.valueOf(hasil));
        binding.tvHasil.setVisibility(View.VISIBLE);
    }
}