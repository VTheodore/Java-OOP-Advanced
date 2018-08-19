package ReflectionEXC.pr0304Barracks.core.commands;

import ReflectionEXC.pr0304Barracks.contracts.Executable;
import ReflectionEXC.pr0304Barracks.contracts.Repository;
import ReflectionEXC.pr0304Barracks.core.annotations.Inject;

public class RetireCommand implements Executable {
    @Inject
    private String[] data;

    @Inject
    private Repository repository;

    @Override
    public String execute() {
        String res = null;
        try {
            this.repository.removeUnit(this.data[1]);
            res = this.data[1] + " retired!";
        } catch (IllegalArgumentException iae) {
            res = iae.getMessage();
        }

        return res;
    }
}
