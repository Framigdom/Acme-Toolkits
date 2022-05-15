package acme.features.inventor.patronage;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageRepository extends AbstractRepository{

	@Query("select patronage from Patronage patronage where patronage.inventor.id = :id and patronage.draftMode = false")
	Collection<Patronage> findPatrongeByInventorId(int id);

	@Query("select patronage from Patronage patronage where patronage.id = :id")
	Patronage findPatronageById(int id);
}