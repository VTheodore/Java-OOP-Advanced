package EnumsAndAnnotationsEXC.inferno_infinity.weapons;

public class Sword extends Weapon {
    public Sword(String name) {
        super(name);
        super.setMinDamage(4);
        super.setMaxDamage(6);
        super.setSockets(3);
    }
}
