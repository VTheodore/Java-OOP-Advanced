package ReflectionEXC.pr0304Barracks.core;

import ReflectionEXC.pr0304Barracks.contracts.Executable;
import ReflectionEXC.pr0304Barracks.contracts.Repository;
import ReflectionEXC.pr0304Barracks.contracts.Runnable;
import ReflectionEXC.pr0304Barracks.contracts.UnitFactory;
import ReflectionEXC.pr0304Barracks.core.annotations.Inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private static final String COMMANDS_PATH = "ReflectionEXC.pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;
    private String[] data;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpredCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpredCommand(String[] data, String commandName) {
        this.data = data;
        try {
            String refactoredName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1).toLowerCase() + "Command";
            Class<?> commandClass = Class.forName(COMMANDS_PATH + refactoredName);

            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();

            Executable command = (Executable) declaredConstructor.newInstance();

            this.injectDependencies(command);

            return command.execute();

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }


    private <T> void injectDependencies(T destination) throws IllegalAccessException {
        Field[] destinationFields = destination.getClass().getDeclaredFields();
        Field[] sourceFields = this.getClass().getDeclaredFields();

        for (Field destinationField : destinationFields) {
            destinationField.setAccessible(true);
            if (destinationField.isAnnotationPresent(Inject.class)){
                for (Field sourceField : sourceFields) {
                    sourceField.setAccessible(true);
                    if (destinationField.getType().getSimpleName().equals(sourceField.getType().getSimpleName()) && destinationField.getType().equals(sourceField.getType())){
                        destinationField.set(destination, sourceField.get(this));
                    }
                }
            }
        }
    }
}
