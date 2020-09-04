public class StringManipulator{
    public String manipulator(String trimmedGreeting){ 
    String Greeting = trimmedGreeting.trim();
    System.out.println(Greeting);
    return Greeting;

}

public int indexManipulator(String y){

char letter = 'l';
int a = y.indexOf(letter);
System.out.println("The index of l is " + a);
return a;
}
}








