package com.study.ecommerce.service;

import com.study.ecommerce.model.response.ResponseData;
import com.study.ecommerce.model.user.UserLogin;

public interface AuthenticationService {
    ResponseData authentication(UserLogin userLogin);
}
