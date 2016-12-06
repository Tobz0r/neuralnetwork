import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Parser for images
 * @author dv13tes,dv13trm
 */
public class ImageParser {

    /**
     * Parse a image and adds it to a list
     * @param filePath path to the imagefile
     * @return a list of parsed images
     */
    public ArrayList<Image> parseImage(String filePath) {
        ArrayList<Image> images=new ArrayList<>();
        Image face=new Image();
        int lineNumber=0;
        BufferedReader br=null;
        String line=null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    if (face.isFinished()) {
                        images.add(face);
                        face = new Image();
                    }
                } else {
                    if (line.matches("^[0-9 ]+")) {
                        String[] lineNumbers = line.split(" ");
                        for (int i = 0; i < lineNumbers.length; i++) {
                            face.addToFace(Integer.parseInt(lineNumbers[i]), lineNumber, i);
                        }
                        lineNumber++;
                    } else {
                        face.setLabel(line);
                        lineNumber = 0;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return images;
    }

    /**
     * Parses solutions and adds them to a table
     * @param filePath path to the solutions
     * @return hashtable with solutions
     */
    public Hashtable<String, Integer> parseSolutions(String filePath) {
        Hashtable<String, Integer> solutions = new Hashtable<>();
        BufferedReader br=null;
        String line=null;
        try{
            br=new BufferedReader(new FileReader(filePath));
            while((line=br.readLine())!=null){
                if (!line.startsWith("#") || !line.trim().isEmpty()) {
                    String[] lines=line.split(" ");
                    if(lines.length==2) {
                        solutions.put(lines[0], Integer.parseInt(lines[1]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return solutions;
    }

}
