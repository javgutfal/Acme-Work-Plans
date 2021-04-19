package acme.features.manager.tasks;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/manager/task/")
public class ManagerTaskController extends AbstractController<Manager, Task>{
	
	// Internal state ---------------------------------------------------------
		@Autowired
		private ManagerTaskCreateService createService;

		// Constructors -----------------------------------------------------------
		
		@PostConstruct
		private void initialise() {
			
			super.addBasicCommand(BasicCommand.CREATE, this.createService);
		}

}
