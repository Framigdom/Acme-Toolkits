package acme.features.any.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitRepository extends AbstractRepository {
	
	@Query("select t FROM Toolkit t where t.published=true")
	Collection<Toolkit> findAllToolkitPublished();

	@Query("SELECT t FROM Toolkit t WHERE t.id = :id")
	Toolkit findOneToolkitById(int id);
	
	@Query("select sum(q.artifact.retailPrice.amount * q.amount) FROM Quantity q where q.toolkit.id = :id")
	Double findPriceByToolkit(int id);
	
}
