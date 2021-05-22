package com.study.ecommerce.model.user;

import com.study.ecommerce.entity.EcommerceUser;
import com.study.ecommerce.entity.Permission;
import com.study.ecommerce.entity.Role;
import com.study.ecommerce.entity.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class UserDetailsCustom implements UserDetails {

    private Long id;

    private String email;

    private String username;

    private String password;

    private String status;

    private Set<Role> roles = new HashSet<>();

    private Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    private EcommerceUser user;

    public UserDetailsCustom(EcommerceUser user, Set<Role> roles) {
        super();
        this.user = user;
        if (!ObjectUtils.isEmpty(user)) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.status = user.getStatus();
            this.roles = roles;
            this.grantedAuthorities = getListGrantedAuthorityByRoles(roles);
        }
    }

    private Set<GrantedAuthority> getListGrantedAuthorityByRoles(Set<Role> roles) {
        if (CollectionUtils.isEmpty(roles)) {
            return Collections.emptySet();
        } else {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (Role role : roles) {
                if (!CollectionUtils.isEmpty(role.getPermissions())) {
                    role.getPermissions().stream().map(Permission::getCode).collect(Collectors.toSet())
                            .forEach(permissionCode -> {
                                grantedAuthorities.add(new SimpleGrantedAuthority(permissionCode));
                            });
                }
            }
            return grantedAuthorities;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
