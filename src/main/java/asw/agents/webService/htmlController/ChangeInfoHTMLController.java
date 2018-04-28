package asw.agents.webService.htmlController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import asw.agents.util.Assert;
import asw.agents.webService.responses.errors.ErrorResponse;
import asw.dbManagement.UpdateInfo;
import asw.dbManagement.model.Agent;

@Controller
public class ChangeInfoHTMLController {
	@Autowired
	private UpdateInfo updateInfo;

	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changeInfo(BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/datosAgent";
		}
		return "changeInfo";
	}
	
	@RequestMapping(value = "/confirmPassword", method = RequestMethod.GET)
	public String changePassword(Model model) {
		return "changeInfo";
	}

	@RequestMapping(value = "/confirmPassword", method = RequestMethod.POST)
	public String changePassword(HttpSession session, @RequestParam String password,
			@RequestParam String newPassword, Model model) {
		Assert.isPasswordEmpty(password);
		Assert.isPasswordEmpty(newPassword);
		Assert.isSamePassword(password, newPassword);

		// Agente que se ha logeado antes
		Agent p = (Agent) session.getAttribute("agent");
		Assert.isAgentNull(p);
		Assert.isPasswordCorrect(password, p);

		// Actualizo sus datos
		updateInfo.updatePassword(p, password, newPassword);

		// Mensaje a mostrar en HTML
		model.addAttribute("info", "Contraseña actualizada correctamente");
		return "redirect:/datosAgent";
	}
	
	@RequestMapping(value = "/confirmEmail", method = RequestMethod.POST)
	public String changeEmail(HttpSession session, @RequestParam String email, Model model) {
		Assert.isEmailEmpty(email);
		Assert.isEmailValid(email);

		// Agente que se ha logeado antes
		Agent p = (Agent) session.getAttribute("agent");
		Assert.isAgentNull(p);
		Assert.isSameEmail(email, p.getEmail());

		// Actualizo sus datos
		updateInfo.updateEmail(p, email);

		// Mensaje a mostrar en HTML
		model.addAttribute("info", "Email actualizado correctamente");
		return "redirect:/datosAgent";
	}
	
	@RequestMapping(value = "/confirmNombre", method = RequestMethod.POST)
	public String changeNombre(HttpSession session, @RequestParam String nombre, Model model) {
		Assert.isNombreEmpty(nombre);

		// Agente que se ha logeado antes
		Agent p = (Agent) session.getAttribute("agent");
		Assert.isAgentNull(p);
		Assert.isSameEmail(nombre, p.getNombre());

		// Actualizo sus datos
		updateInfo.updateName(p, nombre);

		// Mensaje a mostrar en HTML
		model.addAttribute("info", "nombre actualizado correctamente");
		return "redirect:/datosAgent";
	}
	
	@RequestMapping(value = "/confirmLocalizacion", method = RequestMethod.POST)
	public String changeLocalizacion(HttpSession session, @RequestParam String localizacion, Model model) {
		
		Assert.isLocalizacionValid(localizacion);
		//Assert.isLocalizacionEmpty(localizacion);

		// Agente que se ha logeado antes
		Agent p = (Agent) session.getAttribute("agent");
		Assert.isAgentNull(p);
		Assert.isSameLocalizacion(localizacion, p.getNombre());

		// Actualizo sus datos
		updateInfo.updateLocalizacion(p, localizacion);

		// Mensaje a mostrar en HTML
		model.addAttribute("info", "localizacion actualizada correctamente");
		return "redirect:/datosAgent";
	}

	@ExceptionHandler(ErrorResponse.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponseNotFound(ErrorResponse excep, Model model) {
		model.addAttribute("error", excep.getMessageStringFormat());
		return "error";
	}
}
