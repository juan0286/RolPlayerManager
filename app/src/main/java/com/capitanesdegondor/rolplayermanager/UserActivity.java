package com.capitanesdegondor.rolplayermanager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        TextView  nombre = (TextView) findViewById(R.id.user_name);
        TextView  mail = (TextView) findViewById(R.id.user_mail);
        ImageView  imageView = (ImageView) findViewById(R.id.imageView);

        Bundle dato = getIntent().getExtras();
        nombre.setText(dato.getString("name"));
        mail.setText(dato.getString("email"));

//        URL url = null;
        String uri = dato.getString("uri");
//        try {
//            url = new URL(uri);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        Bitmap bmp = null;
//        try {
//            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Picasso.with(this).load(uri).into(imageView);

       //imageView.setImageBitmap(bmp);

        Button btnSignOut = (Button) findViewById(R.id.btnSignOut);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverYdesloguear();
            }
        });

        Button btnRevoke = (Button) findViewById(R.id.btnRevoke);
        btnRevoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverYrevocar();
            }
        });
    }

    private void volverYdesloguear(){
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("logout", true);
        startActivity(i);
    }

    private void volverYrevocar(){
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("revoke", true);
        startActivity(i);
    }


}
