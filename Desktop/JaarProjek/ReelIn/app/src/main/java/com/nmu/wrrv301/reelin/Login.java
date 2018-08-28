package com.nmu.wrrv301.reelin;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends AppCompatActivity {
    private Boolean isAdmin = false;
    private SQLConnection sqlConnection;
    private EditText txtEmail, txtPassword;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setStatusBarColor();

        sqlConnection = new SQLConnection();

        txtEmail = (EditText) findViewById(R.id.txt_email_login);
        txtPassword = (EditText) findViewById(R.id.txt_password_login);
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
    }

    public void onSigninClick(View view) {
        DoLogin doLogin = new DoLogin();
        doLogin.execute("");
    }

    public class DoLogin extends AsyncTask<String,String,String> {
        String z ="";
        Boolean isSuccess = false;

        String username = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        @Override
        protected String doInBackground(String... params) {
            if (username.trim().equals("") || password.trim().equals(""))
                z = "Please enter email and password";
            else {
                try {
                    Connection con = sqlConnection.CONN();

                    if (con == null)
                        z = "Error in connection with SQL Server";
                    else {
                        String query = "SELECT * FROM Tagger WHERE email='" + username + "' AND password='" + password + "'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);

                        if (rs.next()) {
                            z = "Login Successfull";
                            isSuccess = true;
                        } else {
                            query = "SELECT * FROM Administrator WHERE email='" + username + "' AND password='" + password + "'";
                            rs = stmt.executeQuery(query);

                            if (rs.next()) {
                                z = "Login Successfull";
                                isSuccess = true;
                                isAdmin = true;
                            } else {
                                z = "Invalid Credentials";
                                isSuccess = false;
                            }
                        }
                    }
                } catch (Exception e) {
                    isSuccess = false;
                    z = "Exceptions";
                }
            }

            return z;
        }
    }

    public void onNewAccClick(View view) {
        Intent intent = new Intent(Login.this, RegisterPageOne.class);
        startActivity(intent);
    }

    public void onForgotPassClick(View view) {
    }

    private void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
