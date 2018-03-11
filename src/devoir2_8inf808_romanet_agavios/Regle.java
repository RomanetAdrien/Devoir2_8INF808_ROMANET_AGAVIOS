/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devoir2_8inf808_romanet_agavios;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Malomek
 */
public class Regle {
    
    public List<Integer> solution;
    public Data data;
    
    public Regle(Data data){
        this.data=data;
        solution = new ArrayList();
    }
    
    public int calculMakespan(){
        List<List<Integer>> machines = new ArrayList();
        for(int i=0;i<data.machinesnumber;i++){
            machines.add(new ArrayList());
        }
        int totaltemps=0;
        for(int j=0;j<data.jobsnumber;j++){
            totaltemps+=data.machinesrequirements.get(0).get(solution.get(j));
             machines.get(0).add(totaltemps);
            }
        for(int i=1;i<data.machinesnumber;i++){
            totaltemps=machines.get(i-1).get(0)+data.machinesrequirements.get(i).get(solution.get(0));
            machines.get(i).add(totaltemps);
            for(int j=1;j<data.jobsnumber;j++){
                if(totaltemps>=machines.get(i-1).get(j-1)){
                    totaltemps+=data.machinesrequirements.get(i).get(solution.get(j));
                }
                else{
                    totaltemps+=data.machinesrequirements.get(i).get(solution.get(j))+(machines.get(i-1).get(j-1)-totaltemps);
                }
                machines.get(i).add(totaltemps);
            }
        }
      return totaltemps;
    }
    
    public void printSolution(){
        System.out.print("Solution pour "+data.name+" : "+"Makespan:"+calculMakespan()+"  Séquence :");
        for(int i : solution){
            System.out.print(" "+i+" ");
        }
        System.out.println("");
    }
}
