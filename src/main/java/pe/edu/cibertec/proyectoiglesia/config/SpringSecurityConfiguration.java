package pe.edu.cibertec.proyectoiglesia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SpringSecurityConfiguration {

    //Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //El numero 4 representa que tan fuerte quieres la encriptacion.
        //Se puede en un rango entre 4 y 31.
        //Si no pones un numero el programa utilizara uno aleatoriamente cada vez
        //que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService customUserDetailsService) {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        List<AuthenticationProvider> providers =  List.of(authProvider);

        return new ProviderManager(providers);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .requestMatchers(resources).permitAll()
                .requestMatchers("/","/index").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/administrador").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/v1/administrador/*").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/v1/administrador").permitAll()
                .requestMatchers(HttpMethod.PUT,"/api/v1/administrador").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/api/v1/administrador/*").permitAll()
                //.requestMatchers("/admin*").access("hasRole('ADMIN')")
                //.requestMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/administrador")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
        return http.build();
    }
}