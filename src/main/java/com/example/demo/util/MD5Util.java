package com.example.demo.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static String  md5(String src) { return DigestUtils.md5Hex(src); }

    private static final String salt = "g_passsword_salt";

    public static String inputPassToFormPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String FormPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String input, String saltDb) {
        String formpass = inputPassToFormPass(input);
        String dbPass = FormPassToDBPass(formpass, saltDb);
        return dbPass;
    }

    public static void main(String[] args) {
        //System.out.println(md5(inputPassToDBPass("Arvin1234", "g_passsword_salt")));
        String s = FormPassToDBPass("f53fc1ce3ded5a6779553530c23c2e51", salt);
        System.out.println(s);
    }
}
