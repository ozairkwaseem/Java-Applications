public class BatTest {
    public static void main(String[] args) {
        Bat b = new Bat();
        b.setEnergy(300);
        b.fly(2);
        b.attackTown(3);
        b.eatHumans(2);
        System.out.println(b.displayEnergy());
    }
}
