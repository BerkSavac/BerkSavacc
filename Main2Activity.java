package com.arif_ginanjar.lesson5crudsqllite.KullanıcıTarafi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arif_ginanjar.lesson5crudsqllite.MainActivity;
import com.arif_ginanjar.lesson5crudsqllite.R;

public class Main2Activity extends AppCompatActivity {

    private Button Hakkımızda;
    private Button btSignIn;
    private Button btSignUp;
    private EditText edtEmail;
    private EditText edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btSignIn=findViewById(R.id.btSignIn);
        btSignUp=findViewById(R.id.btSignUp);
        Hakkımızda=findViewById(R.id.Hakkımızda);
        edtEmail=findViewById(R.id.emailinput);
        edtPassword=findViewById(R.id.passwordinput);
        final DatabaseHelper dbHelper=new DatabaseHelper(this);
        Hakkımızda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Main2Activity.this,MainActivity.class);
           startActivity(intent);
            }
        });
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emptyValidation()) {
                    dbHelper.addUser(new User(edtEmail.getText().toString(), edtPassword.getText().toString()));
                    Toast.makeText(Main2Activity.this, "Kullanıcı eklendi", Toast.LENGTH_SHORT).show();
                    edtEmail.setText("");
                    edtPassword.setText("");
                }else{
                    Toast.makeText(Main2Activity.this, "Kullanıcı eklenmedi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!emptyValidation()) {
                    User user = dbHelper.queryUser(edtEmail.getText().toString(), edtPassword.getText().toString());
                    if (user != null) {
                        Bundle mBundle = new Bundle();
                        mBundle.putString("user", user.getEmail());
                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        intent.putExtras(mBundle);
                        startActivity(intent);
                        Toast.makeText(Main2Activity.this, "Hoşgeldin " + user.getEmail(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Main2Activity.this, "Kullanıcı bulunamadı", Toast.LENGTH_SHORT).show();
                        edtPassword.setText("");
                    }
                }else{
                    Toast.makeText(Main2Activity.this, "Hata", Toast.LENGTH_SHORT).show();
                }}
        });
    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) || TextUtils.isEmpty(edtPassword.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }
}
