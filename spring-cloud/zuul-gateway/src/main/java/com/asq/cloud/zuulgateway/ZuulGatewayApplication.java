package com.asq.cloud.zuulgateway;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
	/**
	 * 低版本直接启动即可使用 http://ip:port/hystrix.stream 查看监控信息
	 * 高版本需要添加本方法方可使用 http://ip:port/hystix.stream 查看监控信息
	 * Spring boot 2.0 后 需要添加以下代码 ，才可以调取监控
	 * PS：HystrixMetricsStreamServlet  该类需要依赖以下jar包，否则报错
	 <dependency>
	 <groupId>com.netflix.hystrix</groupId>
	 <artifactId>hystrix-metrics-event-stream</artifactId>
	 <version>1.5.12</version>
	 </dependency>
	 *
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

	/**
	 * 	使用正则表达式指定zuul 的路由匹配规则
	 */
//	@Bean
//	public PatternServiceRouteMapper serviceRouteMapper(){
//
//		// 调用构造函数PatternServiceRouteMapper(String  servicePattern,String routePattern)
//		//servicePattern 指定微服务的正则
//		//routePattern  指定路由正则
//		return new PatternServiceRouteMapper("","");
//	}
}

