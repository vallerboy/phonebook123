package pl.oskarpolak.phonebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/") //@RequestMapping(method = GET, value = "/")
    public String  index() {
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("name") String name,
                        @RequestParam("surname") String surname,
                        @RequestParam("message") String message){
        System.out.println(name); //debug
        return "index";
    }

}
