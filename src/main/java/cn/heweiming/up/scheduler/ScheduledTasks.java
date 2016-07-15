package cn.heweiming.up.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.heweiming.up.model.User;

//@Component
//@Configurable
//@EnableScheduling
public class ScheduledTasks {
	
	@Autowired
	private User user;

	@Scheduled(fixedRate = 1000 * 30)
	public void reportCurrentTime() {
		System.err.println("Scheduling Tasks Examples: The time is now " + dateFormat().format(new Date()));
	}

	// 每5秒钟执行一次
	@Scheduled(cron = "0/5 * *  * * * ")
	public void reportCurrentByCron() {
		System.err.println(JSON.toJSONString(user));
		System.err.println("Scheduling Tasks Examples By Cron: The time is now " + dateFormat().format(new Date()));
	}

	private SimpleDateFormat dateFormat() {
		return new SimpleDateFormat("HH:mm:ss");
	}

}
