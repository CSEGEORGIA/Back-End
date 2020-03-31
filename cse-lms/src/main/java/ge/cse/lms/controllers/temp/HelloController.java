package ge.cse.lms.controllers.temp;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "Hi User";
    }

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String hi2() {
        return "Hi Admin";
    }
}
