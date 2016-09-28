package edu.illinois.cs427.mp4;

import java.util.*;
import com.google.gson.Gson;

/**
 * This class contains the information needed to represent a book.
 */
public final class Book extends Element {
    private String title;
    private String author;

    /**
     * Builds a book with the given title and author.
     *
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String title, String author) {
        // TODO implement this
        this.title = title;
        this.author = author;
        this.setClassName("Book");
    }
    
    /**
     * Builds a book from the string representation, 
     * which contains the title and author of the book. 
     *
     * @param stringRepresentation the string representation
     */
    public Book(String stringRepresentation) {
        // TODO implement this
    	Gson gson = new Gson();
    	Book book = gson.fromJson(stringRepresentation, Book.class);
    	this.title = book.title;
    	this.author = book.author;
    	this.setClassName("Book");
    	return;
    }

    /**
     * Returns the string representation of the given book.
     * The representation contains the title and author of the book.
     *
     * @return the string representation
     */
    public String getStringRepresentation() {
        // TODO implement this
    	Gson gson = new Gson();
    	return gson.toJson(new Book(this.title, this.author));
    }

    /**
     * Returns all the collections that this book belongs to directly and indirectly.
     * Consider the following. 
     * (1) Computer Science is a collection. 
     * (2) Operating Systems is a collection under Computer Science. 
     * (3) The Linux Kernel is a book under Operating System collection. 
     * Then, getContainingCollections method for The Linux Kernel should return a list 
     * of these two collections (Operating Systems, Computer Science), starting from 
     * the direct collection to more indirect collections.
     *
     * @return the list of collections
     */
    public List<Collection> getContainingCollections() {
        // TODO implement this
    	List<Collection> collection = new ArrayList<Collection>();
    	Element cur = this;
    	while(cur.getParentCollection()!=null){
    		cur = cur.getParentCollection();
    		collection.add((Collection)cur);
    	}
        return collection;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        // TODO implement this
        return this.title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public String getAuthor() {
        // TODO implement this
        return this.author;
    }
}
