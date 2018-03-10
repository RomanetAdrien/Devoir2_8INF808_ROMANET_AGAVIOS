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
    
    public void printSolution(){
        System.out.print("Solution pour "+data.name+" :");
        for(int i : solution){
            System.out.print(" "+i+" ");
        }
        System.out.println("");
    }
}
