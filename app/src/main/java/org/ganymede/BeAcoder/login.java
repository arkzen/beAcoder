package org.ganymede.BeAcoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText emailTextView, passwordTextView;
    private TextView mTextView;
    private Button Btn;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;
    CheckBox remember;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       emailTextView = findViewById(R.id.username);
        passwordTextView = findViewById(R.id.password);
        mTextView= findViewById(R.id.reg);
       Btn = findViewById(R.id.login);
        remember = findViewById(R.id.reme);
        progressbar=findViewById(R.id.progressbar1);

        mAuth = FirebaseAuth.getInstance();

        SharedPreferences logs = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = logs.getString("remember","");
        if (checkbox.equals("true")){
            Intent intent = new Intent(login.this,After_login.class);
            startActivity(intent);
            finish();
        }
        else if (checkbox.equals("false")){
            Toast.makeText(this, "Please Sign In", Toast.LENGTH_SHORT).show();
        }

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,register.class));
            }
        });

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();

            }
        });

        //remember me
        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    SharedPreferences logs = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = logs.edit();
                    editor.putString("remember","true");
                    editor.apply();

                }
                else if (!buttonView.isChecked()){
                    SharedPreferences logs = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = logs.edit();
                    editor.putString("remember","false");
                    editor.apply();

                }
            }
        });
    }

    private void loginUser() {
        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        String email = emailTextView.getText().toString();
        String pass = passwordTextView.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(email,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                if (mAuth.getCurrentUser().isEmailVerified()){
                                    Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(login.this,After_login.class));
                                    // hide the progress bar
                                    progressbar.setVisibility(View.GONE);
                                    finish();
                                }
                                else{
                                    Toast.makeText(login.this, "Please verify your email ID", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
            else{
                passwordTextView.setError("Empty fields are not allowed");
            }
        }
        else if (email.isEmpty()){
            emailTextView.setError("Empty fields are not allowed");
        }
        else{
            emailTextView.setError("Enter a valid email address");
        }
    }

}