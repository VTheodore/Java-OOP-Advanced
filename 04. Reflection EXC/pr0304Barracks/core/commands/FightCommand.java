package ReflectionEXC.pr0304Barracks.core.commands;

import ReflectionEXC.pr0304Barracks.contracts.Executable;

public class FightCommand implements Executable {

    @Override
    public String execute() {
        return "fight";
    }
}
