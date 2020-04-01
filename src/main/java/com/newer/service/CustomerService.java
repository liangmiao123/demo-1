package com.newer.service;

import com.github.pagehelper.PageInfo;
import com.newer.domain.Customer;
import com.newer.dto.CusDto;

public interface CustomerService {
	//分页查询所有
	public PageInfo<Customer> findAll(CusDto cusDto);
	 // 新增顾客信息
	public boolean addCus(Customer customer);
	//根据用户id删除信息
	public boolean deletCus(Integer cusId);
}
