package com.csci927.pandemicaconsumer.service.impl;


import com.csci927.pandemicaapi.bean.Cervaluation;
import com.csci927.pandemicaapi.bean.UserAddress;
import com.csci927.pandemicaapi.service.OrderService;
import com.csci927.pandemicaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserService userService;
    public void initOrder(String userID) {
        // Query the shipping address of the user
        List<UserAddress> userAddressList = userService.getUserAddressList(userID);

        // get printing info from console
        System.out.println("Currently received userId=> "+userID);
        System.out.println("**********");
        System.out.println("All the addresses obtained are：");
        for (UserAddress userAddress : userAddressList) {
            // print information about the remote service address
            System.out.println(userAddress.getUserAddress());
        }
    }

    @Override
    public List<Cervaluation> getCervaluationList() {
        return null;
    }
}
