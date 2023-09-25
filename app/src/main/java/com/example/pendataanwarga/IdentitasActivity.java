package com.example.pendataanwarga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IdentitasActivity extends AppCompatActivity {

    EditText namaEditText, alamatEditText, kotaEditText, usiaEditText, gajiEditText, pekerjaanEditText;
    RadioGroup statusRadioGroup;
    RadioButton menikahRadioButton, belumMenikahRadioButton;
    Button tampilanButton, hapusDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_identitas);
        namaEditText = findViewById(R.id.et_nama);
        alamatEditText = findViewById(R.id.et_alamat);
        kotaEditText = findViewById(R.id.et_kota);
        usiaEditText = findViewById(R.id.et_usia);
        pekerjaanEditText = findViewById(R.id.et_pekerjaan);
        gajiEditText = findViewById(R.id.et_gaji);
        statusRadioGroup = findViewById(R.id.radio_group_status);
        menikahRadioButton = findViewById(R.id.radio_menikah);
        belumMenikahRadioButton = findViewById(R.id.radio_belum_menikah);
        tampilanButton = findViewById(R.id.btn_tampilan);
        hapusDataButton = findViewById(R.id.btn_hapus);

        tampilanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = namaEditText.getText().toString();
                String address = alamatEditText.getText().toString();
                String city = kotaEditText.getText().toString();
                String ageStr = usiaEditText.getText().toString();
                String occupation = pekerjaanEditText.getText().toString();
                String salary = gajiEditText.getText().toString();
                String status = menikahRadioButton.isChecked() ? "Menikah" : "Belum Menikah";

                // Validasi input, jika ada field yang kosong maka tampilkan pesan peringatan
                if(name.isEmpty() || address.isEmpty() || city.isEmpty() || ageStr.isEmpty() || occupation.isEmpty() || salary.isEmpty() || status.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Harap lengkapi semua field", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age = Integer.parseInt(ageStr);

                Intent intent = new Intent(IdentitasActivity.this, TampilanActivity.class);
                intent.putExtra("Name", name);
                intent.putExtra("Address", address);
                intent.putExtra("City", city);
                intent.putExtra("Age", age);
                intent.putExtra("Job", occupation);
                intent.putExtra("Salary", salary);
                intent.putExtra("Status", status);

                startActivity(intent);
            }
        });

        hapusDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaEditText.setText("");
                alamatEditText.setText("");
                kotaEditText.setText("");
                usiaEditText.setText("");
                pekerjaanEditText.setText("");
                gajiEditText.setText("");
                statusRadioGroup.clearCheck();
            }
        });
    }
}