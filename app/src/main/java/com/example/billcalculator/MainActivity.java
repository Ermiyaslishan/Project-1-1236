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


    Checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (Checkbox1.isChecked()){

          editText1.setEnabled(true);
          editText9.setEnabled(true);
          editText5.setEnabled(true);
        }else {
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

        if (Checkbox2.isChecked()){
          editText2.setEnabled(true);
          editText10.setEnabled(true);
          editText6.setEnabled(true);
        }else {
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

        if (Checkbox3.isChecked()){
          editText3.setEnabled(true);
          editText11.setEnabled(true);
          editText7.setEnabled(true);
        }else {
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

        if (Checkbox4.isChecked()){
          editText4.setEnabled(true);
          editText12.setEnabled(true);
          editText8.setEnabled(true);
        }else {
          editText4.setEnabled(false);
          editText4.getEditText().getText().clear();
          editText12.setEnabled(false);
          editText12.getEditText().getText().clear();
          editText8.setEnabled(false);
          editText8.getEditText().getText().clear();
        }

      }
    });


    btnCalulate.setOnClickListener(new View.OnClickListener(){
//          @SuppressLint("SetTextI18n")

      @Override
      public void onClick(View v) {
        double lightBulbTotalConsumption = 0.0;
        double ovenTotalConsumption = 0.0;
        double boilerTotalConsumption = 0.0;
        double mitadTotalConsumption = 0.0;

        if (Checkbox1.isChecked()) {
          double power = Double.parseDouble(editText1.getEditText().getText().toString());
          double quantity = Double.parseDouble(editText9.getEditText().getText().toString());
          double usage = Double.parseDouble(editText5.getEditText().getText().toString());

          lightBulbTotalConsumption = power * quantity * usage * 30;
        }
        if (Checkbox2.isChecked()) {
          double power = Double.parseDouble(editText2.getEditText().getText().toString());
          double quantity = Double.parseDouble(editText10.getEditText().getText().toString());
          double usage = Double.parseDouble(editText6.getEditText().getText().toString());

          ovenTotalConsumption = power * quantity * usage * 30;
        }
        if (Checkbox3.isChecked()) {
          double power = Double.parseDouble(editText3.getEditText().getText().toString());
          double quantity = Double.parseDouble(editText11.getEditText().getText().toString());
          double usage = Double.parseDouble(editText7.getEditText().getText().toString());

          boilerTotalConsumption = power * quantity * usage * 30;
        }
        if (Checkbox4.isChecked()) {
          double power = Double.parseDouble(editText4.getEditText().getText().toString());
          double quantity = Double.parseDouble(editText12.getEditText().getText().toString());
          double usage = Double.parseDouble(editText8.getEditText().getText().toString());

          mitadTotalConsumption = power * quantity * usage;
        }
        double allConsumption = (mitadTotalConsumption + boilerTotalConsumption
                + lightBulbTotalConsumption + ovenTotalConsumption) / 1000;
//              double allConsumption = Math.round(allConsumption1);
        if (allConsumption == 0) {
          TotalPayableDisplay.setText("0.0");
        }else {
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
}
