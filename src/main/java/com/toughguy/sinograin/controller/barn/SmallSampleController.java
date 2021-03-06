package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;

@Controller
@RequestMapping(value = "/smallSample")
public class SmallSampleController {
	
	@Autowired
	private ISmallSampleService smallSampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("SmallSample:all")
	public List<SmallSample> getAll(){
		return smallSampleService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("SmallSample:all")
	public SmallSample get(int id){
		return smallSampleService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("SmallSample:edit")
	public String edit(SmallSample smallSample) {
		try {
			smallSampleService.update(smallSample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("SmallSample:add")
	public String saveSample(SmallSample smallSample) {
		try {
			smallSampleService.save(smallSample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/data")
	//@RequiresPermissions("SmallSample:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<SmallSample> pg = smallSampleService.findPaginated(map);
			
			// 序列化查询结果为JSON
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", pg.getTotal());
			result.put("rows", pg.getData());
			return om.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"total\" : 0, \"rows\" : [] }";
		}
	}
	
}

