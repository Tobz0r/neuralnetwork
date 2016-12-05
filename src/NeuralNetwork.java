import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;

/**
 * MAINFUNKTIONISH
 */

public class NeuralNetwork {

    private double[][] trainingNetwork;
    private final int IMG_SIZE=20;
    private int expression;
    private final double LR=0.7;

    public NeuralNetwork(int expression){
        this.expression=expression;
        trainingNetwork = new double[IMG_SIZE][IMG_SIZE];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for(int i=0; i < IMG_SIZE; i++){
            for(int j =0; j < IMG_SIZE; j++){
                trainingNetwork[i][j]=(Math.random() / 10.0) + 0.01;
            }
        }
    }



    /**
     * Tar in en arraylista med bilder, sedan trÃ¤nar
     * nÃ¤tverket att kÃ¤nna igen bilder mha facit
     */

    public void trainNetwork(Image image, Hashtable<String, Integer> solutions){
        double y; //desired output
        double x; //The input from node
        double e; // Output error
        y=solutions.get(image.getLabel())==expression?1:0;
        e = generateError(y,activation(image));
        for (int j = 0; j < trainingNetwork.length; j++) {
            for (int k = 0; k < trainingNetwork[0].length; k++) {
                x = (image.getMatrix()[j][k]/31);
                trainingNetwork[j][k] +=generateDeltaW(LR, e, x);
            }
        }

    }


    private double generateDeltaW(double LR, double e, double x) {
        return LR*e*x;
    }


    private double sigmoid(double x){
        return 1/(1+Math.pow(Math.E, -(x)));
    }

    private double generateError(double y, double a){
        return y-a;
    }



    public double activation(Image image) {
        double sum = 0;
        double[][] imageMatrix = image.getMatrix();
        for (int i = 0; i < imageMatrix.length; i++) {
            for (int j = 0; j < imageMatrix[0].length; j++) {
                sum += ((imageMatrix[i][j]/31) * trainingNetwork[i][j]);
            }
        }
        double activation=sigmoid(sum/400);
        return activation;
    }
}
