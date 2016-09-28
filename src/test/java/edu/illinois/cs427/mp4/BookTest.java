package edu.illinois.cs427.mp4;
import static.org.junit.Assert.*;
import org.junit.Test;

public class BookTest {

    Book b = new Book("Story","Joe");

    public void testBookConstructor1() {
        //TODO implement this
        assertEquals("Joe", b.getAuthor());
    }

    public void testBookConstructor() {
        //TODO implement this
        assertEquals("Story", b.getTitle());
    }

    public void testGetStringRepresentation1() {
        //TODO implement this
        assertEquals("{\"title\":\"Story\",\"author\":\"Joe\",\"className\":\"Book\"}", b.getStringRepresentation());
    }

    public void testGetContainingCollections1() {
        //TODO implement this
        assertEquals(b.getContainingCollections.size(),0);
    }
}
