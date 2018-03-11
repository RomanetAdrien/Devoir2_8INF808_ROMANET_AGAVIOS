/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devoir2_8inf808_romanet_agavios;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Malomek
 */
public class Devoir_II_8INF808_ROMANET_AGAVIOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String path = "C:\\Users\\Malomek\\Documents\\NetBeansProjects\\Devoir28INF808ROMANETAGAVIOS\\src\\devoir2_8inf808_romanet_agavios\\data\\";
        try {
            testPalmer(path+"tai20_5.txt",0);
            testPalmer(path+"tai20_5.txt",1);
            testPalmer(path+"tai20_10.txt",0);
            testPalmer(path+"tai20_10.txt",1);
            testPalmer(path+"tai50_5.txt",0);
            testPalmer(path+"tai50_5.txt",1);
            testPalmer(path+"tai50_10.txt",0);
            testPalmer(path+"tai50_10.txt",1);
            testPalmer(path+"tai50_20.txt",0);
            testPalmer(path+"tai50_20.txt",1);
            testPalmer(path+"tai100_5.txt",0);
            testPalmer(path+"tai100_5.txt",1);
            testPalmer(path+"tai100_10.txt",0);
            testPalmer(path+"tai100_10.txt",1);
            testPalmer(path+"tai100_20.txt",0);
            testPalmer(path+"tai100_20.txt",1);
            /*Data data1 = new Data(path+"tai100_10.txt");
            Palmer resolution1 = new Palmer(data1);
            resolution1.printSolution();
            Data data2 = new Data(path+"tai100_10.txt",1);
            Palmer resolution2 = new Palmer(data2);
            resolution2.printSolution();*/

        } catch (IOException ex) {
            Logger.getLogger(Devoir_II_8INF808_ROMANET_AGAVIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void testPalmer(String file, int jeudedonnees) throws IOException{
        Data data = new Data(file,jeudedonnees);
        Palmer resolution = new Palmer(data);
        resolution.printSolution();
       
    }
    
  
}
