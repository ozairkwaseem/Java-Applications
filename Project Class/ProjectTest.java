public class ProjectTest{  
public static void main(String[] args) {
    Project pitch = new Project();
    pitch.elevatorPitch("Car iPhone App. ", "This app shows you the latest electric vehicles.");
    pitch.setName("Socccer Android App: ");
    pitch.getName();
    pitch.setDescription("This is a soccer video game.");
    pitch.getDescription();
    System.out.println(pitch.name+ pitch.description);

}}