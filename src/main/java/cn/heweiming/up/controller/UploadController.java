package cn.heweiming.up.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("01")
	public String upload01(@RequestPart("doraemon") byte[] doraemon) {
		// IOUtils.
		return "home";
	}

	@RequestMapping("02")
	public String upload02(@RequestParam("doraemon") MultipartFile doraemon) {
		String filename = doraemon.getOriginalFilename();
		try {
			doraemon.transferTo(
					new File("test02/" + System.currentTimeMillis() + "-" + filename));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/";
	}

	@RequestMapping("03")
	public String upload03(@RequestPart("doraemon") Part doraemon) {
		try {
			String name = doraemon.getName();
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
