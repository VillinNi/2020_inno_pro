package com.myutils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 记录用户密码或者登录的时候都需要使用MD5进行加密 最后存储的也是加密后的数据不是元数据
 */
public class MdPasswd {
    public static String encry_passwd(String passwd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest m =MessageDigest.getInstance("MD5");
        /**if(passwd.equals(null)||passwd.equals(" "))
            System.out.println("wrong !");*/
         m.update(passwd.getBytes("UTF-8"));
         byte b[]=m.digest();
         String ans="";
         for(int i=0;i<b.length;i++)
         {
            ans+=Integer.toHexString((0x000000ff&b[i]));
         }
         return ans;
    }
}
