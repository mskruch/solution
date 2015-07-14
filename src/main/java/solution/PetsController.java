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

import solution.exceptions.UserNotFound;

@Controller
@RequestMapping("/pets")
public class PetsController
{
	static final Logger logger = LoggerFactory.getLogger(PetsController.class);

	@Autowired
	private Pets pets;

	@RequestMapping(method = GET)
	public String show(Model model)
	{
		model.addAttribute("petsForm", new PetsForm());
		return "pets";
	}

	@RequestMapping(method = POST)
	public String addPet(@Valid PetsForm form, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			logger.debug("validation failed");
			return "pets";
		}

		try {
			pets.addPet(form.getUsername(), form.getPetName());
		} catch (UserNotFound e) {
			bindingResult.rejectValue("username", "validation.userNotFound");
			return "pets";
		}

		return "redirect:/pets";
	}

}
