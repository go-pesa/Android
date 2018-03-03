package io.github.go_pesa.gopesa;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.util.Map;

import mgopesa.StkResponse;

/**
 * Created by clive on 19/10/17.
 */

public class Client {

    private mgopesa.Client client;
    private Context context;
    private String key;
    private String secret;
    private String passkey;
    private Long shortCode;
    private String msisdn;
    private String productionURL;
    private String transactionCallback;


    private void getContextValues(){
        this.key  = this.context.getString(R.string.consumer_key);
        this.secret = this.context.getString(R.string.consumer_secret);
        this.passkey = this.context.getString(R.string.pass_key);
        this.msisdn = this.context.getString(R.string.msisdn);
        this.productionURL = this.context.getString(R.string.production_url);
        this.transactionCallback = this.context.getString(R.string.transaction_callback);
        if (!TextUtils.isEmpty(this.context.getString(R.string.short_code)))
        this.shortCode = Long.parseLong(this.context.getString(R.string.short_code));
    }

    public Client(Context context)  throws Exception {
        this.context = context;
        getContextValues();
        this.client =  new mgopesa.Client();



        if(TextUtils.isEmpty(this.key) || TextUtils.isEmpty(this.secret) )
        {
            throw new Exception("Must fill both consumer secret and key in mpesa.xml");

        }else{

            if(!TextUtils.isEmpty(this.transactionCallback)){
                client.setTransactionCallback(this.transactionCallback);
            }
            if( !TextUtils.isEmpty(this.passkey) &&
                this.shortCode != null &&
                !TextUtils.isEmpty(this.productionURL) &&
                !TextUtils.isEmpty(this.msisdn)){
                client.setShortCode(this.shortCode);
                client.setPassKey(this.passkey);
                client.setMSISDN(this.msisdn);
                client.setProductionURL(this.productionURL);
            }
            client.create(this.key,this.secret);
        }


    }


    public Client(String key, String secret){
        this.client =  new mgopesa.Client();
        client.create(key, secret);
    }

    public Client(String key, String secret, String transactionCallback){
        this.client =  new mgopesa.Client();
        client.setTransactionCallback(transactionCallback);
        client.create(key, secret);
    }

    public Client(
            String key,
            String secret,
            long shortCode,
            String passkey,
            String MSISDN,
            String productionURL,
            String transactionCallback )
    {
        this.client =  new mgopesa.Client();
        client.setShortCode(shortCode);
        client.setPassKey(passkey);
        client.setMSISDN(MSISDN);
        client.setProductionURL(productionURL);
        client.setTransactionCallback(transactionCallback);
        client.create(key, secret);
    }


    public Map<String, Object> stkPush(long amount, String phoneNumber, String reference, String description){

      StkResponse response =  this.client.stkPush(amount,phoneNumber,reference,description);
      return Mapper.map(response);

    }

    public Map<String, Object> stkResponse(String checkoutRequestID){

        StkResponse response = this.client.stkPushQuery(checkoutRequestID);
        return Mapper.map(response);

    }

}
