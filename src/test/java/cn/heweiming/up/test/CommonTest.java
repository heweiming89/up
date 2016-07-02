package cn.heweiming.up.test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cn.heweiming.up.controller.HomeController;

public class CommonTest {

	public static void main(String[] args) {
		test01();
	}

	public static void test01() {
		try {
			HomeController controller = new HomeController();
			MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
			mockMvc.perform(MockMvcRequestBuilders.get("/"))
					.andExpect(MockMvcResultMatchers.view().name("home"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
