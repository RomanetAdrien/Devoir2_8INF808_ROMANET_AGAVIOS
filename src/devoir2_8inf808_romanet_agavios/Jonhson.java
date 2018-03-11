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
public class Jonhson extends Regle{
    
    public List<List<Integer>> reste;
    
    public Jonhson(Data data) {
        super(data);
        this.data.machinesnumber=2;
        reste=data.machinesrequirements;
        resoud();
    }
    
    public Jonhson(Data data,List<Integer> heuristiques1,List<Integer> heuristiques2) {
        super(data);
        this.data.machinesnumber=2;
        this.data.machinesrequirements.clear();
        this.data.machinesrequirements.add(heuristiques1);
        this.data.machinesrequirements.add(heuristiques2);
        reste=this.data.machinesrequirements;
        resoud();
        calculMakespan();
    }
    
    public void resoud(){
        int mintravail,minmachine;
        int[] minimums = trouverJobMinimum();
        int nbregauche=0;
        int nbredroit=0;
        List<Integer> solutiondroite = new ArrayList();
        
        while(minimums!=null){
            mintravail=minimums[0];
            minmachine=minimums[1];
            if(minmachine==0){
                solution.add(nbregauche,mintravail);
                nbregauche++;
            }
            else{
                solutiondroite.add(0,mintravail);
                //nbredroit++;
            }
            minimums=trouverJobMinimum();

        }
        for(int i : solutiondroite){
            solution.add(i);
        }
    }
    
    public int[] trouverJobMinimum(){
        int minimum= Integer.MAX_VALUE;
        int travail=0;
        int machine=0;
        int[] resultat= new int[2]; 
        for(int i=0;i<2;i++){
            for(int j=0;j<data.jobsnumber;j++){
                if(reste.get(i).get(j)<minimum){
                    minimum=reste.get(i).get(j);
                    travail=j;
                    machine=i;
                }
            }
        }
        resultat[0]=travail;
        resultat[1]=machine;
        for(int i=0;i<data.machinesnumber;i++){
         reste.get(i).set(travail,Integer.MAX_VALUE);
        }
        
        if(minimum==Integer.MAX_VALUE){
            return null;
        }
        return resultat;
    }
}
