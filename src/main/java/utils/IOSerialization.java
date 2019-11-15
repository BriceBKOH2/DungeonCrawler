package utils;

import java.io.*;

import game.Game;

public class IOSerialization {
	static String fileNameAutoSaveDefault = System.getenv("UserProfile") + "\\save\\game_autosave.sav";
	static String fileNameSaveDefault = System.getenv("UserProfile") + "\\save\\game_save.sav";
	
	/* Getters and Setters */
	
	public static String getFileNameAutoSaveDefault() {
		return fileNameAutoSaveDefault;
	}

	public static void setFileNameAutoSaveDefault(String fileNameAutoSaveDefault) {
		IOSerialization.fileNameAutoSaveDefault = fileNameAutoSaveDefault;
	}

	public static String getFileNameSaveDefault() {
		return fileNameSaveDefault;
	}

	public static void setFileNameSaveDefault(String fileNameSaveDefault) {
		IOSerialization.fileNameSaveDefault = fileNameSaveDefault;
	}

	/* Save methods */
	
	/** Save the game in a default location or in a location input by the user, return true if done, false if exception */
	public static boolean saveGame(Game game) {
		String fileName = UserInterface.getFilePath();
		try { 
            // Saving Game object in a file 
            FileOutputStream file = new FileOutputStream 
                                           (fileName); 
            ObjectOutputStream out = new ObjectOutputStream 
                                           (file); 
  
            // Serialization of Game in the file
            out.writeObject(game); 
  
            out.close(); 
            file.close(); 
  
        } 
  
        catch (IOException ex) { 
            System.err.println("IOException is caught, problem with file, try again");
            return false;
        }
		
		System.out.println("Game saved in " + fileName);
		return true;
	}
	
	/** Save the game in a default location, to be used in each game loop */
	public static boolean saveAutoGame(Game game) {
		try { 
            // Saving Game object in a file 
            FileOutputStream file = new FileOutputStream(fileNameAutoSaveDefault);
            ObjectOutputStream out = new ObjectOutputStream(file);
  
            // Serialization of Game in the file
            out.writeObject(game); 
  
            out.close(); 
            file.close(); 
  
        } 
  
        catch (IOException ex) { 
            System.err.println("IOException is caught, problem with auto save file");
            ex.printStackTrace();
            return false;
        }
		
		System.out.println("Auto Save Done");
		return true;
	}

	public static Game loadGame() {
		Game game = null;
		String fileName = UserInterface.getFilePath();
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream(fileName); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            game = (Game)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught, problem with file, try again"); 
	            ex.printStackTrace();
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught, problem with Game class in save file"); 
	            ex.printStackTrace();
	        }
		if (game == null) {
			System.out.println("Game is empty, creating a new game instead");
			game = new Game();
		}
		
		return game;
	}
	
	/* Load methods */
	
	
}
