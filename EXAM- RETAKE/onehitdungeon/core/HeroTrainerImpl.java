package onehitdungeon.core;

import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.HeroTrainer;
import onehitdungeon.interfaces.Item;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HeroTrainerImpl implements HeroTrainer {
    private Map<String, Integer> itemTrainProperties = new HashMap<>() {{
        put("paladin-weapon-battlepower", 60);
        put("paladin-weapon-priceforupgrade", 50);
        put("paladin-offhand-battlepower", 50);
        put("paladin-offhand-priceforupgrade", 100);
        put("paladin-armor-battlepower", 20);
        put("paladin-armor-priceforupgrade", 75);

        put("mage-weapon-battlepower", 20);
        put("mage-weapon-priceforupgrade", 67);
        put("mage-offhand-battlepower", 20);
        put("mage-offhand-priceforupgrade", 100);
        put("mage-armor-battlepower", 100);
        put("mage-armor-priceforupgrade", 100);
    }};

    private void increaseBattlePower(Field battlePowerField, Item itemObject, String property) throws IllegalAccessException {
        Integer oldBattlePower = (Integer) battlePowerField.get(itemObject);
        Integer modification = this.itemTrainProperties.get(property);
        Integer newBattlePower = (int) (oldBattlePower * (1 + (modification / 100.0)));

        battlePowerField.set(itemObject, newBattlePower);
    }

    private void increasePriceForUpgrade(Field priceForUpgradeField, Item itemObject, String property) throws IllegalAccessException {
        Double oldPriceForUpgrade = (Double) priceForUpgradeField.get(itemObject);
        Integer modification = this.itemTrainProperties.get(property);
        Double newPriceForUpgrade = oldPriceForUpgrade * (1 + (modification / 100.0));

        priceForUpgradeField.set(itemObject, newPriceForUpgrade);
    }

    private String getItemType(String itemName) {
        if (itemName.contains("weapon")) return "weapon";
        else if (itemName.contains("offhand")) return "offhand";
        else if (itemName.contains("armor")) return "armor";

        return null;
    }

    private void trainItemBattlePower(String itemType, Item itemObject, Hero hero) throws NoSuchFieldException, IllegalAccessException {
        Field battlePowerField = itemObject
                .getClass()
                .getSuperclass()
                .getDeclaredField("battlePower");

        battlePowerField.setAccessible(true);

        String heroClassName = hero.getClass().getSimpleName().substring(0, hero.getClass().getSimpleName().length() - 4).toLowerCase();
        String propertyBattlePower = String.format("%s-%s-battlepower",heroClassName, itemType);

        this.increaseBattlePower(battlePowerField, itemObject, propertyBattlePower);
    }

    private void trainItemPriceForUpgrade(String itemType, Item itemObject, Hero hero) throws NoSuchFieldException, IllegalAccessException {
        Field priceForUpgradeField = itemObject
                .getClass()
                .getSuperclass()
                .getDeclaredField("priceForUpgrade");

        priceForUpgradeField.setAccessible(true);

        String heroClassName = hero.getClass().getSimpleName().substring(0, hero.getClass().getSimpleName().length() - 4).toLowerCase();
        String propertyPriceForUpgrade = String.format("%s-%s-priceforupgrade", heroClassName, itemType);

        this.increasePriceForUpgrade(priceForUpgradeField, itemObject, propertyPriceForUpgrade);
    }

    private void trainItem(Item item, Hero hero) throws IllegalAccessException, NoSuchFieldException {
        String itemType = this.getItemType(item.getClass().getSimpleName().toLowerCase());

        this.trainItemBattlePower(itemType, item, hero);
        this.trainItemPriceForUpgrade(itemType, item, hero);
    }

    private void increaseHeroTrainings(Hero hero){
        try {
            Field trained = hero.getClass().getSuperclass().getDeclaredField("trainedTimes");
            trained.setAccessible(true);
            int currentValue = (int) trained.get(hero);

            trained.set(hero, currentValue + 1);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void trainHero(Hero hero) {
        try {
            hero.payGold(hero.getTotalPriceForUpgrade());
            this.trainItem(hero.getWeapon(), hero);
            this.trainItem(hero.getOffhand(), hero);
            this.trainItem(hero.getArmor(), hero);
            this.increaseHeroTrainings(hero);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}