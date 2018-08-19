package Reflection.p02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] methods = Reflection.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get")
                    && !method.getReturnType().equals(void.class)
                    && method.getParameterTypes().length == 0){
                getters.add(method);
            }else if (method.getName().startsWith("set")
                    && method.getReturnType().equals(void.class)
                    && method.getParameterTypes().length == 1) {
                setters.add(method);
            }
        }

        for (Method getter : getters) {
            System.out.printf("%s will return %s%n", getter.getName(), getter.getReturnType().getName());
        }

        for (Method setter : setters) {
            System.out.printf("%s and will set field of %s%n", setter.getName(), setter.getParameterTypes()[0].getName());
        }
    }
}
