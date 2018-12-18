package com.example.upasanam.netconfig;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.upasanam.netconfig.Login.mGoogleSignInClient;

public class Intermediate extends AppCompatActivity {
    //This activity handles the screen on the app that displays the two check available - Resolution Check & IPv6 incoming traffic check
    Button b4;
    RadioButton cb1, cb2;
    RadioGroup rg;
    int msg;

    Button button;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    //Supressing the use of back button on this activity
    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);

        //Creating radio buttons which when selected by the user woulf redirect to the appropriate check
        cb1 = (RadioButton) findViewById(R.id.rd);
        cb2 = (RadioButton) findViewById(R.id.rd2);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        onRadioClick();

        //A sign out button has been created to log off from Firebase first and then the Gmail Acccount as well
        button = (Button) findViewById(R.id.sign_out);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(Intermediate.this, Login.class));
                    finish();
                }
            }
        };

        //Creating a listener to call the signOut method when Sign Out button is click on
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
            }
        });

        //Google sign out
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });

        //Revoke all granted permissions and clear the default account.  The user will have to pass the login screen with the account picker to sign in again.
        mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });

    }

    //Radio button click to redirect to the appropriate check
    public void onRadioClick() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rd:
                        msg = 1;
                        startActivity(new Intent(Intermediate.this, MainActivity.class));
                        break;
                    case R.id.rd2:
                        msg = 2;
                        startActivity(new Intent(Intermediate.this, NetworkTest.class));
                        break;
                    // default: Toast.makeText(this, "Please Select a valid option", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}



