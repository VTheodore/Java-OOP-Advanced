package ReflectionEXC.pr0304Barracks.core.commands;

import ReflectionEXC.pr0304Barracks.contracts.Executable;
import ReflectionEXC.pr0304Barracks.contracts.Repository;
import ReflectionEXC.pr0304Barracks.core.annotations.Inject;

public class ReportCommand implements Executable {
    @Inject
    private Repository repository;

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
