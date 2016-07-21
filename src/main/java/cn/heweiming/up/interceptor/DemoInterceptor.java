package cn.heweiming.up.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("_startTime", startTime);
		// return super.preHandle(request, response, handler);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long startTime = (Long) request.getAttribute("_startTime");
		request.removeAttribute("_startTime");
		// Long endTime = System.currentTimeMillis();
		Long handlingTime = System.currentTimeMillis() - startTime;
		// System.out.println("request.getRequestURI()\t" +
		// request.getRequestURI());
		// System.out.println("request.getRequestURL()\t" +
		// request.getRequestURL());
		System.out.println("本次请求处理时间为:\t" + handlingTime + "ms,请求地址\t" + request.getRequestURL());
		request.setAttribute("_handlingTime", handlingTime);
	}

}
