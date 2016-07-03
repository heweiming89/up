package cn.heweiming.up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("01")
	public String upload01() {
		// IOUtils.
		return "home";
	}

	@RequestMapping("02")
	public String upload02(@RequestParam("doraemon") MultipartFile doraemon) {
		String filename = doraemon.getOriginalFilename();
		try {
			doraemon.transferTo(
					new File("test02/" + System.currentTimeMillis() + "-" + filename));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/";
	}

	@RequestMapping("03")
	public String upload03(@RequestPart("doraemon") Part doraemon) {
		try {
			String contentType = doraemon.getContentType();
			System.out.println("contentType -> " + contentType);
			System.out.println(doraemon.getSubmittedFileName());
			doraemon.write("test03/" + System.currentTimeMillis() + "-"
					+ doraemon.getSubmittedFileName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/";
	}

}
