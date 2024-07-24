package prueba.cris.prueba.demo.Service;



import java.util.List;

import prueba.cris.prueba.demo.Entities.Continentes;

public interface ContinenteService {

    public void IngresarContinete(Continentes Continente);

    public void create(String nombre);

    public List<Continentes> TraerContinetes();

    public Boolean EliminarContinete(Integer numContinente);

    public Boolean ActualizarContinente(Continentes continente);

}
