package com.devjurnal.firebasedncc;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DevJurnal on 2/6/18.
 */

public class AnggotaAdapter extends ArrayAdapter<AnggotaModel>{

    private Activity context;
    List<AnggotaModel> listAnggota;
    public AnggotaAdapter(Activity context,
                          List<AnggotaModel> listAnggota){
        super(context, R.layout.list_anggota, listAnggota);
        this.context = context;
        this.listAnggota = listAnggota;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View listViewItem =  inflater.inflate(R.layout.list_anggota,
                null,true);

        TextView namaAnggota = listViewItem.findViewById(R.id.list_nama_anggota);
        TextView alamatAnggota = listViewItem.findViewById(R.id.list_alamat_anggota);

        AnggotaModel anggota = listAnggota.get(position);

        namaAnggota.setText(anggota.getNama());
        alamatAnggota.setText(anggota.getAlamat());

        return listViewItem;
    }
}
