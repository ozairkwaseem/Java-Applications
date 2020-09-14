public class Human {
    public double strength = 3;
    public double intelligence = 3;
    public double stealth = 3;
    public double health = 100;

    public void attack(Human target) {
         target.health = target.health- this.strength;
        
    }

    

}
