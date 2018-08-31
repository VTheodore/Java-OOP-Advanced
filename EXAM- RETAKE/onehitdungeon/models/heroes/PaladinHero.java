package onehitdungeon.models.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;
import onehitdungeon.misclellanious.ManagerMessages;

public class PaladinHero extends BaseHero {
    public PaladinHero(String name, WeaponItem weapon, OffhandItem offhand, ArmorItem armor) {
        super(name, weapon, offhand, armor);
    }

    @Override
    public Integer getTotalBattlePower() {
        return ((super.getWeapon().getBattlePower() + super.getArmor().getBattlePower() + super.getOffhand().getBattlePower()) * 4) / 9;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(String.format("* Mace - %d (BP)", super.getWeapon().getBattlePower())).append(System.lineSeparator());
        sb.append(String.format("* Shield - %d (BP)", super.getOffhand().getBattlePower())).append(System.lineSeparator());
        sb.append(String.format("* Cuirass - %d (BP)", super.getArmor().getBattlePower())).append(System.lineSeparator());
        sb.append(ManagerMessages.LINE_SPLITTER).append(System.lineSeparator());
        sb.append(String.format("Gold: %.2f", super.getGold())).append(System.lineSeparator());
        sb.append(String.format("Upgrade cost: %.2f", super.getTotalPriceForUpgrade()));

        return sb.toString();
    }
}
