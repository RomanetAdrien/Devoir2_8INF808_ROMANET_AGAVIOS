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
public class SEP extends Regle{
    
    public List<List<Integer>> reste;
    
    public SEP(Data data) {
        super(data);
        reste=new ArrayList();
        for(List<Integer> list : data.machinesrequirements){
            reste.add(new ArrayList(list));
        }
        resoud();
    }

    private void resoud() {
        int borneinf=Integer.MAX_VALUE;
        int choixtravail=0;
        
        for(int i=0;i<data.jobsnumber;i++){
            for(int j=0;j<data.machinesnumber;j++){
                if(reste.get(j).get(i)<borneinf){
                    borneinf=reste.get(j).get(i);
                    choixtravail=i;
                }
            }
        }
        for(int k=0;k<data.machinesnumber;k++){
            reste.get(k).set(choixtravail,Integer.MAX_VALUE);
        }
        if(borneinf==Integer.MAX_VALUE){
            return;
        }
        solution.add(choixtravail);
        resoud();
    }
    
}
