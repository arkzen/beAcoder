package org.ganymede.BeAcoder;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  {

    Button  btnreg,btnlogin,btnguest;
    TextView tmode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //register button on click
        btnreg = (Button) findViewById(R.id.regbutton);
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openreg();
            }
        });

        //login button
        btnlogin = (Button) findViewById(R.id.signinbutton);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });

        //guest button
        btnguest = (Button) findViewById(R.id.guestbutton);
        btnguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openguest();
            }
        });

        //teacher write mode
        tmode=findViewById(R.id.writemode);
        tmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeacherMode();
            }
        });

    }

    public void openreg(){
        Intent intent=new Intent(MainActivity.this,register.class);
        startActivity(intent);
    }

    public void openlogin(){
        Intent intent=new Intent(MainActivity.this,login.class);
        startActivity(intent);

    }

    public void openguest() {
        Intent intent = new Intent(MainActivity.this, courses.class);
        startActivity(intent);

    }

    public void TeacherMode(){
        Intent intent=new Intent(MainActivity.this,After_login.class);
        startActivity(intent);
    }
}