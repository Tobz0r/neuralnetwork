import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ImageParser fileReader=new ImageParser();
        ArrayList<Image> jeb=fileReader.parseImage("training.txt");
        for(Image image:jeb){
            image.printMatrix();
            System.out.println("Next");
        }
        System.out.println("JEBANE!");
    }
}
