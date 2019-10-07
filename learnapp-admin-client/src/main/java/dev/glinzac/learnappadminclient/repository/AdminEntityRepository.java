package dev.glinzac.learnappadminclient.repository;

import dev.glinzac.learnappadminclient.entities.AdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminEntityRepository extends CrudRepository<AdminEntity,String> {
}
