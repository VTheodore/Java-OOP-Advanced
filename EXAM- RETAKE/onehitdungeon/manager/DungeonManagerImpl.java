package onehitdungeon.manager;

import onehitdungeon.core.HeroTrainerImpl;
import onehitdungeon.factories.HeroFactory;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.HeroTrainer;
import onehitdungeon.misclellanious.ManagerMessages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DungeonManagerImpl implements DungeonManager {
    private Map<String, Hero> heroes;

    private Hero selectedHero;

    private Integer dungeonBattlePower;

    private Double dungeonGold;

    private int dungeonLevel;

    private HeroTrainer heroTrainer;

    public DungeonManagerImpl() {
        // DEBUGGED 2 HOURS ONLY TO FIND OUT THIS IS A MOTHERF HASH MAP :)
        this.heroes = new HashMap<>();
        this.dungeonBattlePower = ManagerMessages.DUNGEON_INIT_BATTLEPOWER;
        this.dungeonGold = ManagerMessages.DUNGEON_INIT_GOLD;
        this.dungeonLevel = ManagerMessages.DUNGEON_STARTING_LEVEL;
        this.heroTrainer = new HeroTrainerImpl();
    }

    //DONE
    @Override
    public String hero(List<String> arguments) {
        Hero hero = HeroFactory.createHero(arguments.get(0), arguments.get(1));
        this.heroes.put(hero.getName(), hero);

        if (this.heroes.size() == 1) {
            this.selectedHero = hero;
        }

        return String.format(ManagerMessages.HERO_COMMAND_SUCCESS, hero.getHeroClass(), hero.getName());
    }

    //DONE
    @Override
    public String select(List<String> arguments) {
        this.selectedHero = this.heroes.get(arguments.get(0));

        return String.format(ManagerMessages.SELECT_COMMAND_SUCCESS, this.selectedHero.getHeroClass(), this.selectedHero.getName());
    }

    //DONE
    @Override
    public String status(List<String> arguments) {
        return this.selectedHero.toString();
    }

    //DONE
    @Override
    public String fight(List<String> arguments) {
        if (this.selectedHero.getTotalBattlePower() >= this.dungeonBattlePower) {
            this.selectedHero.earnGold(this.dungeonGold);

            return String.format(ManagerMessages.FIGHT_COMMAND_SUCCESS, this.dungeonGold);
        }

        returnPreviousLevel();

        return ManagerMessages.FIGHT_COMMAND_FAIL;
    }

    private void returnPreviousLevel() {
        this.dungeonLevel--;
        this.dungeonBattlePower /= ManagerMessages.DUNGEON_ADVANCE_MULTIPLIER;
        this.dungeonGold /= ManagerMessages.DUNGEON_ADVANCE_MULTIPLIER;
    }

    //DONE
    @Override
    public String advance(List<String> arguments) {
        this.dungeonLevel++;
        this.dungeonBattlePower *= ManagerMessages.DUNGEON_ADVANCE_MULTIPLIER;
        this.dungeonGold *= ManagerMessages.DUNGEON_ADVANCE_MULTIPLIER;

        return String.format(ManagerMessages.ADVANCE_COMMAND_SUCCESS, this.dungeonLevel);
    }

    //DONE
    @Override
    public String train(List<String> arguments) {
        if (this.selectedHero.getGold() < this.selectedHero.getTotalPriceForUpgrade()) {
            return String.format(ManagerMessages.TRAIN_COMMAND_FAIL, this.selectedHero.getTotalPriceForUpgrade(), this.selectedHero.getGold());
        }

        this.heroTrainer.trainHero(this.selectedHero);
        return String.format(ManagerMessages.TRAIN_COMMAND_SUCCESS, this.selectedHero.getTotalBattlePower());
    }

    //DONE
    @Override
    public String quit(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        for (Hero hero : heroes.values()) {
            sb.append(String.format(ManagerMessages.QUIT_COMMAND_PATTERN, hero.getHeroClass(), hero.getName(), hero.getTotalBattlePower())).append(System.lineSeparator());
        }
        sb.append(ManagerMessages.LINE_SPLITTER).append(System.lineSeparator());

        sb.append(String.format(ManagerMessages.QUIT_COMMAND_DUNGEON_LEVEL_REACHED, this.dungeonLevel));

        return sb.toString();
    }
}
