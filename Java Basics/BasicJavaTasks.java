import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicJavaTasks {

    public void PrintLoops() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    public void PrintEvenLoops() {
        for (int i = 1; i <= 255; i++) {

            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public void PrintLoopsSum() {
        int sum = 0;
        for (int i = 0; i <= 255; i++) {
            sum = sum+ i;
            System.out.println("New number: " + i + " Sum:" + sum);
        }
    }

public void BasicArrays() {
    int[] basicArray = {1,3,5,7,9,13};
    for(int i=0; i < basicArray.length ; i++){
        System.out.println(basicArray[i]);
    }

}
public void BasicArraysMax() {
    int[] aa = {1,3,5,7,9,13,77,-1,-3,-5,-7,-9,-13};
    int largest = aa[0];
    for(int y = 0; y < aa.length; y++){
        if(aa[y] > largest) largest = aa[y];

    }    
    System.out.println("The largest value is " + largest);

}
public void BasicArraysMin() {
    List<Integer> a = Arrays.asList(1,-155,3,5,7,9,13,77,-1,-3,-5,-7,-9,-13);
    Integer min = Collections.min(a);
    System.out.println(min);    

}
public void BasicArraysAvg() {
    int[] b = {1,-155,3,5,7,9,13,77,-1,-3,-5,-7,-9,-13};
    for(int x =0; x <= b.length; x++){
        int sum = x;
        int avg = sum/ b.length;
    }

    System.out.println(avg);    

}

}