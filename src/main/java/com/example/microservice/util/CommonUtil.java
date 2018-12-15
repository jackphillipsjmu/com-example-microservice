package com.example.microservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Class provides useful methods to help ease development. If more verbose functionality is needed
 * please refer to Apache's common util packages.
 *
 * @author Jack Phillips
 */
public class CommonUtil {
    /**
     * Private default constructor
     */
    private CommonUtil() {
        // Private constructor to keep static code analysis happy
    }

    /**
     * Checks the provided left hand argument to see if it is null, if so, then it will return the default value,
     * otherwise return the left hand argument.
     *
     * @param lhsObject T to validate
     * @param defaultObject T default object to return if left hand object is null
     * @param <T> Generic Type
     * @return T the left hand variable if not null, default object otherwise
     */
    public static <T> T defaultIfNull(T lhsObject, T defaultObject) {
        return Objects.nonNull(lhsObject) ? lhsObject : defaultObject;
    }

    /**
     * Throws exception if the provided left hand object is null.
     *
     * @param object T to check for null
     * @param throwable E throwable error to invoke if left hand object is null
     * @param <T> Generic Type of the left hand object
     * @param <E> Child class of Throwable
     * @throws E
     */
    public static <T, E extends Throwable> void ifNullThrowException(T object, E throwable) throws E {
        if (Objects.isNull(object)) {
            throw throwable;
        }
    }

    /**
     * If the provided left hand String is null or empty then the default String is returned, otherwise, the
     * left hand String is returned.
     *
     * @param str String to check if its null or empty
     * @param defaultStr String to default to if left hand String is empty or null
     * @return String either the populated left hand String or default String
     */
    public static String defaultIfNullOrEmpty(final String str, final String defaultStr) {
        return isNullOrEmpty(str) ? defaultStr : str;
    }

    /**
     * Determines if the provided String can be be sliced or not, if so, it will return the substring, otherwise it
     * will return the original String value.
     *
     * @param size Integer end index, exclusive
     * @param str String to retrieve substring value
     * @return String that is either the substring value or original value
     */
    public static String safeSubstring(final Integer size, final String str) {
        // If the string is null/empty or the size is less than whats provided return
        // the provided String, otherwise, slice it to the passed in size
        return (isNullOrEmpty(str) || str.length() < size) ? str : str.substring(0, size);
    }

    /**
     * Determines if the provided String is null or empty.
     *
     * @param str String to evaluate
     * @return boolean true if the provided String is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(final String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Parses the provided Object to its String representation using Jackson
     *
     * @param object T to parse to String
     * @param <T> Generic Type
     * @return String if the object is populated, null if not
     * @throws JsonProcessingException
     */
    public static <T> String writeAsJSONString(T object) throws JsonProcessingException {
        if (Objects.isNull(object)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    /**
     * Checks the provided array to determine if it is null or empty.
     *
     * @param array of type T to check if null or empty
     * @param <T> Generic Type
     * @return boolean true if the array is null or empty, false otherwise
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length <= 0;
    }

    /**
     * Checks the provided array to determine if it is NOT null or empty.
     *
     * @param array of type T to check if NOT null or empty
     * @param <T> Generic Type
     * @return boolean true if the array is NOT null or empty, false otherwise
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    /**
     * Inspects the provided {@link Collection} to determine if it is empty.
     *
     * @param collection Collection of any type
     * @return boolean true if the Collection is empty, false otherwise
     */
    public static boolean isEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Inspects the provided {@link Collection} to determine if it is NOT empty.
     *
     * @param collection Collection of any type
     * @return boolean true if the Collection is NOT empty, false otherwise
     */
    public static boolean isNotEmpty(final Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * Returns a mutable {@link List} of values that are passed into the method.
     *
     * @param values 1..N T values to append to result List
     * @param <T> the type of the elements of the List
     * @return List of T objects built from the values parameter
     */
    public static <T> List<T> listOf(T ... values) {
        return new ArrayList<>(Arrays.asList(values));
    }

    /**
     * Returns a {@link Set} of values that are passed into the method.
     *
     * @param values 1..N T values to append to result Set
     * @param <T> the type of the elements to append to Set
     * @return Set of T objects built from the values parameter
     */
    public static <T> Set<T> setOf(T ... values) {
        return new HashSet<>(Arrays.asList(values));
    }
}
