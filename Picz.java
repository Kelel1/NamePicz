import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Picz {

    public File dir;    
    
    public Picz (File n) {
        this.dir = n;        
    }

    /** Change name of .png file(s) in folder */
    public void changeName () {

    }

    static final FilenameFilter IMAGE_FILTER = new FilenameFilter(){
    
        @Override
        public boolean accept(File dir, String name) {
            if(name.endsWith("png")) {
                return true;
            }
            return false;
        }
    };

    /** Returns number of pictures in folder */
    public int totlPics() { 
        int count = 0;
        for(File f: dir.listFiles(IMAGE_FILTER)) {
            
            BufferedImage img = null;
            try {
                img = ImageIO.read(f);
                count++;
            } catch (final IOException e) {
                e.printStackTrace();
            }            
        }
        return count;           
    }

    /** Must enter full path at command line
     * /home/usr/Desktop/dir
     */
    public static void main(String[] args) {

        File fileName = new File(args[0]);
                

        Picz poolPix = new Picz(fileName);       
        
        System.out.println(poolPix.totlPics());
    
        
     }
}