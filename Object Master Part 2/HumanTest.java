public class HumanTest {
    public static void main(String[] args) {
        Human h1 = new Human();
        Human h2 = new Human();
        h1.attack(h2);
        System.out.println(h2.health);
        Samurai s1 = new Samurai();
        Samurai s2 = new Samurai();
        Samurai s3 = new Samurai();

        s1.deathBlow(h2);
        System.out.println(h2.health);
        System.out.println(s1.numberOfSamurai);
        Wizard w1 = new Wizard();
        h2.health = 34;
        w1.heal(h2);
        System.out.println(h2.health);
    }
}