package com.fyp.sehatyaab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText idEdtUserName; //to get email address
    ProgressBar progressBar;    //show progress bar
    Button buttonForgotPassword;    //button for click
    FirebaseAuth firebaseAuth;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        bindView();

        firebaseAuth = FirebaseAuth.getInstance();

        buttonForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = idEdtUserName.getText().toString();

                /*  check if email address is blank
                 * */
                if (TextUtils.isEmpty(email)) {
                    idEdtUserName.setError("Enter Your Email Address");       //if blank display error
                }

                progressBar.setVisibility(View.VISIBLE);   //set visibility

                /*
                 *       send request for reset password
                 * */
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPassword.this, "Password reset email has been sent!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ForgotPassword.this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                        }
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        });


    /*      UDF
     * */




        Button btntherapies = findViewById(R.id.idBtnCancel);
        btntherapies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
    }

    private void bindView() {
        idEdtUserName = (EditText) findViewById(R.id.idEdtUserName);
        progressBar = (ProgressBar) findViewById(R.id.idPBLoading);
        buttonForgotPassword = (Button) findViewById(R.id.idBtnSearch);
    }

    public void openLoginActivity() {
        Intent cancel = new Intent(this, LoginActivity.class);
        startActivity(cancel);
    }
}