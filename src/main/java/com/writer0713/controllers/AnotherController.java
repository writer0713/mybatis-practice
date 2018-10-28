package com.writer0713.controllers;

import com.writer0713.domains.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/another")
public class AnotherController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnotherController.class);

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		Object target = binder.getTarget();
		if(target instanceof User) {
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//			binder.registerCustomEditor(Date.class, "birth", new CustomDateEditor(dateFormat, true));
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

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		return formattedDate;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity addUser(@RequestBody @Valid User user,
																BindingResult result) {

		if(result.hasErrors()) {
			for(ObjectError err : result.getAllErrors()) {
				System.out.println("ERROR ::: " + err.getCode());
			}

			return ResponseEntity.badRequest().body(result.getAllErrors());
		}

		return ResponseEntity.ok().body(user);
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
