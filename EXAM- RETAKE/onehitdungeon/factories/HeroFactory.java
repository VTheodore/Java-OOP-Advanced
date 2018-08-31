package onehitdungeon.factories;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;
import onehitdungeon.misclellanious.HeroParams;
import onehitdungeon.models.items.ArmorItemImpl;
import onehitdungeon.models.items.OffhandItemImpl;
import onehitdungeon.models.items.WeaponItemImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HeroFactory {
    private static final String HERO_REFERENCE = "onehitdungeon.models.heroes.";

    private static final String WORD_HERO = "Hero";

    public static Hero createHero(String type, String name){
        Hero hero = null;

        try {
            Class<?> heroClass = Class.forName(HERO_REFERENCE + type + WORD_HERO);
            Constructor<?> declaredConstructor = heroClass.getDeclaredConstructor(String.class, WeaponItem.class, OffhandItem.class, ArmorItem.class);
            hero = (Hero) declaredConstructor.newInstance(name, getWeapon(type), getOffhand(type), getArmor(type));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        return hero;
    }

    private static WeaponItem getWeapon(String type) {
        switch (type){
            case HeroParams.PALADIN_TYPE:
                return new WeaponItemImpl(HeroParams.PALADIN_WEAPON_BATTLEPOWER, HeroParams.PALADIN_WEAPON_PRICE_FOR_UPGRADE);
            case HeroParams.MAGE_TYPE:
                return new WeaponItemImpl(HeroParams.MAGE_WEAPON_BATTLEPOWER, HeroParams.MAGE_WEAPON_PRICE_FOR_UPGRADE);
        }

        return null;
    }

    private static OffhandItem getOffhand(String type) {
        switch (type){
            case HeroParams.PALADIN_TYPE:
                return new OffhandItemImpl(HeroParams.PALADIN_OFFHAND_BATTLEPOWER, HeroParams.PALADIN_OFFHAND_PRICE_FOR_UPGRADE);
            case HeroParams.MAGE_TYPE:
                return new OffhandItemImpl(HeroParams.MAGE_OFFHAND_BATTLEPOWER, HeroParams.MAGE_OFFHAND_PRICE_FOR_UPGRADE);
        }

        return null;
    }

    private static ArmorItem getArmor(String type) {
        switch (type){
            case HeroParams.PALADIN_TYPE:
                return new ArmorItemImpl(HeroParams.PALADIN_ARMOR_BATTLEPOWER, HeroParams.PALADIN_ARMOR_PRICE_FOR_UPGRADE);
            case HeroParams.MAGE_TYPE:
                return new ArmorItemImpl(HeroParams.MAGE_ARMOR_BATTLEPOWER, HeroParams.MAGE_ARMOR_PRICE_FOR_UPGRADE);
        }

        return null;
    }

}
