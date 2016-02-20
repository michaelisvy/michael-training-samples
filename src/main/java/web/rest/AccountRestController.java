package web.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import domain.Account;

@RestController
public class AccountRestController {
    
    @RequestMapping(value="/rest/account/{accountId}")
    public @ResponseBody Account getAccount(@PathVariable int accountId) {
        return new Account(accountId, 100.0, "Sam's account");
    }
    
    @RequestMapping(value="/rest/account/{accountId}/noannotation")
    public Account getAccountNoResponseBody(@PathVariable int accountId) {
        return new Account(accountId, 100.0, "Sam's account");
    }

}
