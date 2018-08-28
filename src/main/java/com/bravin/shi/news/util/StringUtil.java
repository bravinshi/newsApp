package com.bravin.shi.news.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static boolean isTrimEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isChinaPhoneLegal(String str) {
        String regExp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[0-9])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isVerifyCode(String code) {
        String regExp = "^\\d{6}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(code);
        return m.matches();
    }
}
