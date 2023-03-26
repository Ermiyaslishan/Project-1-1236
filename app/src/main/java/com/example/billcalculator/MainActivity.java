package com.example.billcalculator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private TextView TotalConsumptionDisplay;
    private TextView TotalPayableDisplay;

    private boolean calculationsPerformed = false;


  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //we import all element from XML file by using Id
      //for Checkbox
      CheckBox Checkbox1 = findViewById(R.id.checkBox);
      CheckBox Checkbox2 = findViewById(R.id.checkBox4);
      CheckBox Checkbox3 = findViewById(R.id.checkBox5);
      CheckBox Checkbox4 = findViewById(R.id.checkBox6);

      //for Bulb
      TextInputLayout editText1 = findViewById(R.id.editTextNumber5);
      TextInputLayout editText9 = findViewById(R.id.editTextNumber6);
      TextInputLayout editText5 = findViewById(R.id.editTextNumber8);

      //for
      TextInputLayout editText2 = findViewById(R.id.editTextNumber4);
      TextInputLayout editText10 = findViewById(R.id.editTextNumber7);
      TextInputLayout editText6 = findViewById(R.id.editTextNumber9);

      TextInputLayout editText3 = findViewById(R.id.editTextNumber10);
      TextInputLayout editText11 = findViewById(R.id.editTextNumber11);
      TextInputLayout editText7 = findViewById(R.id.editTextNumber12);

      TextInputLayout editText4 = findViewById(R.id.editTextNumber13);
      TextInputLayout editText12 = findViewById(R.id.editTextNumber14);
      TextInputLayout editText8 = findViewById(R.id.editTextNumber15);




      TotalConsumptionDisplay = findViewById(R.id.textView9);

      TotalPayableDisplay = findViewById(R.id.textView11);

      Button btnCalulate = findViewById(R.id.button2);
      Button btnReset = findViewById(R.id.button3);


    }
}
