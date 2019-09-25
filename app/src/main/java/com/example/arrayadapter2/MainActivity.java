package com.example.arrayadapter2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    // Nämä on hieman vieraita hommia
    ArrayList<String> lista = new ArrayList<>();
    ArrayList<Date> dateLista = new ArrayList<>();
    ListView listaView;

    Button nappi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                                                                        // minä yritin mutta eipä tuo onnistunut
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaView = findViewById(R.id.listaView);
        listaView.setAdapter(adapter);

        nappi = findViewById(R.id.timeBtn);
        nappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                String time = format.format(calendar.getTime());
                adapter.add(time + "   [remove]"); // insinööriratkaisu ;)
            }
        });


        // näin se vissiin poistaisi sen, tarvitsi vain toimimaan sen layoutin. Menee hieman yli tämä homma

        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {

                final int which_item = position;

                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Delete this time?")
                        .setMessage("Poistettaanko? ;)")
                        .setPositiveButton("No khyllä ;)", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                lista.remove(which_item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Ei :(",null)
                        .show();
            }
        });

    }
}
