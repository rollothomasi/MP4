package edu.illinois.cs427.mp4;

import org.junit.Assert.*;
import org.junit.Test;

public class CollectionTest {
    public void testRestoreCollection1() {
        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);
        // String stringRepresentation = testCollection.getStringRepresentation();

        // Collection restoredCollection = Collection.restoreCollection(stringRepresentation);
        // assertTrue(restoredCollection.getName().equals("TestCollection"));
        // List<Element> elementsInCollection = restoredCollection.getElements();
        // Book firstElement = (Book)elementsInCollection.get(0);
        // assertTrue(firstElement.getTitle().equals("TestBook"));
        // assertTrue(firstElement.getTitle().equals("TestAuthor"));
    }

    public void testGetStringRepresentation1() {
        //Collection testCollection = new Collection("TestCollection");
        //Book testBook = new Book("TestBook", "TestAuthor");

        //testCollection.addElement(testBook);

        //String stringRepresentation = testCollection.getStringRepresentation();

        //Collection testCollection2 = new Collection("TestCollection");
        //testCollection2.addElement(testBook);
        //assertTrue(stringRepresentation.equals(testCollection2.getStringRepresentation()));
    }

    public void testAddElement1() {
        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);

        // List<Element> elementsInCollection = testCollection.getElements();
        // assertTrue(elementsInCollection.contains(testBook));
    }

    public void testDeleteElement1() {
        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);
        // List<Element> elementsInCollection = testCollection.getElements();
        // assertTrue(elementsInCollection.contains(testBook));

        // testCollection.deleteElement(testBook);
        // elementsInCollection = testCollection.getElements();
        // assertFalse(elementsInCollection.contains(testBook));
    }
}
