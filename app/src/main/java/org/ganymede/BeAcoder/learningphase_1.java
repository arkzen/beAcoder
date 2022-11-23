package org.ganymede.BeAcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class learningphase_1 extends AppCompatActivity {

    Button javaeditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learningphase1);

        javaeditor = (Button) findViewById(R.id.java_editor);
        javaeditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJavaEditor();
            }
        });
    }
    public void openJavaEditor(){
        Intent intent=new Intent(learningphase_1.this,JavaEditor.class);
        startActivity(intent);
    }
}