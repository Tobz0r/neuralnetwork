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
    private double activation;
    private final double LR=0.15;

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
     * Tar in en arraylista med bilder, sedan tränar
     * nätverket att känna igen bilder mha facit
     */

    public void trainNetwork(Image image, Hashtable<String, Integer> solutions){
        double y; //desired output
        double x; //The input from node
        double e; // Output error
        //  Collections.shuffle(images); //shuffle randomly list
        y=solutions.get(image.getLabel())==expression?1:0;
        double activation=activation(image);
        activation=activation>0.5?1:0;
        e = generateError(y,activation);
        for (int j = 0; j < trainingNetwork.length; j++) {
            for (int k = 0; k < trainingNetwork[0].length; k++) {
                x = (image.getMatrix()[j][k]/31);
                trainingNetwork[j][k] +=generateDeltaW(LR, e, x);
            }
        }
        activation(image);

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
        int[][] imageMatrix = image.getMatrix();
        for (int i = 0; i < imageMatrix.length; i++) {
            for (int j = 0; j < imageMatrix[0].length; j++) {
                System.out.println((imageMatrix[i][j]/31));
                sum += ((imageMatrix[i][j]/31) * trainingNetwork[i][j]);
                //System.out.println("sum= " +sum);
            }
        }
        activation=sigmoid(sum);
       // System.out.println("activation " + activation);
        return activation;
    }

    public double getActivation(){
        return activation;
    }



}

/*
http://softwareengineering.stackexchange.com/questions/289622/is-the-output-of-a-neural-net-supposed-to-have-had-the-activation-function-appli
https://www.quora.com/What-is-the-role-of-the-activation-function-in-a-neural-network
https://www8.cs.umu.se/kurser/5DV121/HT15/slides/10%20-%20ANN.pdf
 */