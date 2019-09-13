 package com.example.oneslo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                start();
            }
        });
    }
    public void start(){
        Intent home = new Intent(MainActivity.this, DrawerNav.class);
        startActivity(home);
    }
}