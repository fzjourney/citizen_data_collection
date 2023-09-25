package com.example.pendataanwarga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        errorTextView = findViewById(R.id.errorTextView);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                //Login Admin dan User
                if (username.equals("Feiza") && password.equals("123")) {
                    Intent intent = new Intent(LoginActivity.this, IdentitasActivity.class);
                    startActivity(intent);
                } else if (username.equals("user") && password.equals("user")) {
                    Intent intent = new Intent(LoginActivity.this, IdentitasActivity.class);
                    startActivity(intent);
                } else {
                    // Pesan login gagal
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setText("Username atau password salah");
                }
            }
        });
    }
}
