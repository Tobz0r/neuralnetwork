import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * MAINFUNKTIONISH
 */

public class NeuralNetwork {

    private int[][] trainingNetwork;

    public NeuralNetwork(){
        trainingNetwork = new int[20][20];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for(int i=0; i < 20; i++){
            for(int j =0; j < 20; j++){
                Integer r = rand.nextInt(); //ändra 100 till högre för högre tal osv
                trainingNetwork[i][j] = Math.abs(r);
            }

        }
        //testa ba skriva ut
        
        for(int i=0; i < 20; i++){
            for(int j =0; j < 20; j++){
                System.out.print(trainingNetwork[i][j]+ " ");
            }
            System.out.println();
        }

    }



    /**
     * Tar in en arraylista med bilder, sedan tränar
     * nätverket att känna igen bilder mha facit
     * @param images
     */
    public void train(ArrayList images, Hashtable solutions){
        while(true){
            System.out.println("eliashej");
        }
    }


}

/*
http://softwareengineering.stackexchange.com/questions/289622/is-the-output-of-a-neural-net-supposed-to-have-had-the-activation-function-appli
https://www.quora.com/What-is-the-role-of-the-activation-function-in-a-neural-network
https://www8.cs.umu.se/kurser/5DV121/HT15/slides/10%20-%20ANN.pdf
 */