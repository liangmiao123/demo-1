package com.newer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.newer.domain.Customer;
import com.newer.dto.CusDto;
import com.newer.service.CustomerService;

@CrossOrigin
@RestController
public class CustController {
	@Autowired
	private CustomerService custService;
	//分页查询
	@RequestMapping("findPages")
	public PageInfo<Customer> findPages(CusDto cusDto,ModelMap modelMap) {
		PageInfo<Customer> pageInfo=this.custService.findAll(cusDto);
		modelMap.addAttribute("pageInfo", pageInfo);
		return pageInfo;
	}
	//添加信息
	@RequestMapping("save")
	public String addCust(@RequestBody Customer customer,ModelMap modelMap) {
		boolean tag=this.custService.addCus(customer);
		if(tag) {
			modelMap.addAttribute("msg", "添加成功");
			return "添加成功";
		}else {
			modelMap.addAttribute("msg", "添加失败");
			return "添加失败";
		}
	}
	
}
