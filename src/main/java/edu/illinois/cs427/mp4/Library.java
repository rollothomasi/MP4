package edu.illinois.cs427.mp4;

import java.util.*;
import java.io.*;

/**
 * Container class for all the collections (that eventually contain books).
 * Its main responsibility is to save the collections to a file and restore them from a file.
 */
public final class Library {
    private List<Collection> collections;

    /**
     * Builds a new, empty library.
     */
    public Library() {
        // TODO implement this
    	collections = new ArrayList<Collection>();
    }

    /**
     * Builds a new library and restores its contents from the given file.
     *
     * @param fileName the file from where to restore the library.
     */
    public Library(String fileName) {
        // TODO implement this
    	collections = new ArrayList<Collection>();
    	String str = "";
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(fileName));
    		while((str=br.readLine())!=null) {
        		Collection collection = Collection.restoreCollection(str);
        		collections.add(collection);
        	}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }

    /**
     * Saved the contents of the library to the given file.
         *
     * @param fileName the file where to save the library
     */
    public void saveLibraryToFile(String fileName) {
        // TODO implement this
    	if(collections==null || collections.size()==0)
    		return;
    	BufferedWriter bw = null;
    	try {
    		File file = new File(fileName);
    		if (!file.exists()) {
    			file.createNewFile();
			}
    		bw = new BufferedWriter(new FileWriter(fileName));
    		for(Collection collection:collections) {
        		String str = collection.getStringRepresentation()+"\n";
        		bw.write(str);
        	}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		try{
    			if(bw!=null)
    				bw.close();
			}
			catch(Exception e){
				System.out.println("Error in closing the BufferedWriter"+e);
			}
    		}
    	}

    /**
     * Returns the collections contained in the library.
     *
     * @return library contained elements
     */
    public List<Collection> getCollections() {
        // TODO implement this
        return this.collections;
    }
}
