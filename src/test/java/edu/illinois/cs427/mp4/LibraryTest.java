package edu.illinois.cs427.mp4;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;
import java.io.*;

public class LibraryTest {
    @Test
    public void testLibraryConstructorFromFile1() {
        Library testLibrary = new Library();
        Assert.assertTrue(testLibrary.getCollections().size()==0);
        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);
        // testLibrary.addCollection(testCollection);
        // testLibrary.saveLibraryToFile("TestSavedLibrary.json");
        // assertTrue(new File("TestSavedLibrary.json").isFile());

        // Library testLoadedLibrary = new Library("TestSavedLibrary.json");
        // List<Collection> loadedLibraryCollections = testLoadedLibrary.getCollections();
        // assertTrue(loadedLibraryCollections.size() == 0);
        // assertTrue(loadedLibraryCollections.get(0).getName().equals("TestCollection"));
    }

    @Test
    public void testLibraryConstructorFromFile2() {
        Library testLibrary = new Library();
        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);
        // testLibrary.addCollection(testCollection);
        // testLibrary.saveLibraryToFile("TestSavedLibrary.json");
        // assertTrue(new File("TestSavedLibrary.json").isFile());

        Library testLoadedLibrary = new Library("test.txt");
        List<Collection> loadedLibraryCollections = testLoadedLibrary.getCollections();
        Assert.assertTrue(loadedLibraryCollections.size() == 2);
        Assert.assertTrue(loadedLibraryCollections.get(0).getName().equals("Bookstore"));
    }

    @Test
    public void testGetCollections1() {
        Library testLibrary = new Library();
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection.addElement(testBook);
        testLibrary.addCollection(testCollection);

        List<Collection> retrievedCollections = testLibrary.getCollections();
        Assert.assertTrue(retrievedCollections.size() == 1);
        Assert.assertTrue(retrievedCollections.get(0).getName().equals("TestCollection"));
    }

    @Test
    public void testSaveLibraryToFile1() {
        Library testLibrary = new Library();
        testLibrary.saveLibraryToFile("save.txt");
        File file = new File("save.txt");
        Assert.assertTrue(!file.exists());
        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);
        // testLibrary.addCollection(testCollection);
        // testLibrary.saveLibraryToFile("TestSavedLibrary.json");
        // assertTrue(new File("TestSavedLibrary.json").isFile());
    }

    @Test
    public void testSaveLibraryToFile2() {
        Library testLibrary = new Library("test.txt");
        Assert.assertTrue(testLibrary.getCollections().size()==2);
        testLibrary.saveLibraryToFile("save.txt");

        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);
        // testLibrary.addCollection(testCollection);
        // testLibrary.saveLibraryToFile("TestSavedLibrary.json");
        // assertTrue(new File("TestSavedLibrary.json").isFile());
    }
}
