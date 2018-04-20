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
import org.springframework.web.bind.annotation.RestController;

import asw.agents.util.Assert;
import asw.agents.webService.responses.errors.ErrorResponse;
import asw.dbManagement.UpdateInfo;
import asw.dbManagement.impl.GetAgentImpl;
import asw.dbManagement.model.Agent;

@Controller
public class IndexHTMLController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String inicalicerLogin(Model model) {
		return "index";
	}
}
