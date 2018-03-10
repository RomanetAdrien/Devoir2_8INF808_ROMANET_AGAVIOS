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
public class Palmer extends Regle{
    
        List<Integer> heuristiques;

    
        public Palmer(Data data){
            super(data);
            heuristiques = new ArrayList();
            this.resoud();
        }
        
        
        public void resoud(){
            System.out.println(data.jobsnumber);
            int heuristique = calculHeuristique(0);
            heuristiques.add(heuristique);
           for(int i=1;i<data.jobsnumber;i++){
               heuristique = calculHeuristique(i);
               heuristiques.add(heuristique);
           }
           solution.add(0);
           boolean maximum = true;
           for(int i=1;i<data.jobsnumber;i++){
               for(int j=0;j<solution.size();j++){
                   if(heuristiques.get(i)<heuristiques.get(solution.get(j))){
                       solution.add(j,i);
                       j+=solution.size();
                       maximum=false;
                   }
               }
               if(maximum){
                   solution.add(i);
               }
               else{
                   maximum=true;
               }
           }
          
        }
        
        public int calculHeuristique(int job){
            int heuristique=0;
            int m = data.machinesnumber;
            for(int i=0;i<m;i++){
                heuristique+=(m-2*i+1)*data.machinesrequirements.get(i).get(job);
            }
            return heuristique;
        }
    
}
