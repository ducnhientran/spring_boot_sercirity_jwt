package com.study.ecommerce.repository;

import com.study.ecommerce.entity.EcommerceUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceUserRepository extends CrudRepository<EcommerceUser, Long> {

    EcommerceUser findFirstByUsernameAndDeletedIsFalse(String userName);
}
