package pe.edu.cibertec.sanca.ef.ef_p3_server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sanca.ef.ef_p3_server.entity.Usuario;
import pe.edu.cibertec.sanca.ef.ef_p3_server.repository.UsuarioRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Obtiene el usuario desde la base de datos
        Usuario usuario = usuarioRepository.findByCodigo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Crea una lista de GrantedAuthority con los roles
        Collection<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()));

        // Devuelve el objeto User con los detalles y roles
        return User.withUsername(usuario.getCodigo())
                .password(usuario.getPassword()) // El password ya debe estar encriptado en la BD
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!usuario.getActivo())
                .build();
    }
}
