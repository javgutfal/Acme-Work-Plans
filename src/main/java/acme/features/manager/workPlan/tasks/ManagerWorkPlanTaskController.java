package acme.features.manager.workPlan.tasks;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/manager/workPlan/task/")
public class ManagerWorkPlanTaskController extends AbstractController<Manager, Task> {

	// Internal state ---------------------------------------------------------
	@Autowired
	private ManagerWorkPlanTaskListWorkPlanService	listService;
	
	@Autowired
	private ManagerWorkPlanTaskListNotWorkPlanService	listNotWorkPlanService;
	
	@Autowired
	private ManagerWorkPlanTaskShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addCustomCommand(CustomCommand.LIST_NOT_WORKPLAN, BasicCommand.LIST, this.listNotWorkPlanService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		
	}

}
