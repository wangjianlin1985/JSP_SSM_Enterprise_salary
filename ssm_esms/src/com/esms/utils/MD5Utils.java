// 
// 
// 

package com.esms.utils;

import java.security.MessageDigest;

public class MD5Utils
{
    private static final String[] hexDigits;
    
    static {
        hexDigits = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    }
    
    public static String encodeByMD5(String originString) {
        if (originString != null) {
            final StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(originString);
            stringBuffer.append("esms");
            originString = String.valueOf(stringBuffer);
            try {
                final MessageDigest md = MessageDigest.getInstance("MD5");
                final byte[] results = md.digest(originString.getBytes());
                final String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    private static String byteArrayToHexString(final byte[] b) {
        final StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }
    
    private static String byteToHexString(final byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        final int d1 = n / 16;
        final int d2 = n % 16;
        return String.valueOf(MD5Utils.hexDigits[d1]) + MD5Utils.hexDigits[d2];
    }
    
    public static void main(final String[] args) {
        System.out.println(encodeByMD5("admin"));
    }
}
