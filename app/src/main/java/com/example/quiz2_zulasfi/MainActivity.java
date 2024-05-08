package com.example.quiz2_zulasfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton rbps3, rbps4, rbps5, rbpsvr, rbindomie, rbmieayam, rbsiomay;
    private EditText etwaktu;
    private Button btnpesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbps3 = findViewById(R.id.ps3);
        rbps4 = findViewById(R.id.ps4);
        rbps5 = findViewById(R.id.ps5);
        rbpsvr = findViewById(R.id.psvr);
        rbindomie = findViewById(R.id.indomie);
        rbmieayam = findViewById(R.id.mieayam);
        rbsiomay = findViewById(R.id.siomay);
        etwaktu = findViewById(R.id.waktu);
        btnpesan = findViewById(R.id.pesan); // Inisialisasi btnpesan dengan id pesan

        btnpesan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.pesan) {

            String waktu = etwaktu.getText().toString();

            String type = "";
            String tambahan = "";
            int harga = 0;

            // Penanganan jika tidak ada RadioButton yang dipilih
            if (!rbps3.isChecked() && !rbps4.isChecked() && !rbps5.isChecked() && !rbpsvr.isChecked()
                    && !rbindomie.isChecked() && !rbmieayam.isChecked() && !rbsiomay.isChecked()) {
                Toast.makeText(this, "Pilih salah satu pesanan", Toast.LENGTH_SHORT).show();
                return; // Keluar dari metode onClick
            }

            if (rbps3.isChecked()) {
                type = "PlayStation 3";
                harga = 5000;
            } else if (rbps4.isChecked()) {
                type = "PlayStation 4";
                harga = 8000;
            } else if (rbps5.isChecked()) {
                type = "PlayStation 5";
                harga = 10000;
            } else if (rbpsvr.isChecked()) {
                type = "PlayStation vr";
                harga = 20000;
            } else if (rbindomie.isChecked()) {
                tambahan = "Indomie";
                harga = 7000;
            } else if (rbmieayam.isChecked()) {
                tambahan = "Mie Ayam";
                harga = 10000;
            } else if (rbsiomay.isChecked()) {
                tambahan = "Siomay";
                harga = 5000;
            }

            int totalHarga = harga * Integer.parseInt(waktu);

            String pesanan = type + " " + tambahan;

            String pesan = "Anda memesan " + pesanan + " dengan waktu " + waktu + " dengan total harga Rp " + totalHarga;
            Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, detail.class); // Ganti "detail" menjadi "DetailActivity"

            intent.putExtra("pesanan", pesanan);
            intent.putExtra("totalHarga", totalHarga);

            startActivity(intent);
        }
    }
}
