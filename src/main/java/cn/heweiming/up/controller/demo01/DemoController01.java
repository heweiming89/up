package cn.heweiming.up.controller.demo01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/demo01")
public class DemoController01 {

	@RequestMapping("01")
	@ResponseBody
	public Map<String, Object> demo01() {
		Map<String, Object> map = new HashMap<>();
		map.put("AAA", 111);
		map.put("BBB", 222);
		map.put("CCC", 333);
		map.put("DDD", 444);
		return map;
	}

}
