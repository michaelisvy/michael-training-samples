package aop.pointcut;

import org.springframework.web.bind.annotation.RequestParam;

interface ClientService {
	public void findClient(@RequestParam String string);

}