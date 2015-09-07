/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssfeedgenerator;

import java.io.File;

/**
 *
 * @author Benjamin
 */
public class RSSFeedGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ohh I am going to have so much fun!
        // Lets object orient the heck out of this. 
        // #ThingsIDon'tGetToDoAsAnEmbeddedGuy
        // so I want to read my folder
        // then for every element in that folder I want to make an RSS thing
       
        


        final File folder = new File("~/holycrossoxfordmi.org/sermon/2015"); //will need to update
        listFilesForFolder(folder);
        
    }

    private static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
}
