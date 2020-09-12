public class Bat extends Mammal {


    public void fly(int numberofFlights) {
        System.out.println("The Bat is taking off!!!");
        this.energyLevel= energyLevel - (numberofFlights* 50);

    }
    public void eatHumans(int numberofMeals){
        System.out.println("So well.. never mind. that");
        this.energyLevel= energyLevel + (numberofMeals* 50);
    }

    public void attackTown( int numberofAttacks){
        System.out.println("Wow the town is on FIRE!!!");
        this.energyLevel= energyLevel - (numberofAttacks * 100);
    }

    public void setEnergy(double energyLevel){
        this.energyLevel = energyLevel;
    } 
    public double getEnergy(){
        return energyLevel;
    }
}