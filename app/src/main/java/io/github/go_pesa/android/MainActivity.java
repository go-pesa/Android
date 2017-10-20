package io.github.go_pesa.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.github.go_pesa.gopesa.Client;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void testtrans (View view){
        EditText number = (EditText)findViewById(R.id.editText3);
        EditText amount = (EditText)findViewById(R.id.editText);

        Long testAmount = Long.parseLong(amount.getText().toString().trim());
        String testNumber  = number.getText().toString().trim();

        try {
            Client client = new Client(this.getBaseContext());
            client.stkPush(100,testNumber,"Hello","World");

        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
