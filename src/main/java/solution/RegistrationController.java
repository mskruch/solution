package solution;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import solution.exceptions.UserAlreadyRegistered;

@Controller
@RequestMapping({ "/registration", "/" })
public class RegistrationController
{
	static final Logger logger = LoggerFactory
		.getLogger(RegistrationController.class);

	@Autowired
	private Registration registration;

	@RequestMapping(method = GET)
	public String show(Model model)
	{
		model.addAttribute("registrationForm", new RegistrationForm());
		return "registration";
	}

	@RequestMapping(method = POST)
	public String register(
		@Valid RegistrationForm form, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			logger.debug("validation failed");
			return "registration";
		}

		try {
			registration.register(form.getUsername(), form.getPassword());
		} catch (UserAlreadyRegistered e) {
			/*
			 * Although the unique constraint is checked before the register
			 * method is called, there's always a chance that the user is
			 * registered in between by another thread so here is the double
			 * check
			 */
			bindingResult.rejectValue("username", "validation.uniqueUsername");
			return "registration";
		}

		return "redirect:/registered";
	}

}
