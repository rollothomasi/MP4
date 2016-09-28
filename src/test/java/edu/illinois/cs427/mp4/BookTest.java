package edu.illinois.cs427.mp4;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {
    @Test
    public void testBookConstructor1() {
        //TODO implement this
        Book b = new Book("Story","Joe");
        Assert.assertTrue("Joe".equals(b.getAuthor()) && "Story".equals(b.getTitle()));
    }

    @Test
    public void testBookConstructor() {
        //TODO implement this
        Book b = new Book("Story","Joe");
        Assert.assertTrue("Story".equals(b.getTitle()));
    }

    @Test
    public void testGetStringRepresentation1() {
        //TODO implement this
        Book b = new Book("Story","Joe");
        Assert.assertTrue("{\"title\":\"Story\",\"author\":\"Joe\",\"className\":\"Book\"}".equals(b.getStringRepresentation()));
    }

    @Test
    public void testGetContainingCollections1() {
        //TODO implement this
        Book b = new Book("Story","Joe");
        Assert.assertTrue(b.getContainingCollections().size()==0);
    }

    @Test
    public void testStringRepresentationToObject() {
        //TODO implement this
        String str = "{\"title\":\"Story\",\"author\":\"Joe\",\"className\":\"Book\"}";
        Book b = new Book(str);
        Assert.assertTrue(b.getAuthor().equals("Joe") && b.getTitle().equals("Story"));
    }
}
