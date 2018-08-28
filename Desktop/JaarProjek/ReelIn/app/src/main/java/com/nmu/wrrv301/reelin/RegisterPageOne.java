package com.nmu.wrrv301.reelin;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class RegisterPageOne extends AppCompatActivity {


    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private static final String TAG1 = "RegisterPageOne";

    // Defining TextViews
    // =============================================================================================
    private TextView fName;
    private TextView lName;
    private TextView address1;
    private TextView suburb;
    private TextView town;
    private TextView pCode;
    private TextView phoneNum;
    private TextView mDisplayDate;
    // =============================================================================================


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
    // Finding ID's
    // =============================================================================================
        fName = (TextView) findViewById(R.id.fNameText);
        lName = (TextView) findViewById(R.id.lNameText);
        address1 = (TextView) findViewById(R.id.address1Text);
        suburb = (TextView) findViewById(R.id.suburbText);
        town = (TextView) findViewById(R.id.townText);
        pCode = (TextView) findViewById(R.id.postalText);
        phoneNum = (TextView) findViewById(R.id.phoneText);
        mDisplayDate = (TextView) findViewById(R.id.displayDate);
    // =============================================================================================

    // Code for Calendar
    // =============================================================================================

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        RegisterPageOne.this,
                       android.R.style.Theme_Holo_Dialog_MinWidth ,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = day + "/" + (month + 1) + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    // =============================================================================================


    // Setting Error messages
    // =============================================================================================
        Button moveRegister2 = (Button) findViewById(R.id.sNextButton);
        moveRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (fName.getText().length() == 0)
                    fName.setError("Required Field");
               if (lName.getText().length() == 0)
                    lName.setError("Required Field");
               if (address1.getText().length() == 0)
                    address1.setError("Required Field");
               if (town.getText().length() == 0)
                    town.setError("Required Field");
               if (pCode.getText().length() == 0)
                    pCode.setError("Required Field");
               if (phoneNum.getText().length() == 0 || phoneNum.getText().length() > 10);
                    phoneNum.setError("Invalid");
               if (mDisplayDate.getText().length() == 0)
                    mDisplayDate.setError("Required Field");
               else if (fName.getText().length() != 0 && lName.getText().length() != 0 && address1.getText().length() != 0
                        && town.getText().length() != 0 && pCode.getText().length() != 0 && phoneNum.getText().length() != 0 && mDisplayDate.getText().length() != 0  ){
                   //Move to register 2
                   Intent intent = new Intent(RegisterPageOne.this, RegisterPageTwo.class);
                   startActivity(intent);
               }
            }
        });
    // =============================================================================================
    }
}





