package com.company.classworkrelationhomework.util.list;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;

public class ArraysNonNullUtil {
    public static <T> boolean isArrayNullOrEmpty(T[] theArray) {
        return theArray == null || theArray.length == 0;
    }

    public static boolean isEmpty(final Object object) {
        if (object == null) {
            return true;
        }

        if (isArray(object)) {
            return Array.getLength(object) == 0;
        }
        return false;
    }

    private static boolean isArray(final Object object) {
        return object != null && object.getClass().isArray();
    }
}
