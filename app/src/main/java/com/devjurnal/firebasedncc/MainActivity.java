package com.devjurnal.firebasedncc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Database Firebase
    private DatabaseReference dbAnggota;
    private EditText edtNama;
    private EditText edtAlamat;
    private Button btnSimpan;
    private ListView listView;
    List<AnggotaModel> listAnggota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAnggota = new ArrayList<>();

        dbAnggota = FirebaseDatabase.getInstance().getReference("Anggota");
        initView();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanData();
            }
        });

        getDataOnline();
    }

    private void getDataOnline() {
        dbAnggota.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listAnggota.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){

                    AnggotaModel anggota = postSnapshot.getValue(AnggotaModel.class);

                    listAnggota.add(anggota);
                }
                AnggotaAdapter adapter = new AnggotaAdapter(MainActivity.this,
                        listAnggota);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void simpanData() {
        String nama = edtNama.getText().toString();
        String alamat = edtAlamat.getText().toString();
        //create id unik
        String id_anggota = dbAnggota.push().getKey();

        // create model
        AnggotaModel anggotaModel = new AnggotaModel(id_anggota,nama,alamat,"");
//        anggotaModel.setNama(nama);

        dbAnggota.child(id_anggota).setValue(anggotaModel);

        Toast.makeText(this, "Sukses menyimpan", Toast.LENGTH_SHORT).show();

    }

    private void initView() {
        edtNama = findViewById(R.id.edt_nama);
        edtAlamat = findViewById(R.id.edt_alamat);
        btnSimpan = findViewById(R.id.btn_simpan);
        listView = findViewById(R.id.listView);
    }
}
