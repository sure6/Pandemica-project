package com.csci927.pandemicaprovider.service.impl;

import com.csci927.pandemicaapi.bean.UserAddress;
import com.csci927.pandemicaapi.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1, "11 Northfield Ave", "001", "Mark", "150360313x", "Y");
        UserAddress address2 = new UserAddress(2, "118 Railway St, Corrimal NSW 2518", "0022", "Jerry", "1766666395x", "N");
        return Arrays.asList(address1,address2);
    }
}
