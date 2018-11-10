package com.writer0713.controllers;

import com.writer0713.domains.User;
import com.writer0713.domains.UserWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.transform.stream.StreamSource;
import java.beans.PropertyEditorSupport;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/another")
@PropertySource("classpath:properties/user.properties")
public class AnotherController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnotherController.class);

	@Autowired
	private Jaxb2Marshaller marshaller;

	@Value("${papago.name}")
	private String name;

	@Value("${papago.password}")
	private String password;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if(target instanceof User) {
			binder.registerCustomEditor(Date.class, "birth", new PropertyEditorSupport() {
				@Override
				public void setAsText(String text) throws IllegalArgumentException {
					setValue(text);
				}

				@Override
				public String getAsText() {
					Date date = (Date) getValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy, mm, dd");
					String formmatedDate = dateFormat.format(date);

					return formmatedDate;
				}
			});
		}
	}

	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public String dateFormat(@DateTimeFormat(pattern = "yyyy**MM**dd") @RequestParam("date") Date date) {

		System.out.println("date : " + date);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = format.format(date);

		return formattedDate;
	}

	@RequestMapping(value = "/number", method = RequestMethod.GET)
	public String dateFormat(@RequestParam("money") Long money) {

		System.out.println("money : " + money);



		return String.valueOf(money);
	}

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		return formattedDate;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity addUser(@RequestBody @Valid User user, BindingResult result) {

		if(result.hasErrors()) {
			for(ObjectError err : result.getAllErrors()) {
				System.out.println("ERROR ::: " + err.getCode());
			}

			return ResponseEntity.badRequest().body(result.getAllErrors());
		}

		return ResponseEntity.ok().body(user);
	}

	@RequestMapping(value = "/user2", method = RequestMethod.POST)
	public ResponseEntity addUser2(@RequestParam String[] hobbies) {

		return ResponseEntity.ok().body(hobbies);
	}

	@RequestMapping(value = "/papago", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserFromProperties() {
		User user = new User();
		user.setUsername(name);

		return user;
	}

	@RequestMapping(value="/user.xml", produces="application/xml")
	public UserWrapper getUserXML() {
		User user = new User();
		user.setUsername("kim");
		user.setPassword("kim");
		user.setBirth(new Date());
		user.setHobbies(new String[]{"swim"});

		User user1 = new User();
		user1.setUsername("park");
		user1.setPassword("park");
		user1.setBirth(new Date());
		user1.setHobbies(new String[]{"basketball"});

		User user2 = new User();
		user2.setUsername("lee");
		user2.setPassword("lee");
		user2.setBirth(new Date());
		user2.setHobbies(new String[]{"health"});

		UserWrapper wrapper = new UserWrapper();
		wrapper.addUser(user);
		wrapper.addUser(user1);
		wrapper.addUser(user2);

		return wrapper;
	}

	@RequestMapping(value="/user.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserObject() throws FileNotFoundException {
		User user = (User) marshaller.unmarshal(new StreamSource(ResourceUtils.getFile("classpath:xmlDatas/user.xml")));
		System.out.println("User : " + user);

		return user;
	}

	@RequestMapping(value = "/occurException", method = RequestMethod.GET)
	public void occurException() throws Exception {
		throw new Exception("occur Exception and handle it locally");
	}

	@ExceptionHandler
	public String handleLocalException(HttpServletRequest req, Exception ex) {
		logger.error("handle Exception locally");

		return ex.getMessage();
	}

	@PostConstruct
	private void init() {
		logger.info("{}", "Another Controller :: init method :: @PostConstruct :: is called");
	}

	@PreDestroy
	private void destroy() {
		logger.info("{}", "Another Controller :: destroy method :: @PreDestroy :: is called");
	}
	
}
