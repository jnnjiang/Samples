package com.nana.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    /**
     * 去掉空格、回车、换行符、制表符
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 判断字符串是不是中文字符
     * @param str
     * @return
     */
    public static boolean IsChinese(String str){
        for (int i = 0; i < str.length(); i++) {
            if(!(str.substring(i, i + 1).matches("[\\u4e00-\\u9fa5]+"))){
                return false;
            }
        }
        return true;
    }
}
