/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devoir2_8inf808_romanet_agavios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Malomek
 */
public class Data {
    
    public String name;
    public int machinesnumber;//nombre machines
    public int jobsnumber;//nombre jobs
    public List<List<Integer>> machinesrequirements;//liste des demandes des différents jobs pour chaque machine
    
    
    public Data(String filepath) throws IOException{
        
        machinesrequirements = new ArrayList<List<Integer>>();
        List<String> lines = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
        //printLines(lines);
        String numbers[] = filepath.split("tai");
        this.jobsnumber=Integer.parseInt(numbers[1].split("_")[0]);
        this.machinesnumber=Integer.parseInt(numbers[1].split("_")[1].split(".txt")[0]);
       for(int i=3;i<4+machinesnumber;i++){
           List machine = new ArrayList();
           String[] linesplit = lines.get(i).split(" ");
           for(int j=1;j<linesplit.length;j++){
               if(linesplit[j].matches("-?\\d+(\\.\\d+)?")){
                   // System.out.println(linesplit[j]);
               machine.add(Integer.parseInt(linesplit[j]));
               }
           }
           machinesrequirements.add(machine);
       }
       name = "tai"+Integer.toString(jobsnumber)+"_"+Integer.toString(machinesnumber)+".0";
       
       //System.out.println("RESULT;  "+machinesrequirements.get(0).get(0));
    }
    
    public Data(String filepath, int jeudedonnees) throws IOException{
        
        if(jeudedonnees==0){
            Data d = new Data(filepath);
            this.jobsnumber=d.jobsnumber;
            this.machinesnumber=d.machinesnumber;
            this.machinesrequirements = d.machinesrequirements;
            this.name = d.name;
            return;
        }
        
        machinesrequirements = new ArrayList<List<Integer>>();
        List<String> lines = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
        //printLines(lines);
        String numbers[] = filepath.split("tai");
        this.jobsnumber=Integer.parseInt(numbers[1].split("_")[0]);
        this.machinesnumber=Integer.parseInt(numbers[1].split("_")[1].split(".txt")[0]);
       for(int i=3+jeudedonnees*machinesnumber+3;i<4+machinesnumber+jeudedonnees*machinesnumber+3;i++){
           List machine = new ArrayList();
           String[] linesplit = lines.get(i).split(" ");
           for(int j=1;j<linesplit.length;j++){
               if(linesplit[j].matches("-?\\d+(\\.\\d+)?")){
                   // System.out.println(linesplit[j]);
               machine.add(Integer.parseInt(linesplit[j]));
               }
           }
           machinesrequirements.add(machine);
       }
       name = "tai"+Integer.toString(jobsnumber)+"_"+Integer.toString(machinesnumber)+"."+Integer.toString(jeudedonnees);
       
       //System.out.println("RESULT;  "+machinesrequirements.get(0).get(0));
    }
    
    public static void printLines(List<String> lines){
        for(String s : lines){
            System.out.println(s);
        }
    }
    
}
