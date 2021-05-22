package com.study.ecommerce.config.evaluator;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;

public class PermissionEvaluatorConfig implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if (ObjectUtils.isEmpty(auth) || ObjectUtils.isEmpty(targetDomainObject) || !(permission instanceof String)){
            return false;
        }
         return hasPrivilege(auth, targetDomainObject.toString().toUpperCase(), permission.toString().toUpperCase());
    }

    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        if (ObjectUtils.isEmpty(auth) || ObjectUtils.isEmpty(targetType) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetType.toUpperCase(),permission.toString().toUpperCase());
    }


    private boolean hasPrivilege(Authentication auth, String targetType, String permission) {
        for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
            String rolePermission = grantedAuth.getAuthority();
            Boolean isRole = rolePermission.startsWith(targetType);
            Boolean isPermission = rolePermission.endsWith(permission);
            if (isRole && isPermission ) {
                return true;
            }
        }
        return false;
    }

}