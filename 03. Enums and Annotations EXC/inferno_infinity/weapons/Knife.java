package EnumsAndAnnotationsEXC.inferno_infinity.weapons;

public class Knife extends Weapon {
    public Knife(String name) {
        super(name);
        super.setMinDamage(3);
        super.setMaxDamage(4);
        super.setSockets(2);
    }
}
