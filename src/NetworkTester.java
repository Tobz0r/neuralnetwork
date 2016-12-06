import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

/**
 * Handles the preceptrons, training and writing out the testresults
 * @author dv13tes,dv13trm
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

    /**
     * trains the nodes with given images, will run until there is no
     * wrong return values.
     */
    public void train(){
        double wrongAnswers = 1;
        while (true) {
            if(wrongAnswers==0)break;
            wrongAnswers = 0;
            Collections.shuffle(images);
            for (Image image : images) {
                for(NeuralNetwork network:networks){
                    network.trainNetwork(image,solutions);
                }
                int result=testResults(image);
                if (result != solutions.get(image.getLabel())) {
                    wrongAnswers++;
                }
            }
        }
    }

    /**
     * Runs test for each image and prints result to stdout
     * @param images a list with images
     */
    public void test(ArrayList<Image> images){
        for(Image image: images){
            System.out.println(image.getLabel()+" "+testResults(image));
        }
    }


    /**
     * Compares the activationvalue for each node and choses the highest
     * as the result
     * @param image the image to be tested
     * @return highest acivation value
     */
    public int testResults(Image image){
        double happy=networks.get(0).activation(image);
        double sad=networks.get(1).activation(image);
        double mischievous=networks.get(2).activation(image);
        double mad=networks.get(3).activation(image);
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
        return result;
    }
}
