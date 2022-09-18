package com.csci927.pandemicaapi.service;



import com.csci927.pandemicaapi.bean.UserAddress;

import java.util.List;

public interface UserService {
    List<UserAddress> getUserAddressList(String userId);
}
