package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Author;

/*
 * CrudRepository<Entity, Entity ID type>
 * 
 * New package: repositories
 * New interface:AuthorRepository
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
