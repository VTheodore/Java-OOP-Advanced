package Reflection.p03;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Set<Field> fieldsSet = new TreeSet<>(Comparator.comparing(Field::getName));
        Field[] fields = Reflection.class.getDeclaredFields();

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())){
                fieldsSet.add(field);
            }
        }

        for (Field field : fieldsSet) {
            System.out.printf("%s must be private!%n", field.getName());
        }

        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] methods = Reflection.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get")
                    && !method.getReturnType().equals(void.class)
                    && method.getParameterTypes().length == 0
                    && !Modifier.isPublic(method.getModifiers())){
                getters.add(method);
            }else if (method.getName().startsWith("set")
                    && method.getReturnType().equals(void.class)
                    && method.getParameterTypes().length == 1
                    && !Modifier.isPrivate(method.getModifiers())) {
                setters.add(method);
            }
        }

        for (Method getter : getters) {
            System.out.printf("%s have to be public!%n", getter.getName());
        }

        for (Method setter : setters) {
            System.out.printf("%s have to be private!%n", setter.getName());
        }

    }
}
