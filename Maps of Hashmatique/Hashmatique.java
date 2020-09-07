import java.util.HashMap;
import java.util.Map;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Yesterday", "All my troubles seemed so far away");
        trackList.put("Here Comes the Sun", "Here comes the sun, do, dun, do Here comes the sun, do, dun, do, do");
        trackList.put("Good Day Sunshine","I need to laugh, and when the sun is out");
        trackList.put("Let It Be","When I find myself in times of trouble" );
        String trackOne = trackList.get("Yesterday");
        String trackTwo = trackList.get("Here Comes the Sun");
        String trackThree = trackList.get("Good Day Sunshine");
        String trackFour = trackList.get( "Let It Be");
        System.out.println( "Yesterday " + trackOne);
        for (String songs : trackList.keySet()){
            System.out.println("Track: " + songs + trackList.get(songs));
        }
    }
}