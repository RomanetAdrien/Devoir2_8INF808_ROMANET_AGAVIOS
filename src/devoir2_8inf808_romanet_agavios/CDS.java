/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devoir2_8inf808_romanet_agavios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malomek
 */
public class CDS extends Regle{
    
    public List<Integer> heuristiques1;
    public List<Integer> heuristiques2;
    public List<Jonhson> makespans;
    
    public CDS(Data data) {
        super(data);
        heuristiques1 =new ArrayList();
        heuristiques2 =new ArrayList();
        makespans = new ArrayList();
        resoud();
    }
    
    public void resoud(){
        int sommejob1=0;
        int sommejob2=0;
        for(int i=0;i<data.machinesnumber-1;i++){
            for(int j=0;j<data.jobsnumber;j++){
                for(int k=1;k<=i+1;k++){
                    sommejob1+=data.machinesrequirements.get(k-1).get(j);
                    sommejob2+=data.machinesrequirements.get(data.machinesnumber-k-1).get(j);
                }
                heuristiques1.add(sommejob1);
                heuristiques2.add(sommejob2);
                sommejob1=0;
                sommejob2=0;
            }
            makespans.add(new Jonhson(this.data,heuristiques1,heuristiques2));
        }
        Jonhson minimum =makespans.get(0);
        for(Jonhson j: makespans){
            if(j.makespan<minimum.makespan){
                minimum=j;
            }
        }
        solution=minimum.solution;
        makespan=minimum.makespan;
    }
    
}
