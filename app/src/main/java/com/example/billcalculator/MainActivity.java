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
import android.widget.Toast;

import androidx.annotation.NonNull;
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
      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

//for total consumption display
      TotalConsumptionDisplay = findViewById(R.id.textView9);
//for total payable Display
      TotalPayableDisplay = findViewById(R.id.textView11);
//for calculate button
      Button btnCalulate = findViewById(R.id.button2);
//for Reset Button
      Button btnReset = findViewById(R.id.button3);

//      public boolean validate(@NonNull TextInputLayout... editText) {
//          boolean isValid = true;
//
//          for (TextInputLayout inputLayout : editText) {
//              EditText editText = inputLayout.getEditText();
//              if (editText != null && editText.getText().toString().isEmpty()) {
//                  isValid = false;
//              }
//          }
//          return isValid;
//      }

      Checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

              if (Checkbox1.isChecked()) {

                  editText1.setEnabled(true);
                  editText9.setEnabled(true);
                  editText5.setEnabled(true);
              } else {
                  editText1.setEnabled(false);
                  editText1.getEditText().getText().clear();
                  editText9.setEnabled(false);
                  editText9.getEditText().getText().clear();
                  editText5.setEnabled(false);
                  editText5.getEditText().getText().clear();
              }

          }
      });

      Checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

              if (Checkbox2.isChecked()) {
                  editText2.setEnabled(true);
                  editText10.setEnabled(true);
                  editText6.setEnabled(true);
              } else {
                  editText2.setEnabled(false);
                  editText2.getEditText().getText().clear();
                  editText10.setEnabled(false);
                  editText10.getEditText().getText().clear();
                  editText6.setEnabled(false);
                  editText6.getEditText().getText().clear();
              }

          }
      });

      Checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

              if (Checkbox3.isChecked()) {
                  editText3.setEnabled(true);
                  editText11.setEnabled(true);
                  editText7.setEnabled(true);
              } else {
                  editText3.setEnabled(false);
                  editText3.getEditText().getText().clear();
                  editText11.setEnabled(false);
                  editText11.getEditText().getText().clear();
                  editText7.setEnabled(false);
                  editText7.getEditText().getText().clear();
              }

          }
      });

      Checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

              if (Checkbox4.isChecked()) {
                  editText4.setEnabled(true);
                  editText12.setEnabled(true);
                  editText8.setEnabled(true);
              } else {
                  editText4.setEnabled(false);
                  editText4.getEditText().getText().clear();
                  editText12.setEnabled(false);
                  editText12.getEditText().getText().clear();
                  editText8.setEnabled(false);
                  editText8.getEditText().getText().clear();
              }

          }
      });


      btnCalulate.setOnClickListener(new View.OnClickListener() {
//          @SuppressLint("SetTextI18n")

          @Override
          public void onClick(View v) {
              double lightBulbTotalConsumption = 0.0;
              double ovenTotalConsumption = 0.0;
              double boilerTotalConsumption = 0.0;
              double mitadTotalConsumption = 0.0;
              //This If statement check's Bulb and the text fields for validation
              if (Checkbox1.isChecked()) {
                  if (isInputValid(editText1, editText9, editText5)) {
                      double power = Double.parseDouble(editText1.getEditText().getText().toString());
                      double quantity = Double.parseDouble(editText9.getEditText().getText().toString());
                      double usage = Double.parseDouble(editText5.getEditText().getText().toString());

                      lightBulbTotalConsumption = power * quantity * usage * 30;
                  } else {
                      Toast.makeText(getApplicationContext(), "Please Fill The Required Value", Toast.LENGTH_SHORT).show();
                  }
              }


              //This If statement check's Stove and the text fields for validation
                  if (Checkbox2.isChecked()) {
                      if (isInputValid(editText2, editText10, editText6)){
                          double power = Double.parseDouble(editText2.getEditText().getText().toString());
                          double quantity = Double.parseDouble(editText10.getEditText().getText().toString());
                          double usage = Double.parseDouble(editText6.getEditText().getText().toString());

                          ovenTotalConsumption = power * quantity * usage * 30;
                      }
                      else {
                      Toast.makeText(getApplicationContext(), "Please Fill The Required Value", Toast.LENGTH_SHORT).show();
                  }}

           //This If statement check's Boiler and the text fields for validation
                  if (Checkbox3.isChecked()) {
                      if (isInputValid(editText3, editText11, editText7)){
                      double power = Double.parseDouble(editText3.getEditText().getText().toString());
                      double quantity = Double.parseDouble(editText11.getEditText().getText().toString());
                      double usage = Double.parseDouble(editText7.getEditText().getText().toString());

                      boilerTotalConsumption = power * quantity * usage * 30;
                  } else {
                      Toast.makeText(getApplicationContext(), "Please Fill The Required Value", Toast.LENGTH_SHORT).show();
                  }}

              //This If statement check's Grill and the text fields for validation
                  if (Checkbox4.isChecked()) {
                      if (isInputValid(editText4, editText8, editText12)){
                      double power = Double.parseDouble(editText4.getEditText().getText().toString());
                      double quantity = Double.parseDouble(editText12.getEditText().getText().toString());
                      double usage = Double.parseDouble(editText8.getEditText().getText().toString());

                      mitadTotalConsumption = power * quantity * usage;
                  } else {
                      Toast.makeText(getApplicationContext(), "Please Fill The Required Value", Toast.LENGTH_SHORT).show();
                  }}
                  double allConsumption = (mitadTotalConsumption + boilerTotalConsumption
                          + lightBulbTotalConsumption + ovenTotalConsumption) / 1000;
//              double allConsumption = Math.round(allConsumption1);
                  if (allConsumption == 0) {
                      TotalPayableDisplay.setText("0.0");
                  } else {
                      TotalConsumptionDisplay.setText(String.format("%sKwh", Double.toString(allConsumption)));
                  }
                  if (allConsumption == 0) {
                      TotalPayableDisplay.setText("0.0");
                  } else {
                      double payable = 0.0;
                      if (allConsumption <= 50) {
                          payable = Math.round((allConsumption * 0.2730)) + 10.00;

                      } else if (allConsumption > 50 && allConsumption <= 100) {
                          payable = Math.round((allConsumption * 0.7670)) + 42.00;
                      } else if (allConsumption > 100 && allConsumption <= 200) {
                          payable = Math.round((allConsumption * 1.6250)) + 42.00;
                      } else if (allConsumption > 200 && allConsumption <= 300) {
                          payable = Math.round((allConsumption * 2.0000)) + 42.00;
                      } else if (allConsumption > 300 && allConsumption <= 400) {
                          payable = Math.round((allConsumption * 2.2000)) + 42.00;
                      } else if (allConsumption > 400 && allConsumption <= 500) {
                          payable = Math.round((allConsumption * 2.4050)) + 42.00;
                      } else if (allConsumption > 500) {
                          payable = Math.round((allConsumption * 2.4810)) + 42.00;
                      }


                      // Display the result
                      TotalPayableDisplay.setText(Double.toString(payable) + " Birr");
//              TotalPayableDisplay.setText(Double.toString(payable)+ "Birr");

                  }
              }

      });



      //for reset BUTTON
      btnReset.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Checkbox1.setChecked(false);
              Checkbox2.setChecked(false);
              Checkbox3.setChecked(false);
              Checkbox4.setChecked(false);

              TotalConsumptionDisplay.setText("0.0");
              TotalPayableDisplay.setText("0.0");


              editText1.setEnabled(false);
              editText1.getEditText().setEnabled(false);
              editText9.setEnabled(false);
              editText9.getEditText().setEnabled(false);
              editText5.setEnabled(false);
              editText5.getEditText().setEnabled(false);

              editText2.setEnabled(false);
              editText2.getEditText().setEnabled(false);
              editText10.setEnabled(false);
              editText10.getEditText().setEnabled(false);
              editText6.setEnabled(false);
              editText6.getEditText().setEnabled(false);

              editText3.setEnabled(false);
              editText3.getEditText().setEnabled(false);
              editText11.setEnabled(false);
              editText11.getEditText().setEnabled(false);
              editText7.setEnabled(false);
              editText7.getEditText().setEnabled(false);

              editText4.setEnabled(false);
              editText4.getEditText().setEnabled(false);
              editText12.setEnabled(false);
              editText12.getEditText().setEnabled(false);
              editText8.setEnabled(false);
              editText8.getEditText().setEnabled(false);
          }
      });


  }
  // In this method we use to validate all text input layout
    private boolean isInputValid(TextInputLayout watt, TextInputLayout qty, TextInputLayout usage) {
        return (!watt.getEditText().getText().toString().trim().isEmpty()) && (!qty.getEditText().getText().toString().trim().isEmpty()) && (!usage.getEditText().getText().toString().trim().isEmpty());
    }
    }

