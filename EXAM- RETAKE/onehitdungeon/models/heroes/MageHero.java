package onehitdungeon.models.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;
import onehitdungeon.misclellanious.ManagerMessages;

public class MageHero extends BaseHero {
    public MageHero(String name, WeaponItem weapon, OffhandItem offhand, ArmorItem armor) {
        super(name, weapon, offhand, armor);
    }

    @Override
    public Integer getTotalBattlePower() {
        return ((super.getWeapon().getBattlePower() + super.getArmor().getBattlePower() - super.getOffhand().getBattlePower()) * 3) / 4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(String.format("* Staff - %d (BP)", super.getWeapon().getBattlePower())).append(System.lineSeparator());
        sb.append(String.format("* Orb - %d (BP)", super.getOffhand().getBattlePower())).append(System.lineSeparator());
        sb.append(String.format("* Cape - %d (BP)", super.getArmor().getBattlePower())).append(System.lineSeparator());
        sb.append(ManagerMessages.LINE_SPLITTER).append(System.lineSeparator());
        sb.append(String.format("Gold: %.2f", super.getGold())).append(System.lineSeparator());
        sb.append(String.format("Upgrade cost: %.2f", super.getTotalPriceForUpgrade()));

        return sb.toString();
    }
}
