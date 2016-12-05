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
    private double[][] matrix;

    public Image(){
        label=null;
        matrix=new double[IMG_SIZE][IMG_SIZE];
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

    public double[][] getMatrix(){
        return matrix;
    }

    public void normalizeMatrix(){
        for(int i=0;i < IMG_SIZE;i++){
            for(int j=0;j<IMG_SIZE;j++){
                matrix[i][j]/=31;
            }
        }
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

    // Roterar matrisen 90 grader clockwise x antal gånger
    public void rotateImage(int nrOfRotations) {
        double[][] rotationArr = new double[20][20];

        for(int i=0; i < nrOfRotations;i++) {
            for (int j=0; j < matrix.length;j++) {
                for (int k=0; k < matrix[0].length;k++) {
                    rotationArr[k][matrix.length-1-j]=matrix[j][k];
                }
            }
        }
        matrix=rotationArr;
    }

    /**
     * Slits the matrix into a submatrix
     * @param firstX the first X-index
     * @param firstY the first Y-index
     * @param lastX
     * @param lastY
     * @return
     */
    public double[][] splitMatrix(int firstX, int firstY, int lastX, int lastY) {
        double[][] retArr = new double[firstX+lastX][firstY+lastY];
        int row=0;
        int column=0;
        for (int i=firstX; i<lastX;i++) {
            for (int j=firstY; j<lastY;j++) {
                retArr[row][column] = matrix[i][j];
                column++;
            }
            column=0;
            row++;
        }

        return retArr;
    }

}
