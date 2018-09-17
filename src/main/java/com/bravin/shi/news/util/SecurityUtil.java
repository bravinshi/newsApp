package com.bravin.shi.news.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
    public static String getMD5(String plainText) {
        String re_md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuilder buf = new StringBuilder("");
            for (byte aB : b) {
                i = aB;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

    public static String getMD5Repeatedly(String plainText, int repeatTime) {
        if (repeatTime <= 0) {
            throw new IllegalArgumentException();
        }
        String cipher = plainText;
        while (repeatTime > 0) {
            cipher = getMD5(cipher);
            repeatTime--;
        }
        return cipher;
    }
}
