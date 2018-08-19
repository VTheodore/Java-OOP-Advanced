package EnumsAndAnnotationsEXC.inferno_infinity.weapons;

import EnumsAndAnnotationsEXC.inferno_infinity.Gem;

public abstract class Weapon implements Comparable<Weapon>{
    private String name;

    private int minDamage;

    private int maxDamage;

    private Gem[] sockets;

    private int strength;

    private int agility;

    private int vitality;

    public Weapon(String name) {
        this.name = name;
    }

    protected void setMinDamage(int minDamage){
        this.minDamage = minDamage;
    }

    protected void setMaxDamage(int maxDamage){
        this.maxDamage = maxDamage;
    }

    protected void setSockets(int numberOfSockets){
        this.sockets = new Gem[numberOfSockets];
    }

    public void addGem(int socketIndex, String gemType){
        Gem gem = Gem.valueOf(gemType.toUpperCase());

        if (socketIndex >= 0 && socketIndex < this.sockets.length){
            this.sockets[socketIndex] = gem;
        }
    }

    public void removeGem(int socketIndex){
        if (socketIndex >= 0 && socketIndex < this.sockets.length && this.sockets[socketIndex] != null){
            Gem gem = this.sockets[socketIndex];
            this.sockets[socketIndex] = null;
        }
    }

    public void updateStats(){
        for (Gem gem : this.sockets) {
            if (gem != null){
                this.strength += gem.getStrength();
                this.agility += gem.getAgility();
                this.vitality += gem.getVitality();

                this.minDamage += gem.getStrength() * 2 + gem.getAgility();
                this.maxDamage += gem.getStrength() * 3 + gem.getAgility() * 4;
            }
        }
    }

    public double getLevel(){
        return (this.minDamage + this.maxDamage) / 2.0 + this.strength + this.agility + this.vitality;
    }

    @Override
    public int compareTo(Weapon o) {
        if (Double.compare(this.getLevel(), o.getLevel()) > 0){
            return 1;
        }else if (Double.compare(this.getLevel(), o.getLevel()) < 0){
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)", this.name, this.minDamage, this.maxDamage, this.strength, this.agility, this.vitality, this.getLevel());
    }
}
