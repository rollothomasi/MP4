package edu.illinois.cs427.mp4;

import org.junit.Assert.*;
import org.junit.Test;

public class CollectionTest {
    
    @Test
    public void testRestoreCollection1() {
         Collection testCollection = new Collection("TestCollection");
         Book testBook = new Book("TestBook", "TestAuthor");

         testCollection.addElement(testBook);
         String stringRepresentation = testCollection.getStringRepresentation();

         Collection restoredCollection = Collection.restoreCollection(stringRepresentation);
         assertTrue(restoredCollection.getName().equals("TestCollection"));
         List<Element> elementsInCollection = restoredCollection.getElements();
         Book firstElement = (Book)elementsInCollection.get(0);
         assertTrue(firstElement.getTitle().equals("TestBook"));
         assertTrue(firstElement.getTitle().equals("TestAuthor"));
    }

    @Test
    public void testRestoreCollection2() {
        Collection testCollection = new Collection("TestCollection");
        Collection testCollection2 = new Collection("TestCollection2");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection.addElement(testCollection2);
        String stringRepresentation = testCollection.getStringRepresentation();

        Collection restoredCollection = Collection.restoreCollection(stringRepresentation);
        assertTrue(restoredCollection.getName().equals("TestCollection"));
        List<Element> elementsInCollection = restoredCollection.getElements();
        Element firstElement = elementsInCollection.get(0);
        assertTrue(firstElement.getName().equals("TestCollection2"));
    }

    @Test
    public void testRestoreCollection3() {
        Collection testCollection = new Collection("TestCollection");
        Collection testCollection2 = new Collection("TestCollection2");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection.addElement(testBook);
        testCollection.addElement(testCollection2);
        String stringRepresentation = testCollection.getStringRepresentation();

        Collection restoredCollection = Collection.restoreCollection(stringRepresentation);
        assertTrue(restoredCollection.getName().equals("TestCollection"));
        assertTrue(restoredCollection.getElements().size() == 2);
    }

    @Test
    public void testGetStringRepresentation1() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection.addElement(testBook);

        String stringRepresentation = testCollection.getStringRepresentation();

        testCollection.deleteElement(testBook);

        Collection testCollection2 = new Collection("TestCollection");
        testCollection2.addElement(testBook);
        assertTrue(stringRepresentation.equals(testCollection2.getStringRepresentation()));
    }

    @Test
    public void testGetStringRepresentation2() {
        Collection testCollection = new Collection("TestCollection");
        Collection testCollection2 = new Collection("TestCollection2");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection2.addElement(testBook);
        testCollection.addElement(testCollection2);

        String stringRepresentation = testCollection.getStringRepresentation();
        assertTrue(stringRepresentation.contains(new CharSequence("TestCollection")));
    }

    @Test
    public void testAddElement1() {
         Collection testCollection = new Collection("TestCollection");
         Book testBook = new Book("TestBook", "TestAuthor");

         assertTrue(testCollection.addElement(testBook));

         List<Element> elementsInCollection = testCollection.getElements();
         assertTrue(elementsInCollection.contains(testBook));
    }

    @Test
    public void testAddElement2() {
        Collection testCollection = new Collection("TestCollection");
        Collection testCollection2 = new Collection("TestCollection2");
        Book testBook = new Book("TestBook", "TestAuthor");

        assertTrue(testCollection.addElement(testBook));
        assertFalse(testCollection2.addElement(testBook));
    }

    @Test
    public void testAddElement3() {
        Collection testCollection = new Collection("TestCollection");
        Collection testCollection2 = new Collection("TestCollection2");
        Book testBook = new Book("TestBook", "TestAuthor");
        testCollection2.addElement(testBook);

        assertTrue(testCollection.addElement(testCollection2));
    }

    @Test
    public void testDeleteElement1() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection.addElement(testBook);
        List<Element> elementsInCollection = testCollection.getElements();
        assertTrue(elementsInCollection.contains(testBook));

        assertTrue(testCollection.deleteElement(testBook));
        elementsInCollection = testCollection.getElements();
        assertFalse(elementsInCollection.contains(testBook));
    }

    @Test
    public void testDeleteElement2() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");

        assertFalse(testCollection.deleteElement(testBook));
    }

    @Test
    public void testDeleteElement3() {
        Collection testCollection = new Collection("TestCollection");
        Collection testCollection2 = new Collection("TestCollection2");
        Book testBook = new Book("TestBook", "TestAuthor");
        testCollection2.addElement(testBook);

        assertFalse(testCollection.deleteElement(testCollection2));
    }
}
