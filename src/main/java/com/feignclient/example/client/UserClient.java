package com.feignclient.example.client;

import com.feignclient.example.config.FeignConfiguration;
import com.feignclient.example.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "user" , url = "http://localhost:8080", configuration = FeignConfiguration.class)
public interface UserClient {

    //@ErrorHandling(codeSpecific = {
    //        @ErrorCodes(codes = {404}, generate = UserNotFoundException.class),
    //}, defaultException = YourDefaultException.class)
    @RequestMapping(method = RequestMethod.GET,path = "/users")
    List<User> getUsers();
}
