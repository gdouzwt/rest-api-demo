package io.zwt.messaging.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import io.micrometer.core.instrument.MeterRegistry;

@Component
public class RestApiEventsListener implements ApplicationListener<ApplicationEvent> {

	private static final String LATEST = "/currency/latest";

	@Autowired
	private MeterRegistry registry;

	@Override
//	@Log(printParamsValues=true)
	public void onApplicationEvent(ApplicationEvent event) {

		if (event instanceof ServletRequestHandledEvent) {
			if (((ServletRequestHandledEvent) event)
					.getRequestUrl().equals(LATEST)) {
				registry.counter("url.currency.latest.hits", "hit")
				.increment();
			}
		}
	}
}

//		if(event instanceof ServletRequestHandledEvent) {
//			if((ServletRequestHandledEvent)event) {
//				.getRequestUrl().equals(LATEST)) {
//					registry.counter(name, tags)
//					.increment("url.currency.latest.hits");
//				}
//		}