package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="copropiedad")
public class Copropiedad {
    @Id
    @Column(name="id_copropiedad")
    private String copropiedad;
    @Basic
    private Integer propietario;
    private Integer administrador;
    private String contrasenia;
    @Column(name="is_enabled")
    private boolean isEnabled;
    @Column(name="account_no_expired")
    private boolean accountNoExpired;
    @Column(name="account_no_locked")
    private boolean accountNoLocked;
    @Column(name="credential_no_expired")
    private boolean credentialNoExpired;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
     private Set<Rol> roles = new HashSet<>();

    public Copropiedad(String copropiedad, Integer propietario, String contrasenia, boolean isEnabled, boolean accountNoExpired, boolean accountNoLocked, boolean credentialNoExpired, Integer administrador, Integer activo) {
        this.copropiedad = copropiedad;
        this.propietario = propietario;
        this.contrasenia = contrasenia;
        this.isEnabled = isEnabled;
        this.accountNoExpired = accountNoExpired;
        this.accountNoLocked = accountNoLocked;
        this.credentialNoExpired = credentialNoExpired;
    }

}