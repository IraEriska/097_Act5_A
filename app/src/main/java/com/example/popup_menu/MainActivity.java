package com.example.popup_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Deklarasi variabel untuk button
        Button btnLogin;

        //Deklarasi variabel untuk EditText
        EditText edEmail, edpassword;

        //Deklarasi variabel untuk menyimpan email dan password
        String nama, password;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Menghubungkan variabel btnLogin dengan componen button pada layout
            btnLogin = findViewById(R.id.btSignin);

            //Menghubungkan variabel edEmail dengan componen button pada layout
            edEmail = findViewById(R.id.edEmail);

            //Menghubungkan variabel edPassword dengan componen button pada layout
            edpassword = findViewById(R.id.edPassword);

            //membuat fungsi one klik pada button btnLogin
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Menyimpan input user di edittext email kedalam variabel nama
                    nama = edEmail.getText().toString();

                    //Menyimpan input user di edittext password kedalam variabel password
                    password = edpassword.getText().toString();

                    //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email anda: " + nama + " dan Password anda: " + password + "", Toast.LENGTH_LONG);

                    //memvalidasi inputan user
                    if (nama.isEmpty() || password.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                    }

                    //Menampilkan toast
                    t.show();

                    //membuat fungsi onclik pada button btn login
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //menyimpan input user di edittext password kedalam variabel nama
                            nama = edEmail.getText().toString();

                            //menyimpan input user di edittext password ke dalam variabel password
                            password = edpassword.getText().toString();

                            //mengeset email yang benar
                            String email = "admin@mail.com";

                            //mengeset password yang benar
                            String pass = "123";

                            //mengecek apakah isi dari email dan password sudah sama dengan email dan password
                            //yang sudah di set
                            if (nama.equals(email) && password.equals(pass)) {
                                //membuat variabel toast dan menampilkan pesan "login sukses"
                                Toast t = Toast.makeText(getApplicationContext(),
                                        "Login Sukses",
                                        Toast.LENGTH_LONG);

                                //menampilkan toast
                                t.show();

                                //membuat objek bundle
                                Bundle b = new Bundle();

                                //Memasukkan value dari variabel nama dengan kunci "a"
                                //dan dimasukkan ke dalam bundel
                                b.putString("a", nama.trim());

                                //memasukkan value dari variabel password dengan kunci "b"
                                //dan dimasukkan kedalam bundel
                                b.putString("b", password.trim());

                                //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                                Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                                //memasukkan bundel kedalam intent untuk dikirim ke activityHasil
                                i.putExtras(b);

                                //berpindah ke activityHasil
                                startActivity(i);
                            } else {
                                //membuat variabel toast dan membuat toast dan menampilkan pesan "Login Gagak"
                                Toast t = Toast.makeText(getApplicationContext(),
                                        "Login Gagal", Toast.LENGTH_LONG);

                                // menampilkan toast
                                t.show();
                            }
                        }
                    });
                }
            });
        }
    }
    }
}