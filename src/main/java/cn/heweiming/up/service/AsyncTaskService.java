package cn.heweiming.up.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

	@Async
	public void executeAsyncTask1() {
		System.out.print("11111");
		System.out.println("\t" + Thread.currentThread().getName());
	}

	@Async
	public void executeAsyncTask2() {
		System.out.print("22222");
		System.out.println("\t" + Thread.currentThread().getName());
	}

}
