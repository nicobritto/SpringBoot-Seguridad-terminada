package mx.com.gm.dao;

import mx.com.gm.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//este repositorio va utilizar objetos de tipo Usuario donde su llave primaria(usuario)es de tipo Long||<Usuario,Long>
public interface UsuarioDao extends JpaRepository<Usuario,Long> {

    //este metodo va regresar un objeto de tipo usuario
    Usuario findByUsername(String username);//este metodo tiene que ser asi ya que es de la seguridad de Spring

}
