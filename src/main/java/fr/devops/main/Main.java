/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devops.main;

import fr.devops.dataframe.Dataframe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chouaib
 */
public class Main {
  
    public static void main(String[] args) throws Exception {
        List<String> prenom = new ArrayList<>(Arrays.asList("Léa", "Claude", "Tony", "Emma", "Ali", "Sarah"));
        List<Integer> numEtudiant = new ArrayList<>(Arrays.asList(118823, 112893, 112534, 113090, 115368, 114982));   
        List<Boolean> estAdmis = new ArrayList<>(Arrays.asList(false, true, true, true, false, true));      
        List<Double> moyenne = new ArrayList<>(Arrays.asList(9.73, 13.28, 12.07, 14.90, 9.45, 15.15)); 
        
        Map<String,List<?>> dataset = new HashMap<>();
        dataset.put("prenom", prenom);
        dataset.put("num Etudiant", numEtudiant);
        dataset.put("admis", estAdmis);
        dataset.put("moyenne", moyenne);
        
        /* Dataframe from data structure */

        Dataframe df1 = new Dataframe(dataset);
        System.out.println("\n\t\t\t\tSTUDENTS DATAFRAME : \n");
        df1.fetchAll();
        System.out.println("\n\t\t\t\tSTATS OF COLUMN : MOYENNE\n");
        df1.printStats("moyenne");
        System.out.println("\n\n");
        
        
        /* Dataframe from csv file */
        
        Dataframe df2 = new Dataframe(args[0]);
        System.out.println("\t\t\t\tCSV FILE DATAFRAME : \n");
        df2.fetchAll();
        System.out.println("\n\t\t\tSTATS OF COLUMN : AGE\n");
        df2.printStats("Age");
        System.out.println("");
        
        System.out.println("\t\t\tSELECTION BY ROWS : \n");
        Dataframe d = df2.selectionRow(85,88);
        d.fetchAll();
        System.out.println("");
        
        System.out.println("\t\t\tSELECTION BY COLUMNS : \n");
        d = d.selectionColumns(Arrays.asList("Name", "Age", "Movie"));
        d.fetchAll();
        System.out.println("");
        

        
    }
}
