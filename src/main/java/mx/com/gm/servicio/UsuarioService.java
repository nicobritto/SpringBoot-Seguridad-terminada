package mx.com.gm.servicio;


import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Rol;
import mx.com.gm.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//convertimso esta clase de tipo servicio con
@Service("userDetailsService")//esta clase la usa SpringSeguridad asiq debe ser excactamente como esta escrito
@Slf4j//esta clase es para el maejo de login
public class UsuarioService implements UserDetailsService{//esta clase debe implemetnar la clase para que funcione la seguridad de Sptring

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario  usuario=usuarioDao.findByUsername(username);
        if (usuario==null) {
            throw new UsernameNotFoundException(username);
        }
        var roles=new ArrayList<GrantedAuthority>();
        
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new User(usuario.getUsername(),usuario.getPassword(),roles);
        
    }
    
        
    

}

