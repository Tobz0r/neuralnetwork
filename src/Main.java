import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ImageParser fileReader=new ImageParser();
        ArrayList<Image> jeb=fileReader.parseImage("training.txt");
        jeb.get(0).printMatrix();
        System.out.println("JEBANE!");
    }
}
