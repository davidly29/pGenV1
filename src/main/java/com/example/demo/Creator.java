package com.example.demo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Service
public class Creator {
    Scure1 s1;
    private static Cipher ecipher;
    private static Cipher dcipher;
    private static SecretKey key;
    public Creator(Scure1 s1) {
        this.s1 = s1;
    }

    public List<String> rGen1Salt(String v1) {
        List<String> al=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

            while (salt.length() < 12) {
                int index = (int) (rnd.nextFloat() * saltChars.length());
                salt.append(saltChars.charAt(index));
            }
            String saltStr = salt.toString();
            s1.setV1(saltStr);
            al.add(saltStr);
        }
        return al;
    }


    public void gen(){
        try{
            key = KeyGenerator.getInstance("DES").generateKey();
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");
            ///////////////////////////////////
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
            encript("This message is encripted");
            encript(getClass().getName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void encript(String str){
        try {

            byte[] utf8 = str.getBytes("UTF8");
            byte[] ivBytes = "input123".getBytes();

            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

            Cipher c;
            byte[] cipherText;
            int ctLenght;

            Security.addProvider(new BouncyCastleProvider());
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    public List<Integer> rGenNum1(int v1){
        List<Integer> num = new ArrayList<>();
                int num1 = ThreadLocalRandom.current().nextInt(1, 20);
                int num2 = ThreadLocalRandom.current().nextInt(1,20);
                int num3 = ThreadLocalRandom.current().nextInt(1, 20);
                int num4 = ThreadLocalRandom.current().nextInt(1, 20);
            num.add(num1);
            num.add(num2);
            num.add(num3);
            num.add(num4);
            return  num;
    }
}
