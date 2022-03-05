package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name="rol")//le indicamos el nombre de la tabla mysql ya que la clase esta con R podria haber inconvenientes
public class Rol implements Serializable  {
    private static final long serialVersionUID=1L;
    
    //indicamos que va ser la llave primaria 
    @Id
    //indicamos la forma de generacion de llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol; 
    
    //hhora mapiamos el campo de nombre de la tabla rol
    @NotEmpty//obligatoriamente debe tener un valor
    private String nombre;
    
    
}
