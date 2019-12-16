package ru.mailow.hwReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {

    public static void main(String[] args) {
        List names = new ArrayList();

        names = collectFieldName("Test");
        System.out.println(names);


        names = collectMethodName("Test");
        System.out.println(names);

    }

    public ReflectionUtils() {
    }

    public static List<String> collectFieldName(Object o) {
        final Class c = o.getClass();
        final List names = new ArrayList();
        for (Field field : c.getDeclaredFields()) {
            if (field.getName().toString().length() <= 5) {
                names.add(field.getName().toString());
            }
        }
        return names;
    }

    public static List<String> collectMethodName(Object o) {
        final Class c = o.getClass();
        final List names = new ArrayList();
        for (Method method : c.getDeclaredMethods()) {
            if (method.getName().toString().length() <= 5) {
                names.add(method.getName().toString());
            }
        }
        return names;
    }


}