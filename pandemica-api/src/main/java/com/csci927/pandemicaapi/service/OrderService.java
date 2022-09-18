package com.csci927.pandemicaapi.service;

import com.csci927.pandemicaapi.bean.Cervaluation;
import com.csci927.pandemicaapi.bean.UserAddress;

import java.util.List;

public interface OrderService {
    void initOrder(String userID);

    List<Cervaluation> getCervaluationList();
}
