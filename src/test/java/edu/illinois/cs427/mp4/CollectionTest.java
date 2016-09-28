package edu.illinois.cs427.mp4;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class CollectionTest {
    @Test
    public void testCreatingCollection1() {
        Collection collection = new Collection("Lu");
        Assert.assertTrue((collection.getName().equals("Lu")) && (collection.getElements().size()==0) && (collection.getClassName().equals("Collection")));
    }

    @Test
    public void testHelper(){
        Collection collection = new Collection("Lu");
        Collection.Helper helper = collection.new Helper();
        helper.name = "Lu";
        helper.elements = "123";
        Assert.assertTrue(helper.name.equals("Lu") && helper.elements.equals("123"));
    }

    @Test
    public void testHelper1(){
        Collection collection = new Collection("Lu");
        Collection.Helper1 helper = collection.new Helper1();
        helper.name = "Lu";
        helper.elements = new ArrayList<Object>();
        helper.elements.add("123");
        Assert.assertTrue(helper.name.equals("Lu") && helper.elements.get(0).equals("123"));
    }

    @Test
    public void testRestoreCollection1() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection.addElement(testBook);
        String stringRepresentation = testCollection.getStringRepresentation();

        Collection restoredCollection = Collection.restoreCollection(stringRepresentation);
        Assert.assertTrue(restoredCollection.getName().equals("TestCollection"));
        List<Element> elementsInCollection = restoredCollection.getElements();
        Book firstElement = (Book)elementsInCollection.get(0);
        Assert.assertTrue(firstElement.getTitle().equals("TestBook"));
        Assert.assertTrue(firstElement.getAuthor().equals("TestAuthor"));
    }

    @Test
    public void testRestoreCollection2() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection.addElement(testBook);
        Collection testCollection1 = new Collection("TestCollection1");
        testCollection1.addElement(testCollection);
        String stringRepresentation = testCollection1.getStringRepresentation();

        Collection collection1 = Collection.restoreCollection(stringRepresentation);
        Assert.assertTrue(collection1.getName().equals("TestCollection1"));
        List<Element> elementsInCollection = collection1.getElements();
        Collection firstElement = (Collection)elementsInCollection.get(0);

        Assert.assertTrue(firstElement.getName().equals("TestCollection"));

        List<Element> subElementsInCollection = firstElement.getElements();
        Book book1 = (Book)subElementsInCollection.get(0);
        Assert.assertTrue(book1.getTitle().equals("TestBook"));
        Assert.assertTrue(book1.getAuthor().equals("TestAuthor"));
    }

    @Test
    public void testGetStringRepresentation1() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");

        testCollection.addElement(testBook);
        Assert.assertTrue(testCollection.getStringRepresentation().equals("{\"name\":\"TestCollection\",\"elements\":[{\"title\":\"TestBook\",\"author\":\"TestAuthor\",\"className\":\"Book\"}]}"));
    }

    @Test
    public void testGetStringRepresentation2() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");
        Book testBook1 = new Book("TestBook1", "TestAuthor1");

        testCollection.addElement(testBook);
        testCollection.addElement(testBook1);
        Assert.assertTrue(testCollection.getStringRepresentation().equals("{\"name\":\"TestCollection\",\"elements\":[{\"title\":\"TestBook\",\"author\":\"TestAuthor\",\"className\":\"Book\"},{\"title\":\"TestBook1\",\"author\":\"TestAuthor1\",\"className\":\"Book\"}]}"));
    }

    // @Test
    // public void testGetStringRepresentation3() {
    //     Collection testCollection = new Collection("TestCollection");
    //     Book testBook = new Book("TestBook", "TestAuthor");

    //     testCollection.addElement(testBook);
    // }

    // @Test
    // public void testGetStringRepresentation4() {
    //     Collection testCollection = new Collection("TestCollection");
    //     Book testBook = new Book("TestBook", "TestAuthor");

    //     testCollection.addElement(testBook);
    // }

    @Test
    public void testAddElement1() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");
        testCollection.addElement(testBook);

        Collection testCollection1 = new Collection("TestCollection1");

        Assert.assertFalse(testCollection1.addElement(testBook));
    }

    @Test
    public void testAddElement2() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");
        Assert.assertTrue(testCollection.addElement(testBook));
    }

    @Test
    public void testDeleteElement1() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");
        Book testBook1 = new Book("TestBook1", "TestAuthor1");
        testCollection.addElement(testBook);
        Assert.assertTrue(testCollection.deleteElement(testBook));
    }

    @Test
    public void testDeleteElement2() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");
        Book testBook1 = new Book("TestBook1", "TestAuthor1");
        testCollection.addElement(testBook);
        Assert.assertFalse(testCollection.deleteElement(testBook1));
    }

    @Test
    public void testGetElement1() {
        Collection testCollection = new Collection("TestCollection");
        Book testBook = new Book("TestBook", "TestAuthor");
        Book testBook1 = new Book("TestBook1", "TestAuthor1");
        testCollection.addElement(testBook);
        Book book = (Book)testCollection.getElements().get(0);
        Assert.assertTrue(book.getTitle().equals("TestBook"));
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
