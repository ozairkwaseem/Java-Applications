public class Human {
    protected double strength = 3;
    protected double intelligence = 3;
    protected double stealth = 3;
    protected double health = 100;

    public void attack(Human target) {
         target.health = target.health- this.strength;
        
    }

    

}
