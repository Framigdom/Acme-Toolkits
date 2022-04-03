package acme.features.patron.inventor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface PatronInventorRepository extends AbstractRepository{
	
	@Query("select inventor from Inventor inventor where inventor.id = :id")
	Inventor findInventorById(int id);
}
