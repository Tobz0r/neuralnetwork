import java.util.ArrayList;
import java.util.Hashtable;

public class Faces {
 //   java Expresseions training-A.txt facit-A.txt test-B.txt > result.txt

    public static void main(String[] args) {
        ImageParser fileReader=new ImageParser();
        ArrayList<Image> training=fileReader.parseImage(args[0]);
        ArrayList<Image> testing=fileReader.parseImage(args[2]);
        Hashtable<String, Integer> solutions=fileReader.parseSolutions(args[1]);
        NetworkTester tester=new NetworkTester(training,solutions);
        tester.train();
        tester.test(testing);
    }

}
