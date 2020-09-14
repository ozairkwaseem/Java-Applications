public class Ninja extends Human{
    public Ninja(){
        this.stealth= 10;
    }
    public void steal(Human otherHuman){
        otherHuman.health -= this.stealth;
        this.health += this.stealth;
    }

    public void runAway(){
        Ninja.health -= 10;
    }
}