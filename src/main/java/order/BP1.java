package order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class BP1 implements Ordered, BeanPostProcessor{

	private static final Logger log = LoggerFactory.getLogger(BP1.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.warn("before init 1 " + bean.toString());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.warn("before init 2 " + bean.toString());
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}
	
	
	

}
