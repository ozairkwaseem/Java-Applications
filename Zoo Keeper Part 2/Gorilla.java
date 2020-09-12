public class Gorilla extends Mammal {

    public void throwSomething() {
        System.out.println("The Gorilla has thrown something");
        this.energyLevel = energyLevel;
        energyLevel = energyLevel - 5;

    }

    public void eatBanana() {
        System.out.println("The Gorilla's is satisfied now!");
        this.energyLevel = energyLevel;
        energyLevel = energyLevel + 10;

    }

    public void climb() {
        System.out.println("The Gorilla has climbed a tree and is tired now!");
        this.energyLevel = energyLevel;
        energyLevel = energyLevel - 10;

    }

}