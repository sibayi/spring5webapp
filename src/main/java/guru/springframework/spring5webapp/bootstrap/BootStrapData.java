package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

/*
 * Spring framework detects as a spring managed component
 */
@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	/*
	 * implementing the interface command line runner
	 * the String of arguments are being used
	 * Spring Data JPA is using Hibernate to store the repositories into an H2 in-memory database
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started in Bootstrap");
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123456789");
		Publisher penguin = new Publisher("Penguin", "4168 Main St", "New York City", "New York", 85423);
		publisherRepository.save(penguin);
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(penguin);
		penguin.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(penguin);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "423956789");
		Publisher random = new Publisher("Random House", "5416 Gratiot Ave", "Suite 531", "Seattle", "Washington", 32586);
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(penguin);
		penguin.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(random);
		publisherRepository.save(penguin);
		
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
		System.out.println("Number of " + penguin.getName() + " books: " + penguin.getBooks().size());
		System.out.println("Number of " + random.getName() + " books: " + random.getBooks().size());
		
		/*Iterable<Author> authorList = authorRepository.findAll();
		Iterable<Book> bookList = bookRepository.findAll();*/
		Iterable<Publisher> publisherList = publisherRepository.findAll();
		
		/*authorList.forEach(System.out::println);
		bookList.forEach(System.out::println);*/
		publisherList.forEach(System.out::println);
		
	}

}
