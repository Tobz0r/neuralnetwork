import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tobz0r on 2016-11-21.
 */
public class Image {

    private final int IMG_SIZE=20;
    public String label; //Label Image1, Image2 etc..
    public double[][] matrix;

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

    public void addToFace(double value,int i, int j){
        matrix[i][j]=value;
    }
    public boolean isFinished(){
        return matrix.length==IMG_SIZE && label!=null;
    }

}
