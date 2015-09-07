/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rssfeedgenerator;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import org.farng.mp3.*;


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
       
        
        LinkedList fileNames = null;
        String homeLocation = System.getProperty("user.home");
        final File folder = new File(homeLocation + "/Documents"); //will need to update
        
        files = listFilesForFolder(folder);
        getPodcasts(fileNames);
   
    }
    
    /**
     * 
     * @param fileNames 
     * Does something, that I am sure of!
     */
    private static void getPodcasts(LinkedList<File> fileNames)
    {
       LinkedList listOfPodcasts = null;
     
     for(final File file : fileNames){
        
        try{
            listOfPodcasts.add(new MP3File(file));
        }catch(IOException e){
            System.out.println("IO Exception in the population fo the podcast list" + e);
        }catch(TagException e){
            System.out.println("Tag Exception, meaning there is a bad tag in file name " + file.getName());
        }
        
     }
    }
    /**
     * retreived from: http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
     * Then heaveily modified to meet my needs
     * returns a LinkedList of Strings of the file names
    */
    private static LinkedList listFilesForFolder(final File folder) {
        LinkedList<File> fileNames = null;
        
        for (final File fileEntry : folder.listFiles()) {
            if (!(fileEntry.isDirectory())) {
                fileNames.add(fileEntry);
            } 
        }
        return fileNames;
    }
}
