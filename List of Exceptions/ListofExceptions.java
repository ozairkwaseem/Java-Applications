import java.util.ArrayList;
public class ListofExceptions{
    
    public static void main(String[] args) {
        try{   
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("11");
        myList.add("My Name is Ozair");
        myList.add(44);
        myList.add("I am learning about Exceptions in Java");

        for(int i = 0; i < myList.size(); i++) {
            Integer castedValue = (Integer) myList.get(i);
        }} catch(Exception e) {
            System.out.println("There is an exception");
        }
    }
}