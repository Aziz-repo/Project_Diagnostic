package com.example.demo.Security;

import java.util.Set;
import java.util.stream.Collectors;
import static com.example.demo.Security.UserPermission.*;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
    ADMIN(Sets.newHashSet(CLIENT_READ,CLIENT_WRITE,RENDEZVOUS_READ,RENDEZVOUS_WRITE)),
    CLIENT(Sets.newHashSet());

   

    private final Set<UserPermission> permissions;
    
    private UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }
    public Set<UserPermission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.getPermession()))
                    .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
   
    
}
