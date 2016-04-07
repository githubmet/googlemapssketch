package com.example.donottouch6.myapplication2;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class P001GoogleSignIn extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_CODE_GOOGLE_SIGN_IN=1246;
    GoogleApiClient googleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001googlesignin);

        findViewById(R.id.signInButtonP001).setOnClickListener(this);


        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient=new GoogleApiClient
                .Builder(P001GoogleSignIn.this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signInButtonP001){
            Intent intent= Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
            startActivityForResult(intent,REQUEST_CODE_GOOGLE_SIGN_IN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE_GOOGLE_SIGN_IN){
            GoogleSignInResult googleSignInResult= Auth.GoogleSignInApi
                    .getSignInResultFromIntent(data);

            if(googleSignInResult.isSuccess()){
                GoogleSignInAccount googleSignInAccount=googleSignInResult.getSignInAccount();
                String displayName= googleSignInAccount.getDisplayName();
                String email= googleSignInAccount.getEmail();

                Snackbar.make(getWindow().getDecorView(),
                        "Display Name="+displayName+
                                "\nemail="+email,
                        Snackbar.LENGTH_LONG
                ).show();
            }
        }
    }
}
