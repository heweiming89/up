package cn.heweiming.up.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sse")
public class SseController {

	@RequestMapping("01")
	@ResponseBody
	public String sse01() {
		Random random = new Random();
		return "01 ==>\t" + random.nextInt();
	}

	@RequestMapping(value = "02", produces = { "text/event-stream" })
	@ResponseBody
	public String sse02() {
		Random random = new Random();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "02 ==>\t" + random.nextInt();
	}

}
