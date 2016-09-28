package edu.illinois.cs427.mp4;

import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Represents a collection of books or (sub)collections.
 */
public final class Collection extends Element {
	private String name;
    List<Element> elements;
    
    /**
     * Creates a new collection with the given name.
     *
     * @param name the name of the collection
     */
    public Collection(String name) {
        // TODO implement this
    	this.name = name;
        this.elements = new ArrayList<>();
        this.setClassName("Collection");
    }
    
    public class Helper {
    	public String name;
    	public String elements;
    }
    
    public class Helper1 {
    	public String name;
    	public List<Object> elements;
    }
    
    /**
     * Restores a collection from its given string representation.
     *
     * @param stringRepresentation the string representation
     */
    public static Collection restoreCollection(String stringRepresentation) {
        // TODO implement this
    	Stack<Integer> stack = new Stack<Integer>();
    	Gson gson = new Gson();
    	Helper1 helper1 = gson.fromJson(stringRepresentation ,Helper1.class);
    	Collection collection = new Collection(helper1.name);
    	collection.setClassName("Collection");
    	for(int i=0;i<helper1.elements.size();i++) {
    		String element = gson.toJson(helper1.elements.get(i));
    		if(helper1.elements.get(i).toString().split("name").length==2) {
    			//collection
    			Collection subCollection  = restoreCollection(element);
    			collection.addElement(subCollection);
    		}
    		else {
    			//book
    			Book book  = new Book(element);
    			collection.addElement(book);
    		}
    	}
    	return collection;
    }

    /**
     * Returns the string representation of a collection. 
     * The string representation should have the name of this collection, 
     * and all elements (books/subcollections) contained in this collection.
     *
     * @return string representation of this collection
     */
    public String getStringRepresentation() {
        // TODO implement this
    	Gson gson = new Gson();
    	String arr = "[";
    	for(int i=0;i<elements.size();i++) {
    		if (elements.get(i).getClassName().equals("Book")){
    			Book book = (Book)elements.get(i);
    			if(i==elements.size()-1)
    				arr = arr+book.getStringRepresentation();
    			else
    				arr = arr+book.getStringRepresentation()+",";
    		}
    		else {
    			Collection collection = (Collection)elements.get(i);
    			if(i==elements.size()-1)
    				arr = arr+collection.getStringRepresentation();
    			else
    				arr = arr+collection.getStringRepresentation()+",";
    		}
    	}
    	arr = arr+"]";
    	Helper helper = new Helper();
    	helper.name = name;
    	helper.elements = "";
    	String str = gson.toJson(helper);
    	str = str.substring(0,str.length()-3)+arr+"}";
    	return str;
    }

    /**
     * Returns the name of the collection.
     *
     * @return the name
     */
    public String getName() {
        // TODO implement this
        return this.name;
    }
    
    /**
     * Adds an element to the collection.
     * If parentCollection of given element is not null,
     * do not actually add, but just return false.
     * (explanation: if given element is already a part of  
     * another collection, you should have deleted the element 
     * from that collection before adding to another collection)
     *
     * @param element the element to add
     * @return true on success, false on fail
     */
    public boolean addElement(Element element) {
        // TODO implement this
        if (element.getParentCollection()!=null)
            return false;
        else {
            this.elements.add(element);
            element.setParentCollection(this);
        }
        return true;
    }
    
    /**
     * Deletes an element from the collection.
     * Returns false if the collection does not have 
     * this element.
     * Hint: Do not forget to clear parentCollection
     * of given element 
     *
     * @param element the element to remove
     * @return true on success, false on fail
     */
    public boolean deleteElement(Element element) {
        // TODO implement this
        if (this.elements.contains(element)) {
            element.setParentCollection(null);
            this.elements.remove(element);
            return true;
        }
        else
            return false;
    }
    
    /**
     * Returns the list of elements.
     * 
     * @return the list of elements
     */
    public List<Element> getElements() {
        // TODO implement this
        return this.elements;
    }
}
