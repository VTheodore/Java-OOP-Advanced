package ReflectionEXC.pr0304Barracks.core.commands;

import ReflectionEXC.pr0304Barracks.contracts.Executable;
import ReflectionEXC.pr0304Barracks.contracts.Repository;
import ReflectionEXC.pr0304Barracks.contracts.Unit;
import ReflectionEXC.pr0304Barracks.contracts.UnitFactory;
import ReflectionEXC.pr0304Barracks.core.annotations.Inject;

public class AddCommand implements Executable {
    @Inject
    private String[] data;

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
