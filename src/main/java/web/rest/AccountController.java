package web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Account;

@Controller
public class AccountController {
    
    @RequestMapping(value="/account/{accountId}")
    public @ResponseBody Account getAccount(@PathVariable int accountId) {
        return new Account(accountId, 100.0, "Sam's account");
    }
    
    @RequestMapping(value="/account/{accountId}/noannotation")
    public Account getAccountNoRespBody(@PathVariable int accountId) {
        return new Account(accountId, 100.0, "Sam's account");
    }

}
