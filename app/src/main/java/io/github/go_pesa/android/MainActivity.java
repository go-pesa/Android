package io.github.go_pesa.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Map;

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

            Map<String,Object> response =  client.stkPush(100,testNumber,"Hello","World");

            if (response.containsKey("thisMerchantRequestID")){
                Log.e("Response","It is there");

            }else{
                Log.e("Response","NOT NOT");
            }

            Log.e("RESPONSE",response.get("CustomerMessage").toString());

        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
