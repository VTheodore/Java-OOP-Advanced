package EnumsAndAnnotations.p03;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffeesSold;

    private int coins;

    public CoffeeMachine() {
        this.coffeesSold = new ArrayList<>();
    }

    public void insertCoin(String coin){
        this.coins += Enum.valueOf(Coin.class, coin.toUpperCase()).getC();
    }

    public void buyCoffee(String size, String type){
        Coffee coffee = new Coffee(size, type);

        if (this.coins > coffee.getSize().getC()){
            this.coffeesSold.add(coffee);
            this.coins = 0;
        }
    }

    public Iterable<Coffee> coffeesSold(){
        return this.coffeesSold;
    }
}
