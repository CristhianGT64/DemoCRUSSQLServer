package prueba.cris.prueba.demo.Service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import prueba.cris.prueba.demo.Entities.Continentes;
import prueba.cris.prueba.demo.Service.ContinenteService;
import prueba.cris.prueba.demo.repositories.ContinenteRepositorie;
@Service
public class ContinenteImpl implements ContinenteService{
    
    //Hacer esta onda para poder usar el jdbcTemplate
    private static final Logger log = LoggerFactory.getLogger(ContinenteService.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public ContinenteImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private ContinenteRepositorie continenteRepositorie;

    @Override
    public void IngresarContinete(Continentes Continente) {
         this.continenteRepositorie.save(Continente);
    }


    /* Hacer un insert en la base de datos */
    @Override
    public void create(String nombre) {
        String crearConti = "INSERT INTO Continentes VALUES ('" + nombre + " ' );";
        jdbcTemplate.update(crearConti);
    }


    /* Hacer un read en la base de datos */
    @Override
    public List<Continentes> TraerContinetes() {
        String traerContinetes = "SELECT * FROM Continentes;";
        return (List<Continentes>) this.jdbcTemplate.query(traerContinetes, new BeanPropertyRowMapper<Continentes>(Continentes.class));
        // MappedClass es como se retornara, con que tipo de clase retomaremos la info.;
    }


    @Override
    public Boolean EliminarContinete(Integer numContinente) {
        String EliminarContinente = "DELETE FROM Continentes WHERE idContinente = " + numContinente;
        this.jdbcTemplate.update(EliminarContinente);
        return true;
    }


    @Override
    public Boolean ActualizarContinente(Continentes continente) {
        String actualizarContinente = "UPDATE Continentes SET nombre = ' "+  continente.getNombre() +" ' where idContinente = "+ continente.getIdcontinente() +" ";
        if(this.jdbcTemplate.update(actualizarContinente) == 0){
            return false;
        }
        return true;
    }

    

    


    
}
