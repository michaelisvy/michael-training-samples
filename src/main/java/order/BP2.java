package order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class BP2 implements Ordered, BeanPostProcessor{
	
	private static final Logger log = LoggerFactory.getLogger(BP2.class);

	
	private int order;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.warn("before init 2 " + bean.toString());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.warn("before init 2 " + bean.toString());
		return bean;
	}

	@Override
	public int getOrder() {
		return this.order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	
	

}
