package org.apache.struts2;

import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

public class TaintUtils {

    public static <T> @RUntainted T castToUntainted(T param){
        return param;
    }

    public static <T> @RUntainted T[] castToUntainted(T[] param){
        return param;
    }
}
