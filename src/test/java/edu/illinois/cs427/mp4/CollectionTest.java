package edu.illinois.cs427.mp4;

import org.junit.Assert;
import org.junit.Test;

public class CollectionTest {
    @Test
    public void testCreatingCollection1() {
        Collection collection = new Collection("Lu");
        Assert.assertTrue(collection.name.equals("Lu") && collection.elements.size() && elements.collection);
    }

    @Test
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

    @Test
    public void testGetStringRepresentation1() {
        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);

        // String stringRepresentation = testCollection.getStringRepresentation();
        // assertTrue(stringRepresentation.equals("$TestCollection@#$TestBook*TestAuthor*$#$"));
    }

    @Test
    public void testAddElement1() {
        // Collection testCollection = new Collection("TestCollection");
        // Book testBook = new Book("TestBook", "TestAuthor");

        // testCollection.addElement(testBook);

        // List<Element> elementsInCollection = testCollection.getElements();
        // assertTrue(elementsInCollection.contains(testBook));
    }

    @Test
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
