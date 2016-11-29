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

    public NeuralNetwork(){
        trainingNetwork = new double[IMG_SIZE][IMG_SIZE];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for(int i=0; i < 20; i++){
            for(int j =0; j < 20; j++){
                trainingNetwork[i][j] = Math.abs(rand.nextDouble());
            }

        }
        //testa ba skriva ut

     /*   for(int i=0; i < 20; i++){
            for(int j =0; j < 20; j++){
                System.out.print(trainingNetwork[i][j]+ " ");
            }
            System.out.println();
        } */

    }



    /**
     * Tar in en arraylista med bilder, sedan tränar
     * nätverket att känna igen bilder mha facit
     * @param images
     */
    public void trainNetwork(ArrayList<Image> images, Hashtable<String, Integer> solutions){
        int y; //desired output
        int x; //The input from node
        double LR =1 ; //Learning rate 1 is temporary
        double e; // Output error
        double wd; //delta w
        Collections.shuffle(images); //shuffle randomly list
        for(int i =0; i < images.size() ;i++ ){
            y=solutions.get(images.get(i).getLabel());
            e = generateError(y,activation(images.get(i)));
            for (int j = 0; j < trainingNetwork.length; j++) {
                for (int k = 0; k < trainingNetwork[0].length; k++) {
                    x = images.get(i).getMatrix()[j][k];
                    //generate learning rate?
                    LR = generateLearningRate();
                    if(LR < 1){
                        //Learn slowly and convergence takes forever
                    }else if(LR > 1){
                        //Can make changes that are drastic
                    }else{
                        //Learning rate is fine? do stuff?
                        LR=0.5;
                        wd = generateDeltaW(LR, e, x);
                        trainingNetwork[j][k] +=wd;
                    }
                    //  System.out.println(x);
                }
            }
            // System.out.print(y);
            //System.out.println(i+1);
        }
    }


    private double generateDeltaW(double LR, double e, int x) {
        return LR*e*x;
    }


    private double sigmoid(double x){
        return (1 / (1 + Math.exp(-x)));
    }

    private double generateError(int y, double a){
        return y-a;
    }
    private double generateLearningRate(){
        double newLR = 1;
        //fixa en learning rate??
        return newLR;
    }

    public double activation(Image image){
        double sum=0;
        int[][] imageMatrix=image.getMatrix();
        for(int i=0; i < imageMatrix.length;i++){
            for(int j=0; j < imageMatrix[0].length;j++){
                sum+=(imageMatrix[i][j]*trainingNetwork[i][j]);
            }
        }
        double activation=sum/(imageMatrix.length*imageMatrix[0].length);
        return activation;
      /*  System.out.println(activation+" EFTER");
        if(activation<.25){
            return 1; //HAPPY
        }else if(activation<.5){
            return 2; //SAD
        }
        else if(activation<.75){
            return 3; //MISCHIEVOUS
        }
        else if(activation<=1){
            return 4; //MAD
        }
        return 0; //fail?*/
    }

    public void testNetwork(ArrayList<Image> images){
        System.out.println("#Testresults");
        int result=0;
        for(Image image:images){
            System.out.println(image.getLabel()+" "+activation(image));
        }
    }


}

/*
http://softwareengineering.stackexchange.com/questions/289622/is-the-output-of-a-neural-net-supposed-to-have-had-the-activation-function-appli
https://www.quora.com/What-is-the-role-of-the-activation-function-in-a-neural-network
https://www8.cs.umu.se/kurser/5DV121/HT15/slides/10%20-%20ANN.pdf
 */