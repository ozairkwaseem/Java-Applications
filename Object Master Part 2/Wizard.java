public class Wizard extends Human {
    public Wizard(){ 
    this.intelligence = 8;
    this.health = 50;
    }

    public void heal(Human otherHuman){
        otherHuman.health += this.health; 
        System.out.println("Your Target's health is now: " + otherHuman.health);
    }
    public void fireball(Human otherHuman){
        otherHuman.health -= (this.intelligence*3);
    }
}