package thashort.gamer.smsapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sms")
public class smsController {

    @GetMapping()
    public String runApp(){
        return "Successful";
    }
}
