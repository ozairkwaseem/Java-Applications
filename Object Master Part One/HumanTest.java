public class HumanTest {
    public static void main(String[] args) {
        Human h1 = new Human();
        Human h2 = new Human();
        h1.attack(h2);
        System.out.println(h2.health);
                
    }
}