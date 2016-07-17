package cn.heweiming.up.controller.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.heweiming.up.util.QRCodeUtil;

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

    @RequestMapping("02")
    @ResponseBody
    public String demo02() {

        return null;
    }

    @RequestMapping("03")
    @ResponseBody
    public byte[] demo03() {
        byte[] data = null;
        try {
            data = "2016年7月2日".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return data;
    }

    @RequestMapping("04")
    @ResponseBody
    public byte[] demo04() {
        byte[] data = null;
        try (InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("img/Doraemon.jpg")) {
            data = new byte[in.available()];
            int read = in.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @RequestMapping("05")
    @ResponseBody
    public byte[] demo05() {
        return QRCodeUtil.generatorQRCode("http://www.baidu.com");
    }

    @RequestMapping("qrcode")
    @ResponseBody
    public byte[] qrcode(String content) {
        System.out.println(content != null ? content.getBytes().length : null);
        return QRCodeUtil.generatorQRCode(content);
    }


}
