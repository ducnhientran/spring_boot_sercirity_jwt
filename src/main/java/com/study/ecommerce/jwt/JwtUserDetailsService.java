package com.study.ecommerce.jwt;

import com.study.ecommerce.entity.EcommerceUser;
import com.study.ecommerce.entity.Role;
import com.study.ecommerce.entity.UserRole;
import com.study.ecommerce.model.user.UserDetailsCustom;
import com.study.ecommerce.repository.EcommerceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    EcommerceUserRepository ecommerceUserRepository ;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EcommerceUser user  = ecommerceUserRepository.findFirstByUsernameAndDeletedIsFalse(username);
        if(ObjectUtils.isEmpty(user)){
            throw new UsernameNotFoundException("User not found: "+ username);
        }
        Set<Role> roles =  user.getUserRoles()
                .stream()
                .filter(userRole -> !ObjectUtils.isEmpty(userRole.getRole()))
                .map(UserRole::getRole).collect(Collectors.toSet());
        return new UserDetailsCustom(user, roles);
    }

//    private Set<GrantedAuthority> getListGrantedAuthorityByRoles(Set<Role> roles) {
//        if (CollectionUtils.isEmpty(roles)) {
//            return Collections.emptySet();
//        } else {
//            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//            for (Role role : roles) {
//                if (!CollectionUtils.isEmpty(role.getPermissions())) {
//                    role.getPermissions().stream().map(Permission::getCode).collect(Collectors.toSet())
//                        .forEach(permissionCode -> {
//                        grantedAuthorities.add(new SimpleGrantedAuthority(permissionCode));
//                    });
//                }
//            }
//            return grantedAuthorities;
//        }
//    }
}
