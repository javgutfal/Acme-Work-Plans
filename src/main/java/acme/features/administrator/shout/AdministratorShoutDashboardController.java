package acme.features.administrator.shout;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.forms.ShoutDashboard;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/shoutdashboard/")
public class AdministratorShoutDashboardController extends  AbstractController<Administrator, ShoutDashboard>{
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AdministratorShoutDashboardShowService showService;

		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addBasicCommand(BasicCommand.SHOW, this.showService);
		}

}
