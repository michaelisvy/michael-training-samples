package aop.pointcut;

import org.springframework.web.bind.annotation.RequestParam;

class ClientServiceImpl implements ClientService {
	public void findClient(@RequestParam String string) {
		System.out.println("**** test");
	}

}
