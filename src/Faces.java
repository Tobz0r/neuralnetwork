import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Main file for the neural network
 * A network will be trained with images and answers.
 * Then be tested on a file with new "faces".
 * This test will determine how well the neural network works.
 * @author dv13trm, dv13tes
 */
public class Faces {
 //   java Faces training-A.txt facit-A.txt test-B.txt > result.txt

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
