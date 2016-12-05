import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        int i=0;
        double wrongAnswers = 1;
        while (true) {
            if(wrongAnswers==0)break;
            wrongAnswers = 0;
            //Collections.shuffle(images);
            for (Image image : images) {
                for(NeuralNetwork network:networks){
                    network.trainNetwork(image,solutions);
                }
                int answer=testResults(image);
                if (answer != solutions.get(image.getLabel())) {
                    wrongAnswers++;
                }
            }
            i++;
            System.out.println("WRONG "+wrongAnswers);
           // wrongAnswers = wrongAnswers / images.size();
        }
        System.out.println("ITERATIONS "+i);
    }

    public void test(ArrayList<Image> images){
        for(Image image: images){
            System.out.println(image.getLabel()+" "+testResults(image));
        }
    }



    public int testResults(Image image){
        double happy=networks.get(0).activation(image);
        double sad=networks.get(1).activation(image);
        double mischievous=networks.get(2).activation(image);
        double mad=networks.get(3).activation(image);
/*
        System.out.println("image 1 = " + networks.get(0).activation(image));
        System.out.println("image 2 = " + networks.get(1).activation(image));
        System.out.println("image 3 = " + networks.get(2).activation(image));
        System.out.println("image 4 = " + networks.get(3).activation(image));
*/
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
