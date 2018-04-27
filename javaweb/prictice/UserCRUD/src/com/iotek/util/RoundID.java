package com.iotek.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vitme on 2016/9/3.
 */
public class RoundID {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public String getID(int IDType){
        String id;
        switch (IDType){
            case 1:
                id = roundID("user");
                break;
            case 2:
                id = roundID("ud");
                break;
            case 3:
                id = roundID("order");
                break;
            case 4:
                id = roundID("od");
                break;
            default:
                id = roundID("iotek");
                break;
        }
        return id;//user2016090811275622212589745631
    }
    public String roundID(String prefix){
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < 15-prefix.length(); i++) {
            stb.append((int)(Math.random()*10));
        }
        return prefix+sdf.format(new Date())+stb.toString();
    }

}
