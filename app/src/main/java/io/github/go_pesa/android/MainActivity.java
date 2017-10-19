package io.github.go_pesa.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.github.go_pesa.gopesa.Client;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TextView mTextView = (TextView)this.findViewById(R.id.tv1);
        mTextView.setText(Client.test());
    }
}
