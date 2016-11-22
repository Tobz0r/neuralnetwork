import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        ImageParser fileReader=new ImageParser();
        ArrayList<Image> training=fileReader.parseImage("training.txt");
        Hashtable<String, Integer> solutions=fileReader.parseSolutions("training-facit.txt");
        NeuralNetwork jebjeb = new NeuralNetwork();

        System.out.println("JEBANE!");
    }
}
