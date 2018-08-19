package EnumsAndAnnotationsEXC.inferno_infinity.weapons;

public class Axe extends Weapon {
    public Axe(String name) {
        super(name);
        super.setMinDamage(5);
        super.setMaxDamage(10);
        super.setSockets(4);
    }

}
