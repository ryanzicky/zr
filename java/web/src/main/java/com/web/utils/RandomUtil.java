package com.web.utils;

import com.web.enums.TypeEnum;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author zhourui
 * @Date 2020/12/22 11:21
 */
public class RandomUtil {

    /**
     * 加盐MD5
     *
     * @param salt1
     * @param salt2
     * @return
     */
    public static String UUIDWithSalt(String salt1, String salt2) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            digest = md5.digest((salt1 + salt2).getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, digest).toString(16);
    }

    /**
     * 当前时间加盐MD5
     *
     * @return
     */
    public static String UUID() {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            digest = md5.digest((String.valueOf(System.currentTimeMillis())).getBytes("utf-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, digest).toString(16);
    }

    public static void main(String[] args) {
        System.out.println(UUIDWithSalt(TypeEnum.USER.getName(), String.valueOf(System.currentTimeMillis())));
    }
}
