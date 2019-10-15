package edu.northeastern.cs5200;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HelloController {
	@RequestMapping("/")
    public String sayHelloHtml() {
        return "Hello Xinyu tang, html!";
    }

    @RequestMapping("/api/hello/string")
    public String sayHelloString() {
        return "Hello Xinyu tang, string!";
    }

    @RequestMapping("/api/hello/object")
    public HelloObject sayHelloObject() {
        HelloObject obj = new HelloObject("Hello Xinyu tang, object!");
        return obj;
    }

    @Autowired
    HelloRepository helloRepository;

    @RequestMapping("/api/hello/insert")
    public HelloObject insertHelloObject() {
        HelloObject obj = new HelloObject("Hello Xinyu tang!");
        helloRepository.save(obj);
        return obj;
    }

    @RequestMapping("/api/hello/insert/{msg}")
    public HelloObject insertMessage(@PathVariable("msg") String message) {
        HelloObject obj = new HelloObject(message);
        helloRepository.save(obj);
        return obj;
    }

    @RequestMapping("/api/hello/select/all")
    public List<HelloObject> selectAllHelloObjects() {
        List<HelloObject> hellos =
                (List<HelloObject>)helloRepository.findAll();
        return hellos;
	}
}
