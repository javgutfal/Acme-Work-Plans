
package acme.features.administrator.variables.percents;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.variables.Percent;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/variable/percent/")
public class AdministratorPercentController extends AbstractController<Administrator, Percent> {

	// Internal state ---------------------------------------------------------
	@Autowired
	protected AdministratorPercentListService		listService;

	@Autowired
	protected AdministratorPercentShowService		showService;

	@Autowired
	protected AdministratorPercentUpdateService		updateService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}
