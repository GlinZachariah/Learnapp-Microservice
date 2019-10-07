package dev.glinzac.learnappadminclient.repository;

import dev.glinzac.learnappadminclient.entities.Technology;
import org.springframework.data.repository.CrudRepository;

public interface TechnologyRepository extends CrudRepository<Technology,String> {
}
