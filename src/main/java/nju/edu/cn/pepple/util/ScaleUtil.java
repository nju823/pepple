package nju.edu.cn.pepple.util;

import java.math.BigDecimal;

/**
 * Created by cong on 2018-04-19.
 * double精度
 */
public class ScaleUtil {

    public static double scale(double num,int scale) {
        BigDecimal bg = new BigDecimal(num);
        return bg.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static void main(String[] args){
        System.out.println(scale(1.1111,2));
    }
}
