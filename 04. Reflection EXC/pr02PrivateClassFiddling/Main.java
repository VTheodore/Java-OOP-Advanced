package ReflectionEXC.pr02PrivateClassFiddling;

import ReflectionEXC.pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static final String CLASS_NAME = "ReflectionEXC.pr02PrivateClassFiddling.com.BlackBoxInt";
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
	    var in = new BufferedReader(new InputStreamReader(System.in));

        Class<?> c = Class.forName(CLASS_NAME);
        Constructor<?> declaredConstructor = c.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();

        String line;

        while (!"END".equals(line = in.readLine())){
            String[] cmdArgs = line.split("_");


            Method declaredMethod = c.getDeclaredMethod(cmdArgs[0], int.class);
            declaredMethod.setAccessible(true);

            declaredMethod.invoke(blackBoxInt, Integer.parseInt(cmdArgs[1]));

            Field innerValue = c.getDeclaredField("innerValue");
            innerValue.setAccessible(true);

            int value = (int) innerValue.get(blackBoxInt);

            System.out.println(value);
        }
	}
}
