package prueba.cris.prueba.demo.Entities;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Continentes")
public class Continentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcontinente;

    private String nombre;
}
