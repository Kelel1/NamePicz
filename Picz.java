import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Picz {

    public File dir;  
    static public String fileType; 
     
    
    public Picz (File n, String s) {
        this.dir = n;        
        this.fileType = s;
    }

    /** Change name of file(s) in folder */
    public void changeName () {
        String path = dir.toString();

        // new folder
        File poolPics = new File(path);

        File[] picsArray = dir.listFiles();

        for(int i = 0; i < picsArray.length; i++) {
            File pic = new File(dir + "/" + picsArray[i].getName());
            String originalName = picsArray[i].getName();
            String[] tokens = originalName.split("_");
            String newName = tokens[1];
           // System.out.println(newName);

            pic.renameTo(new File(dir + "/" + newName));
        }

    }

    static final FilenameFilter IMAGE_FILTER = new FilenameFilter(){
        
    
        @Override
        public boolean accept(File dir, String name) {            
            if(name.endsWith(fileType)) {
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
        String fileType = args[1];
                

        Picz poolPix = new Picz(fileName, fileType);       
        
     //   System.out.println(poolPix.totlPics());  
        poolPix.changeName();      
        // String[] s = new String[poolPix.dir.list().length];
        // s = poolPix.dir.list();
       
        // for(int j = 0; j < 5; j++) {
        //     System.out.println(s[j]);
        // }
     }
}