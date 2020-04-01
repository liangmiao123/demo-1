package com.newer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.CustomerDao;
import com.newer.domain.Customer;
import com.newer.dto.CusDto;
import com.newer.service.CustomerService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao custDao;

	/**
	 * 待条件的分页查询
	 */
	@Override
	public PageInfo<Customer> findAll(CusDto cusDto) {
		PageHelper.startPage(cusDto.getPage(), cusDto.getPageSize());
		Example example = new Example(Customer.class);
		Criteria criteria = example.createCriteria();
		if (cusDto.getCustName() != null && !"".equals(cusDto.getCustName()))
			criteria.andLike("custName", "%" + cusDto.getCustName() + "%");
		List<Customer> list = this.custDao.selectByExample(example);
		PageInfo<Customer> pages = new PageInfo<Customer>(list);
		return pages;
	}

	/**
	 * 新增顾客信息
	 */
	@Override
	public boolean addCus(Customer customer) {
		return this.custDao.insert(customer) > 0 ? true : false;
	}

	@Override
	public boolean deletCus(Integer cusId) {
		return this.custDao.deleteByPrimaryKey(cusId)>0 ?true :false;
	}

}
