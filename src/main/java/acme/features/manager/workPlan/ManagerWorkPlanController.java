package acme.features.manager.workPlan;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.roles.Manager;
import acme.entities.workPlans.WorkPlan;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/manager/workPlans/")
public class ManagerWorkPlanController extends AbstractController<Manager, WorkPlan> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ManagerWorkPlanListMineService listService;

	@Autowired
	private ManagerWorkPlanCreateService	createService;
	
	@Autowired
	private ManagerWorkPlanDeleteService	deleteService;
	
	@Autowired
	private ManagerWorkPlanPublishService	publishService;
	
	@Autowired
	private ManagerWorkPlanShowService	showService;

	@Autowired
	private ManagerWorkPlanUpdateService	updateService;

	

	

	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addCustomCommand(CustomCommand.PUBLISH, BasicCommand.UPDATE, this.publishService);
	}

}
