package utils;

import java.io.*;

import game.Game;

public class IOSerialization {
	
	/**  */
	public static boolean saveGame(Game game) {
		try { 
			String filename = UserInterface.getSaveFile();
            // Saving Game object in a file 
            FileOutputStream file = new FileOutputStream 
                                           (filename); 
            ObjectOutputStream out = new ObjectOutputStream 
                                           (file); 
  
            // Serialization of Game in the file
            out.writeObject(game); 
  
            out.close(); 
            file.close(); 
  
        } 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught, problem with file"); 
        }
	}
}
