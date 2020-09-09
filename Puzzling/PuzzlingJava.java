import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;
// Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)
public class PuzzlingJava {
    public Integer firstPuzzle() { 
    Integer[] firstArray= {3,5,1,2,7,9,8,13,25,32};
    ArrayList<Integer> secondArray= new ArrayList<Integer>();
    Integer sum = 0;
    for(Integer i =0; i < firstArray.length; i++){
    sum = firstArray[i] + sum;
    if(firstArray[i]>10) secondArray.add(firstArray[i]);
    
}
    System.out.println(sum);
    System.out.println(secondArray);
    return sum;
}
// Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message
public void alphabetshuffler(){
    ArrayList<Character> alphabet= new ArrayList<Character>();
    for(char x = 'a'; x <= 'z'; ++x){
        alphabet.add(x);
    } 
    System.out.println(alphabet);
    Collections.shuffle(alphabet);
    System.out.println(alphabet);
    
}
// Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.
    public void randomNumbers(){
        Random r = new Random();
        ArrayList<Integer> numbers= new ArrayList<>();
        for(Integer x = 55; x<=100; x++){
            numbers.add(x);

        }
        int random = r.nextInt(45);
        System.out.println(numbers.get(random));
        System.out.println(numbers); 
    }

}

