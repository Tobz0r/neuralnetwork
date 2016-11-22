import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tobz0r on 2016-11-21.
 */
public class Image {

    private final int IMG_SIZE=20;
    private String label; //Label Image1, Image2 etc..
    private int[][] matrix;

    public Image(){
        label=null;
        matrix=new int[IMG_SIZE][IMG_SIZE];
    }

    public String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label=label;
    }

    public void addToFace(int value,int i, int j){
        matrix[i][j]=value;
    }
    public boolean isFinished(){
        return matrix.length==IMG_SIZE && label!=null;
    }

    public void printMatrix(){
        try {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }catch (NullPointerException e){}
    }

}
