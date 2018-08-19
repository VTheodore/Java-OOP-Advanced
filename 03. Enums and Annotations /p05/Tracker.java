package EnumsAndAnnotations.p05;

import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
    @Author(name = "Tedkata")
    public static void printMethodsByAuthor(Class<?> cl){
        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null){
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }

        for (String authorName : methodsByAuthor.keySet()) {
            StringBuilder sb = new StringBuilder();

            sb.append(String.format("%s: ", authorName));

            for (String methodName : methodsByAuthor.get(authorName)) {
                sb.append(String.format("%s, ", methodName));
            }

            sb.delete(sb.length() - 2, sb.length() - 1);

            System.out.println(sb.toString());
        }
    }

    @Author(name = "Tedkata")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
