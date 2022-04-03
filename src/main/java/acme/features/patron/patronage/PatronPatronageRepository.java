package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronageRepository extends AbstractRepository{
	
	@Query("select patronage from Patronage patronage where patronage.patron.id = :id")
	Collection<Patronage> findPatrongeByPatronId(int id);
	
	@Query("select patronage from Patronage patronage where patronage.id = :id")
	Patronage findPatronageById(int id);
}
