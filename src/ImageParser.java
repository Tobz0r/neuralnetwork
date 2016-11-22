import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by sejiaw on 2016-10-13.
 */
public class ImageParser {

    public ArrayList<Image> parseImage(String filePath) {
        /*Lista att spara alla ansikten i*/
        ArrayList<Image> images=new ArrayList<>();
        Image face=new Image();
        int lineNumber=0;
        BufferedReader br=null;
        String line=null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                //I början startar ju varje ansiktsfil med # och sen en ny rad så kollar dom där så att den hoppar över
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    if (face.isFinished()) {
                        images.add(face); /* lägg till den färdiga matrisen i listan och gå vidare till nästa ansikte*/
                        face = new Image();
                    }
                } else {
                    /* kollar att det bara finns nummer och blankspace på raden
                    http://stackoverflow.com/questions/10575624/java-string-see-if-a-string-contains-only-numbers-and-not-letters
                     */
                    if (line.matches("^[0-9 ]+")) {
                        /*ta bort alla mellanslag så det bara blir siffor*/
                        String[] lineNumbers = line.split(" ");
                        /* lägger till varje rad i en matris*/
                        for (int i = 0; i < lineNumbers.length; i++) {
                            face.addToFace(Integer.parseInt(lineNumbers[i]), lineNumber, i);
                        }
                        lineNumber++;
                    } else {
                        /*börjar inte raden med #, är blank eller ett nummer så är det 100% bildens namn(image1,image2 etc..)*/
                        face.setLabel(line);
                        lineNumber = 0;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return images;
    }

    /* Min tanke här här att ta facitfilen och lägga till i en hashtabell med imagename som nyckel
        och svaret som värde
        T.EX

        KEY      VALUE
        Image1      2
        Image2      1
        Image3      4
        Image4      4


     */
    public Hashtable<String, Integer> parseFacit(String failePath) {
        Hashtable<String, Integer> facit = new Hashtable<>();


        return facit;
    }

}
