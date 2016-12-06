import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Imagerepresentation of a face
 * @author dv13trm,dv13tes
 */
public class Image {

    private final int IMG_SIZE=20;
    private String label;
    private double[][] matrix;

    public Image(){
        label=null;
        matrix=new double[IMG_SIZE][IMG_SIZE];
    }

    /**
     * returns the imagelabel
     * @return label with the expression
     */
    public String getLabel(){
        return label;
    }

    /**
     * Adds a label to the image
     * @param label string with a label
     */
    public void setLabel(String label){
        this.label=label;
    }

    /**
     * Adds a pixel to the imagematrix
     * @param value the pixel to the matrix
     * @param i the row-value
     * @param j the column-value
     */
    public void addToFace(int value,int i, int j){
        matrix[i][j]=value;
    }

    /**
     * Checks if the image has been fully added, used when parsing
     * @return true if image is done else false
     */
    public boolean isFinished(){
        return matrix.length==IMG_SIZE && label!=null;
    }

    /**
     * Gives a double-matrix representation of the image
     * @return a matrix
     */
    public double[][] getMatrix(){
        return matrix;
    }


}
