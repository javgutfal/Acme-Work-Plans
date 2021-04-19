package acme.features.administrator.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.TaskDashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorTaskDashboardShowService implements AbstractShowService<Administrator, TaskDashboard> {
	
	@Autowired
	protected AdministratorTaskRepository repository;

	@Override
	public boolean authorise(final Request<TaskDashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<TaskDashboard> request, final TaskDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, 
			"publicTaskNumber", "privateTaskNumber", "finishedTaskNumber", "notFinishedTaskNumber", 
			"averageNumberOfExecutionPeriod", "deviationNumberOfExecutionPeriod", "minExecutionPeriod", 
			"maxExecutionPeriod", "averageNumberOfWorkload", "deviationNumberOfWorkload", 
			"minWorkload", "maxWorkload");
	}

	@Override
	public TaskDashboard findOne(final Request<TaskDashboard> request) {
		assert request != null;
		
		TaskDashboard result;
		Long publicTaskNumber;
		Long privateTaskNumber;		
		Long finishedTaskNumber;		
		Long notFinishedTaskNumber;		
//		Double averageNumberOfExecutionPeriod;		
//		Double deviationNumberOfExecutionPeriod;		
//		Double minExecutionPeriod;		
//		Double maxExecutionPeriod;		
//		Double averageNumberOfWorkload;		
//		Double deviationNumberOfWorkload;		
//		Double minWorkload;		
//		Double maxWorkload;
		
		publicTaskNumber = this.repository.getPublicTaskNumber();
		privateTaskNumber = this.repository.getPrivateTaskNumber();
		finishedTaskNumber = this.repository.getFinishedTaskNumber();
		notFinishedTaskNumber = this.repository.getNotFinishedTaskNumber();
//		averageNumberOfExecutionPeriod = this.repository.averageNumberOfExecutionPeriod();
//		deviationNumberOfExecutionPeriod = this.repository.deviationNumberOfExecutionPeriod();
//		minExecutionPeriod = this.repository.minExecutionPeriod();
//		maxExecutionPeriod = this.repository.maxExecutionPeriod();
//		averageNumberOfWorkload = this.repository.averageNumberOfWorkload();
//		deviationNumberOfWorkload = this.repository.deviationNumberOfWorkload();
//		minWorkload = this.repository.minWorkload();
//		maxWorkload = this.repository.maxWorkload();
		
		result = new TaskDashboard();
		result.setPublicTaskNumber(publicTaskNumber);
		result.setPrivateTaskNumber(privateTaskNumber);
		result.setFinishedTaskNumber(finishedTaskNumber);
		result.setNotFinishedTaskNumber(notFinishedTaskNumber);
//		result.setAverageNumberOfExecutionPeriod(averageNumberOfExecutionPeriod);
//		result.setDeviationNumberOfExecutionPeriod(deviationNumberOfExecutionPeriod);
//		result.setMinExecutionPeriod(minExecutionPeriod);
//		result.setMaxExecutionPeriod(maxExecutionPeriod);
//		result.setAverageNumberOfWorkload(averageNumberOfWorkload);
//		result.setDeviationNumberOfWorkload(deviationNumberOfWorkload);
//		result.setMinWorkload(minWorkload);
//		result.setMaxWorkload(maxWorkload);
		
		return result;
	}

}
