package com.sadataljony.app.android.demo.androidsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {//View.OnClickListener for Apply Click in Button
    private EditText mEditTextString, mEditTextInt;// EditText for Input
    private Button mBtnSave, mBtnRetrieve;// Button for Action

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();//initialized all ui components(EditText, Button)
    }

    private void initUi() {
        mEditTextString = findViewById(R.id.editTextString);
        mEditTextInt = findViewById(R.id.editTextInt);
        mBtnSave = findViewById(R.id.btnSave);
        mBtnRetrieve = findViewById(R.id.btnRetrieve);
        mBtnSave.setOnClickListener(this);// Apply on click event on button
        mBtnRetrieve.setOnClickListener(this);// Apply on click event on button
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnSave) {// Save Button for storing String and Int value to SharedPreferences
            try {
                SharedPreferences sharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("my_string", mEditTextString.getText().toString().trim());// store string value in my_string key from EditText
                editor.putInt("my_int", Integer.parseInt(mEditTextInt.getText().toString().trim()));//// store int value in my_int key from EditText
                editor.apply();// apply changes
                mEditTextString.setText("");// reset Enter String EditText
                mEditTextInt.setText("");// reset Enter Int EditText
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (v == mBtnRetrieve) {// Retrieve Button for retrieving String and Int value from SharedPreferences
            try {
                SharedPreferences sharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this);
                mEditTextString.setText(sharedPreferences.getString("my_string", ""));// get string value from my_string key and set in Enter String EditText
                mEditTextInt.setText(String.valueOf(sharedPreferences.getInt("my_int", 0)));// get int value from my_int key and set in Enter Int EditText
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
