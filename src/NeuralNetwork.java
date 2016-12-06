import java.util.Hashtable;

/**
 * The class for the trainingnodes
 * @author dv13tes,dv13trm
 */
public class NeuralNetwork {

    private double[][] trainingNetwork;
    private final int IMG_SIZE=20;
    private int expression;
    private final double LR=0.7;

    public NeuralNetwork(int expression){
        this.expression=expression;
        trainingNetwork = new double[IMG_SIZE][IMG_SIZE];
        for(int i=0; i < IMG_SIZE; i++){
            for(int j =0; j < IMG_SIZE; j++){
                trainingNetwork[i][j]=(Math.random()/10.0)+0.01;
            }
        }
    }


    /**
     * Trains the node with a image
     * @param image an image with an expression to be trained
     * @param solutions table with the expressiontype of the image
     */
    public void trainNetwork(Image image, Hashtable<String, Integer> solutions){
        double output; //desired output
        double pixel; //The input from node
        double error; // Output error
        output=solutions.get(image.getLabel())==expression?1:0;
        error = generateError(output,activation(image));
        for (int j = 0; j < trainingNetwork.length; j++) {
            for (int k = 0; k < trainingNetwork[0].length; k++) {
                pixel = (image.getMatrix()[j][k]/31);
                trainingNetwork[j][k] += deltaW(error, pixel);
            }
        }

    }

    /**
     * generates the difference between perceptron and image
     * @param e output error
     * @param x imagenode pixel
     * @return a delta value
     */
    private double deltaW(double e, double x) {
        return LR*e*x;
    }

    /**
     *  Sigmoid function used by acitivation
     * @param x value for sigmpid
     * @return acitvationvalue
     */
    private double sigmoid(double x){
        return 1/(1+Math.pow(Math.E, -(x)));
    }

    /**
     * Generated outputerror for the node
     * @param y desired output
     * @param a acitvationvalue for node
     * @return output error
     */
    private double generateError(double y, double a){
        return y-a;
    }


    /**
     * Activationfunction used to calculate the classification of a image
     * @param image the image to be calculated
     * @return sigmoidvalue of the image
     */
    public double activation(Image image) {
        double sum = 0;
        double[][] imageMatrix = image.getMatrix();
        for (int i = 0; i < imageMatrix.length; i++) {
            for (int j = 0; j < imageMatrix[0].length; j++) {
                sum += ((imageMatrix[i][j]/31) * trainingNetwork[i][j]);
            }
        }
        return sigmoid(sum/400);
    }
}
