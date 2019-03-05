package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/path")
public class Controller {
    Creator cr1;
    Scure1 sz;

    @Autowired
    public Controller(Creator cr1, Scure1 sz) {
        this.cr1 = cr1;
        this.sz = sz;
    }

    @RequestMapping("/test")
    public String testing(){
        return "Hello There";
    }

   // @GetMapping("/converter")
    public List<String> convertV1(){
        String var = sz.getV1();
        List<String> hashed = cr1.rGen1Salt(var);
        return  hashed;
    }

    public List<String> convertV2(){
        String var2 = sz.getV2();
        List<String> hashed = cr1.rGen1Salt(var2);
        return hashed;
    }

    public List<Integer> convertNum1(){
        int num1 = sz.getNum1();
        List<Integer> num = cr1.rGenNum1(num1);
        return num;
    }

    public List<Integer> convertNum2(){
        int num2 = sz.getNum2();
        List<Integer> nums = cr1.rGenNum1(num2);
        return nums;
    }
    /////////////////////////////////

    @GetMapping("/check")
    public String allPass(){
        List<String> hash = convertV1();
        int size = hash.size();

        List<String> vars = new ArrayList<>();
        vars.add("Facebook: ");
        vars.add("Instagram: ");
        vars.add("Snapchat: ");
        vars.add("Steam:");
        vars.add("Blizzard: ");
        vars.add("Paypay: ");
        vars.add("Google: ");
        vars.add("League of Legends: ");

        List<String> yourPass = new ArrayList<>();
        List<Integer> num = convertNum1();

        for(int i = 0; i < vars.size(); i++){
            yourPass.add(vars.get(i) + " " + hash.get(i));
        }

        return yourPass.toString() + " Test " + num.toString();
    }



}
