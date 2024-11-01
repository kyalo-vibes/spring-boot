package com.kyalo.example;

import com.kyalo.example.order.Order;
import com.kyalo.example.order.OrderRecord;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Jambo from this side";
    }

    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        return "Jambo namba 2";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ){
        return "Resource created. Message is : " + message;
    }

    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ){
        return "Resource created. Order is : " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ){
        return "Resource created. Order is : " + order.toString();
    }

    @GetMapping("/hello-3/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
    ) {
        return "Jambo namba 3. Value : " + userName;
    }

    @GetMapping("/hello-4")
    public String paramRequest(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return "Value is : " + firstName + " " + lastName;
    }
}
