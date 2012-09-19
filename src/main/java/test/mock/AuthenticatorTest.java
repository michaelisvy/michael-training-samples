package test.mock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AuthenticatorTest {
	private AccountRepository accountRepository = createMock(AccountRepository.class);
    private Authenticator authenticator = new Authenticator(accountRepository) ;


    @Test public void validUserWithCorrectPassword() {
        expect(accountRepository.getAccount("lisa")).
            andReturn(new Account("lisa", "secret"));
        replay(accountRepository);
	  
	   boolean result = authenticator.authenticate("lisa", "secret"); 
        assertTrue(result);

        verify(accountRepository);
    }
}
