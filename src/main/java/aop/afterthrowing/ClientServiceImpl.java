package aop.afterthrowing;

import org.springframework.dao.DataAccessResourceFailureException;


class ClientServiceImpl implements ClientService {
	public void findClient(String string) {
		throw new DataAccessResourceFailureException("this is a test exception") { 
		};
	}

}
