package com.ts.util;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by cong on 2017-11-14.
 */
@Component
public class SecurityUtil {


    /**
     * md5加密字符串
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String md5(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        return new BigInteger(1,md.digest()).toString(16);
    }

}
