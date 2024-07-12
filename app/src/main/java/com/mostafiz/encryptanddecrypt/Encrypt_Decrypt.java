package com.mostafiz.encryptanddecrypt;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt_Decrypt {


    public String encrypt(String message,String password) throws Exception{

        byte[] message_bytes=message.getBytes("UTF-8");
        byte[] password_bytes=password.getBytes("UTF-8");

        SecretKeySpec secretKeySpec=new SecretKeySpec(password_bytes,"AES");

        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);

        byte[] encrypted_bytes=cipher.doFinal(message_bytes);

        String encrypted_string= Base64.encodeToString(encrypted_bytes,Base64.DEFAULT);

        return encrypted_string;
    }





    public String decrypt(String message,String password) throws Exception{

        byte[] decrypt_bytes=Base64.decode(message,Base64.DEFAULT);

        byte[] password_bytes=password.getBytes("UTF-8");

        SecretKeySpec secretKeySpec=new SecretKeySpec(password_bytes,"AES");

        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);

        byte[] decrypted_bytes=cipher.doFinal(decrypt_bytes);

        String decrypted_message=new String(decrypted_bytes,"UTF-8");

        return decrypted_message;
    }




}
