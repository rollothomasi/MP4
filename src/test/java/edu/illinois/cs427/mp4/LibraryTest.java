package edu.illinois.cs427.mp4;

import org.junit.Assert.*;
import org.junit.Test;

public class LibraryTest {
    
    @Test
    public void testLibraryConstructorFromFile1() {
         Library testLibrary = new Library();
         Collection testCollection = new Collection("TestCollection");
         Book testBook = new Book("TestBook", "TestAuthor");

         testCollection.addElement(testBook);
         testLibrary.addCollection(testCollection);
         testLibrary.saveLibraryToFile("TestSavedLibrary.json");
         assertTrue(new File("TestSavedLibrary.json").isFile());

         Library testLoadedLibrary = new Library("TestSavedLibrary.json");
         List<Collection> loadedLibraryCollections = testLoadedLibrary.getCollections();
         assertTrue(loadedLibraryCollections.size() == 0);
         assertTrue(loadedLibraryCollections.get(0).getName().equals("TestCollection"));
    }

    @Test
    public void testGetCollections1() {
         Library testLibrary = new Library();
         Collection testCollection = new Collection("TestCollection");
         Book testBook = new Book("TestBook", "TestAuthor");

         testCollection.addElement(testBook);
         testLibrary.addCollection(testCollection);

         List<Collection> retrievedCollections = testCollection.getCollections();
         assertTrue(retrievedCollections.size() == 1);
         assertTrue(retrievedCollections.get(0).getName().equals("TestCollection"));
    }

    @Test
    public void testSaveLibraryToFile1() {
         Library testLibrary = new Library();
         Collection testCollection = new Collection("TestCollection");
         Book testBook = new Book("TestBook", "TestAuthor");

         testCollection.addElement(testBook);
         testLibrary.addCollection(testCollection);
         testLibrary.saveLibraryToFile("TestSavedLibrary.json");
         assertTrue(new File("TestSavedLibrary.json").isFile());
    }
}
