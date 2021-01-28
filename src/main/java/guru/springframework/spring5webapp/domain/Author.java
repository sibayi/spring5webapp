package guru.springframework.spring5webapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstname, lastName;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books;
	
	
	public Author() {
		super();
	}

	public Author(String firstname, String lastName, Set<Book> books) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", books=" + books + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		
		if(obj == null || getClass() != obj.getClass()) return false;
		
		Author author = (Author) obj;
		
		return id != null ? id.equals(author.id) : author.id == null;
	}
	
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

}
