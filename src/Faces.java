import java.util.ArrayList;
import java.util.Hashtable;

public class Faces {
 //   java Expresseions training-A.txt facit-A.txt test-B.txt > result.txt

    public static void main(String[] args) {
        ImageParser fileReader=new ImageParser();
        ArrayList<Image> training=fileReader.parseImage("training-A.txt");
        ArrayList<Image> testing=fileReader.parseImage("test-B.txt");
        Hashtable<String, Integer> solutions=fileReader.parseSolutions("facit-A.txt");
        NetworkTester tester=new NetworkTester(training,solutions);
        tester.train();
        tester.test(testing);
    }

}
