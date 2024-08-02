package org.apache.struts2;

import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

public class TaintUtils {

    public static <@RUntainted T> @RUntainted T castToUntainted(@RUntainted T param){
        return param;
    }

    public static <@RUntainted T> @RUntainted T[] castToUntainted(@RUntainted T[] param){
        return param;
    }
}
