package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //con este metodo vamos a indicar los pats que vamos a utilizar
                // vamos a restrigir el acceso a editar agregar eliminar
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                .hasRole("ADMIN") //solos los usuarios admin van a poder acceder a agregar eliminar editar
                //indicamos quien puede acceder al pad raiz o sea e pad muestra el listado de personas
                .antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                //agregamos el formLogin que vamos a utilizar ya personalizado
                //que es el que esta templates login
                .and()
                .formLogin()
                .loginPage("/login")
                //agregamos configuracion de la paguina de eerror
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");

    }

}
