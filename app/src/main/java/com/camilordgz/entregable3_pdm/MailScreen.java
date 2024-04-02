package com.camilordgz.entregable3_pdm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class MailScreen extends AppCompatActivity {

    TextView nametv, titletv, bodytv, timetv;
    CircleImageView avatarPicturecv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.mail_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name = getIntent().getStringExtra("Name");
        String title = getIntent().getStringExtra("Title");
        String body = getIntent().getStringExtra("Body");
        String time = getIntent().getStringExtra("Time");
        Integer avatarPicture = getIntent().getIntExtra("AvatarPicture", 0);

        nametv = findViewById(R.id.nametv);
        titletv= findViewById(R.id.titletv);
        bodytv = findViewById(R.id.bodytv);
        timetv = findViewById(R.id.timetv);
        avatarPicturecv = findViewById(R.id.avatarPicturecv);


        nametv.setText(name);
        titletv.setText(title);
        bodytv.setText(body);
        timetv.setText(time);
        avatarPicturecv.setImageResource(avatarPicture);
    }
}