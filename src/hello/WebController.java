package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@RestController
public class WebController{

   
	@RequestMapping(value="/send")
    public ResponseEntity<User> get() {
		User user=new User();
		//user.setAccount(new Account("cos","ktos"));
		user.setAdmin(false);
		user.setVerify(false);
		user.setAutorization(false);
		user.setName("lolus");
		user.setMail("czop");
		user.setPhone(123456);
		user.setSurname("fdkal");
		user.setCommittee("fksldf");

        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
	
    @RequestMapping(value="/send", method=RequestMethod.POST)
    public ResponseEntity<User> checkPersonInfo(@RequestBody User user) {
    	DBUser db=new DBUser();
    	User userc=new User(user);
    	db.savePerson(userc);
    	db.finalize();
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
/* @Override
public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/results").setViewName("results");
}

@RequestMapping(value="/", method=RequestMethod.GET)
public String showForm(User personForm) {
    return "form";
}*/

