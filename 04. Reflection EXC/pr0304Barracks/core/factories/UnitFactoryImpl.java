package ReflectionEXC.pr0304Barracks.core.factories;

import jdk.jshell.spi.ExecutionControl;
import ReflectionEXC.pr0304Barracks.contracts.Unit;
import ReflectionEXC.pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionEXC.pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType){
	    Unit unit = null;
		try {
			Class<?> aClass = Class.forName(UNITS_PACKAGE_NAME + unitType);

            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            unit = (Unit) declaredConstructor.newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}

		return unit;
    }
}
