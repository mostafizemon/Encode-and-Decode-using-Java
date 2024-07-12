package com.mostafiz.encryptanddecrypt;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mostafiz.encryptanddecrypt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String password,message;
    Encrypt_Decrypt encryptDecrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        encryptDecrypt=new Encrypt_Decrypt();



        binding.buttonEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message=binding.editMessage.getText().toString();
                password=binding.editPassword.getText().toString();

                if (password.length()!=16){
                    Toast.makeText(MainActivity.this,"Password Must be 16 bits",Toast.LENGTH_SHORT).show();
                    binding.editPassword.setError("Enter 16 bit Password");
                    binding.editPassword.requestFocus();
                }

                if (message.isEmpty() || password.isEmpty()){
                    binding.editMessage.setError("Enter Your Message");
                    binding.editMessage.requestFocus();
                    Toast.makeText(MainActivity.this,"Please Fillup ALl Field",Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        String encrypted_message=encryptDecrypt.encrypt(message,password);
                        binding.result.setText(encrypted_message);
                    } catch (Exception e){
                       // throw new RuntimeException(e);
                       binding.result.setText(""+e);

                    }

                }


            }
        });



        binding.buttonDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message=binding.editMessage.getText().toString();
                password=binding.editPassword.getText().toString();
                if (password.length()!=16){
                    Toast.makeText(MainActivity.this,"Password Must be 16 bits",Toast.LENGTH_SHORT).show();
                    binding.editPassword.setError("Enter 16 bit Password");
                    binding.editPassword.requestFocus();
                }

                if (message.isEmpty() || password.isEmpty()){
                    binding.editMessage.setError("Enter Your Message");
                    binding.editMessage.requestFocus();
                    Toast.makeText(MainActivity.this,"Please Fillup ALl Field",Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        String encrypted_message=encryptDecrypt.decrypt(message,password);
                        binding.result.setText(encrypted_message);
                    } catch (Exception e){
                        // throw new RuntimeException(e);
                        binding.result.setText(""+e);

                    }

                }

            }
        });






    }
}