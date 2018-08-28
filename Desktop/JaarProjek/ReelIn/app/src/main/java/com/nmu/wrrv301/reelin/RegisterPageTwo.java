package com.nmu.wrrv301.reelin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterPageTwo extends AppCompatActivity {

    // Defining TextViews
    // =============================================================================================
    private Spinner orgName;
    private TextView memNum;
    private TextView email;
    private TextView password;
    private TextView reTypePass;
    // =============================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        // Finding ID's
        // =============================================================================================
        orgName = (Spinner) findViewById(R.id.orgName);
        memNum = (TextView) findViewById(R.id.memberNum);
        email = (TextView) findViewById(R.id.emailR);
        password = (TextView) findViewById(R.id.passwordSign);
        reTypePass = (TextView) findViewById(R.id.rePass);
        // =============================================================================================

        Button signUp = (Button) findViewById(R.id.lastSignup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (memNum.getText().length() == 0)
                    memNum.setError("Required Field");
                if (email.getText().length() == 0)
                    email.setError("Required Field");
                if (password.getText().length() == 0)
                    password.setError("Required Field");
                if (reTypePass.getText().length() == 0)
                    reTypePass.setError("Required Field");
                if (reTypePass.getText() != password.getText())
                    reTypePass.setError("Check Password");
                else if (memNum.getText().length() != 0 && email.getText().length() != 0 && password.getText().length() != 0
                        && reTypePass.getText().length() != 0 && reTypePass.getText() == password.getText()) {
                    //Move to home activity
                    Intent intent = new Intent(RegisterPageTwo.this, MainMenu.class);
                    startActivity(intent);
                }
            }
        });
    }
}
