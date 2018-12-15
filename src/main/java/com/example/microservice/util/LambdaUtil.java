package com.example.microservice.util;

import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Class provides helpful methods when performing Java Lambda functions.
 *
 * @author Jack Phillips
 */
public class LambdaUtil {

    /**
     * Obtains the first element from a List if it is not empty. If there are no elements
     * then a null value is returned.
     *
     * @param <T> Generic Object to collect
     * @return Collector to extract first element of list if presents, otherwise, it will
     * return null.
     */
    public static <T> Collector<T, ?, T> singletonCollector() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (CommonUtil.isNotEmpty(list)) {
                        return list.get(0);
                    }
                    return null;
                }
        );
    }
}
