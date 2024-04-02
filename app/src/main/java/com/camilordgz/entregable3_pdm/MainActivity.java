package com.camilordgz.entregable3_pdm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IRecyclerInterface{

    List<ElementList> elements;

    String[] names = {
            "Camilo Rodriguez Gomez",
            "Jorge Alonso Rodriguez Lopera",
            "Luz Karime Gomez Camargo",
            "Sebastian Rodriguez Gomez",
            "Natalia Rodriguez Gomez"
    };

    String[] titles = {
            "Entrega 3 Dispositivos Moviles",
            "Curso Volleyball UdeA",
            "Receta de Pie de Limon",
            "Planos Casa Cancún",
            "Portafolio de Dibujante"
    };

    String[] subjects = {
            "El proyecto ha sido enviado",
            "El curso ha sido pagado",
            "Miren esta receta familia",
            "Estos son los planos",
            "Mira mis dibujos"
    };

    String[] bodies = {
            "Buenas tardes profesor, hago envío de la Entrega #3 de Programación de Dispositivos Moviles",
            "Hola Natalia, ya pagué el curso de volleyball al que te querías inscribir",
            "Hola familia, ví esta receta en YouTube, ¿que les parece?",
            "Buen dia Ingeniero, le envío los planos de la casa para que podamos empezar la obra",
            "Hola chicos, miren el link de mi portafolio de dibujos www.portafolionatalia.com"
    };

    String[] times = {
            "3:50 PM",
            "7:42 PM",
            "11:28 AM",
            "6:00 AM",
            "1:32 PM"
    };

    Integer[] avatarPictures = {
            R.drawable.pfp1,
            R.drawable.pfp2,
            R.drawable.pfp3,
            R.drawable.pfp4,
            R.drawable.pfp5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startMail();
    }

    public void startMail() {
        elements = new ArrayList<>();
        elements.add(new ElementList(names[0], titles[0], subjects[0], bodies[0], times[0], avatarPictures[0], false));
        elements.add(new ElementList(names[1], titles[1], subjects[1], bodies[1], times[1], avatarPictures[1], false));
        elements.add(new ElementList(names[2], titles[2], subjects[2], bodies[2], times[2], avatarPictures[2], false));
        elements.add(new ElementList(names[3], titles[3], subjects[3], bodies[3], times[3], avatarPictures[3], false));
        elements.add(new ElementList(names[4], titles[4], subjects[4], bodies[4], times[4], avatarPictures[4], false));

        ListAdapter listAdapter = new ListAdapter(elements, this, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void OnMailClick(int position) {
        elements.get(position).setSeenStatus(true);
        Intent intent = new Intent(MainActivity.this, MailScreen.class);
        intent.putExtra("Name", elements.get(position).getFullName());
        intent.putExtra("Title", elements.get(position).getTitle());
        intent.putExtra("Time", elements.get(position).getTime());
        intent.putExtra("AvatarPicture", elements.get(position).getAvatarPicture());
        intent.putExtra("Body", elements.get(position).getBody());

        startActivity(intent);
    }
}