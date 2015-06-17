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

@Controller
@RequestMapping({ "/registration", "/" })
public class RegistrationController
{
	static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

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
			logger.debug("Binding results occured: {}", bindingResult);
			return "registration";
		}

		registration.register(form.getUsername(), form.getPassword());

		return "redirect:/registered";
	}
	
}
