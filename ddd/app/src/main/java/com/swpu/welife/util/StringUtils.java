package com.swpu.welife.util;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see StringUtils
 * @since 2018/12/3
 */
public class StringUtils {

    public static int length(String s) {
        return s != null ? s.length() : 0;
    }

    public static boolean equals(String a, String b) {
        if (a == null) {
            return false;
        }
        return a.equals(b);
    }
}
