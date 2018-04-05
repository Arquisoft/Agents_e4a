package asw.agents.webService.htmlController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import asw.agents.util.Assert;
import asw.agents.webService.responses.errors.ErrorResponse;
import asw.dbManagement.impl.GetAgentImpl;
import asw.dbManagement.model.Agent;

@Controller
public class GetAgentInfoHTMLController {

	@Autowired
	private GetAgentImpl getAgent;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicalicerLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getLogin(HttpSession session, @RequestParam String login, @RequestParam String password, @RequestParam String kind,
			Model model) {

		Assert.isLoginEmpty(login);
		Assert.isPasswordEmpty(password);
		Assert.isKindEmpty(kind);

		Agent agente = getAgent.getAgent(login);

		Assert.isAgentNull(agente);
		Assert.isPasswordCorrect(password, agente);
		Assert.isKindCorrect(kind, agente);

		session.setAttribute("agent", agente);

		return "datosAgent";
	}

	@ExceptionHandler(ErrorResponse.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponseNotFound(ErrorResponse excep, Model model) {
		model.addAttribute("error", excep.getMessageStringFormat());

		return "error";
	}
}
