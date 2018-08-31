package onehitdungeon.misclellanious;

public final class ManagerMessages {

    public static final String HERO_COMMAND_SUCCESS = "Successfully added %s - %s.";

    public static final String SELECT_COMMAND_SUCCESS = "Successfully selected %s - %s.";

    public static final String TRAIN_COMMAND_SUCCESS = "Successfully trained hero. Current total battle power: %d.";

    public static final String TRAIN_COMMAND_FAIL = "Insufficient gold for training. Needed %.2f. Got %.2f.";

    public static final String QUIT_COMMAND_PATTERN = "%s %s - %d (BP)";

    public static final String LINE_SPLITTER = "####################";

    public static final String QUIT_COMMAND_DUNGEON_LEVEL_REACHED = "Dungeon level reached: %d";

    public static final Integer DUNGEON_INIT_BATTLEPOWER = 20;

    public static final Double DUNGEON_INIT_GOLD = 15D;

    public static final Integer DUNGEON_ADVANCE_MULTIPLIER = 2;

    public static final int DUNGEON_STARTING_LEVEL = 1;

    public static final String FIGHT_COMMAND_SUCCESS = "Fight won. You've gained %.2f gold.";

    public static final String FIGHT_COMMAND_FAIL = "Fight lost. You've returned to the previous level.";

    public static final String ADVANCE_COMMAND_SUCCESS = "Successfully advanced to dungeon level %d.";

}
