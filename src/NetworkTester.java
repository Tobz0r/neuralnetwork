import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Tobz0r on 2016-11-30.
 */
public class NetworkTester {

    private final int HAPPY=1;
    private final int SAD=2;
    private final int MISCHIEVOUS=3;
    private final int MAD=4;
    private final int nrOfExpressions=4;
    private ArrayList<NeuralNetwork> networks;
    private ArrayList<Image> images;
    private Hashtable<String,Integer> solutions;

    public NetworkTester(ArrayList<Image> images, Hashtable<String,Integer> solutions){
        this.images=images;
        this.solutions=solutions;
        networks=new ArrayList<>();
        for(int i=1;i <=nrOfExpressions;i++){
            networks.add(new NeuralNetwork(i));
        }
    }

    public void train(){

    }

    public void testResults(ArrayList<Image> testImages){

    }
}
