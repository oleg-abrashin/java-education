package test;

import java.util.TreeMap;
import java.util.stream.Collectors;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.AuthorLastName;
import enumerations.AuthorName;
import enumerations.PublisherCountry;
import enumerations.PublisherName;
import enumerations.Title;
import library.Library;
import library.LibraryMaps;

public class Test {

	private static final int NUM_BOOKS = 1000;

	public static void main(String[] args) {
		
		/*Library lib = new LibraryMaps();
		lib.fillLibrary(NUM_BOOKS);*/
		
		Library lib = LibraryMaps.of(1000);
		
		
		/*TreeMap<String, Long> test = lib.getAllBooksAsStream()
				                      .collect(Collectors.groupingBy(
				                    		  book -> book.getPublisher().getCountry(),
				                    		  TreeMap<String, Long> :: new,
				                    		  Collectors.counting()	  
				                    		  ));
		for (String country : test.keySet()) 
			System.out.println(country+": "+test.get(country));*/
		
		for(Book book : lib.getAllBooksByPublisher(new Publisher(PublisherName.BlueStar, PublisherCountry.Israel)))
			System.out.println(book);
			
		

	}

}
