package asw.agents.webService.htmlController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String inicalicerLogin(Model model) {
		return "redirect:/login";
	}
}