package ReflectionEXC.pr0304Barracks;

import ReflectionEXC.pr0304Barracks.contracts.Repository;
import ReflectionEXC.pr0304Barracks.contracts.Runnable;
import ReflectionEXC.pr0304Barracks.contracts.UnitFactory;
import ReflectionEXC.pr0304Barracks.core.Engine;
import ReflectionEXC.pr0304Barracks.core.factories.UnitFactoryImpl;
import ReflectionEXC.pr0304Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
