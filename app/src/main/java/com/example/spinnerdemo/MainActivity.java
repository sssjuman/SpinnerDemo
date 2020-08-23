package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        tv_message = (TextView) findViewById(R.id.tv_message);

        Spinner spinner_food = (Spinner) findViewById(R.id.spinner_food);

        //呼叫setSelection()可以設定一開始預選項目，也可避免Spinner一開始就呼叫
        //OnItemSelectedListener.onItemSelected()
        spinner_food.setSelection(0, true);
        spinner_food.setOnItemSelectedListener(listener);


        //動態產生下拉選單的選項內容
        //Spinner只是一個空殼，呼叫ArrayAdapter建構式以建立選項的內容與樣式
        Spinner spinner_drink = (Spinner) findViewById(R.id.spinner_drink);
        String[] array_drink = {"Tea", "Milk", "Coffee"};
        ArrayAdapter<String> adapter_drink = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array_drink);

        adapter_drink.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_drink.setAdapter(adapter_drink);
        spinner_drink.setSelection(0, true);
        spinner_drink.setOnItemSelectedListener(listener);
    }

    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
        @Override
        //adapterView代表觸發事件的Spinner
        //i代表被選取項的索引
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            tv_message.setText(adapterView.getItemAtPosition(i).toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            tv_message.setText("Nothing Selected");
        }
    };

}