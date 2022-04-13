package acme.features.inventor.patron;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface InventorPatronRepository extends AbstractRepository{

	@Query("select patron from Patron patron where patron.id = :id")
	Patron findPatronById(int id);
}
