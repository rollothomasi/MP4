package edu.illinois.cs427.mp4;
import org.junit.Assert.*;
import org.junit.Test;

public class BookTest {

    Book b = new Book("Story","Joe");

    @Test
    public void testBookConstructor1() {
        //TODO implement this
        assertEquals("Joe", b.getAuthor());
    }

    @Test
    public void testBookConstructor() {
        //TODO implement this
        assertEquals("Story", b.getTitle());
    }

    @Test
    public void testGetStringRepresentation1() {
        //TODO implement this
        assertEquals("{\"title\":\"Story\",\"author\":\"Joe\",\"className\":\"Book\"}", b.getStringRepresentation());
    }

    @Test
    public void testGetContainingCollections1() {
        //TODO implement this
        assertEquals(b.getContainingCollections.size(),0);
    }
}
