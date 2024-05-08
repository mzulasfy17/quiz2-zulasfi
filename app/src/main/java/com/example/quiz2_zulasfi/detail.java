package com.example.quiz2_zulasfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class detail extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if(intent != null) {
            String pesanan = intent.getStringExtra("pesanan");
            int totalHarga = intent.getIntExtra("totalHarga", 0);
            String waktu = intent.getStringExtra("waktu");

            TextView type = findViewById(R.id.type);
            TextView tambahan = findViewById(R.id.tambahan);
            TextView waktuTextView = findViewById(R.id.waktu);
            TextView total = findViewById(R.id.total);

            String[] pesananArray = pesanan.split(" ");
            String typeStr = pesananArray[0];
            String tambahanStr = "";
            int tambahanHarga = 0; //
            if (pesananArray.length > 1) {
                tambahanStr = pesananArray[1];
                intent.putExtra("tambahan", waktu);

                if (tambahanStr.equals("Indomie")) {
                    tambahanHarga = 7000;
                } else if (tambahanStr.equals("Mie")) {
                    tambahanHarga = 10000;
                } else if (tambahanStr.equals("Siomay")) {
                    tambahanHarga = 5000;
                }
            }

            totalHarga += tambahanHarga;

            type.setText("Type: " + typeStr);
            tambahan.setText("Tambahan: " + tambahanStr);
            waktuTextView.setText("Waktu: " + waktu);
            total.setText("Total Harga: Rp " + df.format(totalHarga));
        }
    }
}
