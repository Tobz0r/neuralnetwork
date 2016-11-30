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
        for(NeuralNetwork network:networks){
            network.trainNetwork(images,solutions);
        }
    }

    public void testResults(ArrayList<Image> testImages){
        for(Image image:testImages){
            double happy=networks.get(0).activation(image);
            double sad=networks.get(1).activation(image);
            double mischievous=networks.get(2).activation(image);
            double mad=networks.get(3).activation(image);
            System.out.println(happy+ " "+sad+" " + mischievous+" "+ mad+" ");
            int result=HAPPY;
            double highestValue=happy;
            if(sad>highestValue){
                result=SAD;
                highestValue=sad;
            }
            if(mischievous>highestValue){
                result=MISCHIEVOUS;
                highestValue=mischievous;
            }
            if(mad>highestValue){
                result=MAD;
            }
            System.out.println(image.getLabel()+" "+result);
        }
    }
}
