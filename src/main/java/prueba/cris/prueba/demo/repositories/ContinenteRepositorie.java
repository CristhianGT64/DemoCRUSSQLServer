package prueba.cris.prueba.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import prueba.cris.prueba.demo.Entities.Continentes;
@Repository
public interface ContinenteRepositorie extends CrudRepository<Continentes, Integer>{
    
}
