package ru.mailow.hwReflection;

import ru.mailow.Person;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Задание
сериализовать поля и значения
в json и xml
 */

public class SerializeReflection {

    public static void main(String[] args) throws IllegalAccessException {
        List names = new ArrayList();

        Map address = new HashMap<String,String>();
        address.put("city","Moscow");
        address.put("street","Street");
        Person person = new Person("Bill",22, address);

        names = collectFieldName(person);
        System.out.println(names);

    }

    public SerializeReflection() {
    }

    public static List<String> collectFieldName(Object o) throws IllegalAccessException {
        final Class c = o.getClass();
        final List names = new ArrayList();

        for (Field field : c.getDeclaredFields()) {

            field.setAccessible(true);
            Object value = field.get(o);

            names.add(field.getName().toString());
            //names.add(field.get(field));
            System.out.println(value);


        }
        return names;
    }


}