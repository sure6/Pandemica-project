package com.csci927.pandemicabootdemo.service.impl;

import com.csci927.pandemicabootdemo.bean.Complaint;
import com.csci927.pandemicabootdemo.mapper.ComplaintMapper;
import com.csci927.pandemicabootdemo.service.ComplaintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sure
 * @since 2022-09-26
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {

}
