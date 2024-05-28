package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Copropiedad;
import com.solucionesvirtual.sistevoto.repository.CopropiedadRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailsServicesImpl implements UserDetailsService {
    private final CopropiedadRepo copropiedadRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Copropiedad copropiedad = copropiedadRepo.findByCopropiedad(username)
                .orElseThrow(() -> new UsernameNotFoundException("No existe el usuario " + username));
        List<SimpleGrantedAuthority> authoritiesList = new ArrayList<>();
        copropiedad.getRoles()
                .forEach(role -> authoritiesList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRolEnum().name()))));
        copropiedad.getRoles().stream()
                .flatMap(role -> role.getPermisosList().stream())
                .forEach(permiso -> authoritiesList.add(new SimpleGrantedAuthority(permiso.getName())));
        return new User(copropiedad.getCopropiedad(),
                copropiedad.getContrasenia(),
                copropiedad.isEnabled(),
                copropiedad.isAccountNoExpired(),
                copropiedad.isCredentialNoExpired(),
                copropiedad.isAccountNoLocked(),
                authoritiesList);
    }
}