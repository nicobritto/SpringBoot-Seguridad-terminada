package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity//le indicamos el nombre de la tabla mysql ya que la clase esta con R podria haber inconvenientes
@Data//generacion getter setter tostring
@Table(name = "usuario")
public class Usuario implements Serializable  {
    private static final long serialVersionUID=1L;
    
  
    @Id  //llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotEmpty//no deber ser vacio
    private String username; 
    
    @NotEmpty
    private String password;
    
    //hacemos la relacion entre la clase de usuario y roll
    @OneToMany//uno a muchos
    @JoinColumn(name="id_usuario")//relacion entre las tablas es la columna id_usuario
    private List<Rol>roles;//una lista de roles asociados a 1 usuario
    
    
}
