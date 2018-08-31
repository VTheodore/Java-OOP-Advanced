package onehitdungeon.models.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

public abstract class BaseHero implements Hero {
    private static final Double BASE_GOLD = 0D;

    private String name;

    private WeaponItem weapon;

    private OffhandItem offhand;

    private ArmorItem armor;

    private Double gold;

    private int trainedTimes;

    protected BaseHero(String name, WeaponItem weapon, OffhandItem offhand, ArmorItem armor) {
        this.name = name;
        this.weapon = weapon;
        this.offhand = offhand;
        this.armor = armor;
        this.gold = BASE_GOLD;
    }

    @Override
    public String getHeroClass() {
        return this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length() - 4);
    }

    @Override
    public Double getGold() {
        return this.gold;
    }

    @Override
    public void earnGold(Double gold) {
        this.gold += gold;
    }

    @Override
    public void payGold(Double gold) {
        this.gold -= gold;
    }

    @Override
    public WeaponItem getWeapon() {
        return this.weapon;
    }

    @Override
    public OffhandItem getOffhand() {
        return this.offhand;
    }

    @Override
    public ArmorItem getArmor() {
        return this.armor;
    }


    @Override
    public Double getTotalPriceForUpgrade() {
        return this.weapon.getPriceForUpgrade() + this.offhand.getPriceForUpgrade() + this.armor.getPriceForUpgrade();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - Lvl. %d %s", this.getName(), this.trainedTimes + 1, this.getHeroClass())).append(System.lineSeparator());

        return sb.toString();
    }
}
