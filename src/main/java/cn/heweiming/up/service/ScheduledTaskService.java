package cn.heweiming.up.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	@Scheduled(fixedRate = 1000 * 10) // 每隔固定10秒执行一次
	public void reportCurrentTime() {
		System.err.println("Scheduling Tasks Examples: The time is now " + dateFormat().format(new Date()));
	}

	@Scheduled(cron = "0/5 * *  * * * ") // 每5秒钟执行一次
	public void reportCurrentByCron() {
		System.err.println("Scheduling Tasks Examples By Cron: The time is now " + dateFormat().format(new Date()));
	}

	private SimpleDateFormat dateFormat() {
		return new SimpleDateFormat("HH:mm:ss");
	}
}
