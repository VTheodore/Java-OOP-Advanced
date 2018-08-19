package ReflectionEXC.pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws IOException {
		var in = new BufferedReader(new InputStreamReader(System.in));

		String fieldToHarvest;

		while (!"HARVEST".equals(fieldToHarvest = in.readLine())){
		    printFields(fieldToHarvest);
        }
	}

    private static void printFields(String fieldToHarvest){
        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

        switch (fieldToHarvest){
            case "private":
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    if (Modifier.isPrivate(declaredField.getModifiers())){
                        System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers()), declaredField.getType().getSimpleName(), declaredField.getName());
                    }
                }
                break;
            case "protected":
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    if (Modifier.isProtected(declaredField.getModifiers())){
                        System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers()), declaredField.getType().getSimpleName(), declaredField.getName());
                    }
                }
                break;
            case "public":
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    if (Modifier.isPublic(declaredField.getModifiers())){
                        System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers()), declaredField.getType().getSimpleName(), declaredField.getName());
                    }
                }
                break;
            case "all":
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    System.out.printf("%s %s %s%n", Modifier.toString(declaredField.getModifiers()), declaredField.getType().getSimpleName(), declaredField.getName());
                }
                break;
        }


    }
}
