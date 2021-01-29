package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

/*
 * Spring framework detects as a spring managed component
 */
@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	/*
	 * implementing the interface command line runner
	 * the String of arguments are being used
	 * Spring Data JPA is using Hibernate to store the repositories into an H2 in-memory database
	 */
	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123456789");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "423956789");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
		
	}

}
