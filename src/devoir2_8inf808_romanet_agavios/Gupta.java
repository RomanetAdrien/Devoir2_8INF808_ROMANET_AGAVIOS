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
public class Gupta extends Regle{
    
    public List<Float> heuristiques;
    public List<Integer> e;
    
    public Gupta(Data data) {
        super(data);
        heuristiques= new ArrayList();
        e = new ArrayList();
        resoud();
    }
    
    public void resoud(){
        if(data.machinesnumber==2){
            solution = new Jonhson(data).solution;
            return;
        }
        for(int i=0;i<data.jobsnumber;i++){
            if(data.machinesrequirements.get(0).get(i)<data.machinesrequirements.get(data.machinesnumber-1).get(i)){
                e.add(1);
            }
            else{
                e.add(-1);
            }
            heuristiques.add((float)e.get(i)/pMinimum(i));
        }
        solution.add(0);
        boolean minimum=true;
        for(int k=1;k<data.jobsnumber;k++){
            for(int j=0;j<solution.size();j++){
                if(heuristiques.get(k)>heuristiques.get(solution.get(j))){
                    solution.add(j,k);
                    j+=solution.size();
                    minimum=false;
                }
            }
            if(minimum){
                solution.add(k);
            }
            minimum=true;
        }
    }
    
    public int pMinimum(int job){
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<data.machinesnumber-1;i++){
            if(data.machinesrequirements.get(i).get(job)+data.machinesrequirements.get(i+1).get(job)<minimum){
                minimum=data.machinesrequirements.get(i).get(job)+data.machinesrequirements.get(i+1).get(job);
            }
        }
        return minimum;
    }
    
}
