package br.com.alura.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        Class<?> sourceClass = input.getClass();
        String targetClassName = sourceClass.getName() + "DTO";
        Class<?> targetClass = Class.forName(targetClassName);

        O targetInstance = (O) targetClass.getDeclaredConstructor().newInstance();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();

        for (Field sourceField : sourceFields) {
            for (Field targetField : targetFields) {
                if (isSameField(sourceField, targetField)) {
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    Object value = sourceField.get(input);
                    targetField.set(targetInstance, value);
                }
            }
        }

        return targetInstance;
    }

    private boolean isSameField(Field sourceField, Field targetField) {
        return sourceField.getName().equals(targetField.getName()) &&
               sourceField.getType().equals(targetField.getType());
    }
}
