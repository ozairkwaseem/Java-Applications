public class Samurai extends Human {
    static int numberOfSamurai= 0;

    public Samurai() {
        this.health = 200;
        numberOfSamurai++;
    }   

    public void deathBlow(Human otherHuman) {
        System.out.println("Your target has been killed");
        otherHuman.health= 0;
        System.out.println("Your Target's health is: " + otherHuman.health);
    }
    public void meditate(){
        this.health += (this.health/2);
    }
    public int howMany(){
        return numberOfSamurai;
    }
    
}
