package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

//extiended de CrudRepository para que genere los metodos mas comunes de eliminar insertar cargar
public interface PersonaDao extends JpaRepository<Persona,Long>{
    
}
