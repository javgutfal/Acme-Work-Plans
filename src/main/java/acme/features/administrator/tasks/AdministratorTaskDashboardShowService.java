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
	protected AdministratorTaskDashBoardRepository repository;

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
			"averageOfExecutionTaskPeriod", "deviationOfExecutionTaskPeriod", "minExecutionTaskPeriod", 
			"maxExecutionTaskPeriod", "averageOfTaskWorkload", "deviationOfTaskWorkload", 
			"minTaskWorkload", "maxTaskWorkload");
	}

	@Override
	public TaskDashboard findOne(final Request<TaskDashboard> request) {
		assert request != null;

		TaskDashboard result;
		
		final Long publicTaskNumber;
		final Long privateTaskNumber;
		final Long finishedTaskNumber;
		final Long notFinishedTaskNumber;
		final Double averageOfExecutionTaskPeriod;
		final Double deviationOfExecutionTaskPeriod;
		final Double minExecutionTaskPeriod;
		final Double maxExecutionTaskPeriod;
		final Double averageOfTaskWorkload;
		final Double deviationOfTaskWorkload;
		final Double minTaskWorkload;
		final Double maxTaskWorkload;

		publicTaskNumber = this.repository.getPublicTaskNumber();
		privateTaskNumber = this.repository.getPrivateTaskNumber();
		finishedTaskNumber = this.repository.getFinishedTaskNumber();
		notFinishedTaskNumber = this.repository.getNotFinishedTaskNumber();
		averageOfExecutionTaskPeriod = this.repository.averageOfExecutionTaskPeriod();
		deviationOfExecutionTaskPeriod = this.repository.deviationOfExecutionTaskPeriod();
		minExecutionTaskPeriod = this.repository.minExecutionTaskPeriod();
		maxExecutionTaskPeriod = this.repository.maxExecutionTaskPeriod();
    	averageOfTaskWorkload = this.repository.averageOfTaskWorkload();
		deviationOfTaskWorkload = this.repository.deviationOfTaskWorkload();
		minTaskWorkload = this.repository.minTaskWorkload();
		maxTaskWorkload = this.repository.maxTaskWorkload();

		result = new TaskDashboard();
		result.setPublicTaskNumber(publicTaskNumber);
		result.setPrivateTaskNumber(privateTaskNumber);
		result.setFinishedTaskNumber(finishedTaskNumber);
		result.setNotFinishedTaskNumber(notFinishedTaskNumber);
		result.setAverageOfExecutionTaskPeriod(averageOfExecutionTaskPeriod);
		result.setDeviationOfExecutionTaskPeriod(deviationOfExecutionTaskPeriod);
		result.setMinExecutionTaskPeriod(minExecutionTaskPeriod);
		result.setMaxExecutionTaskPeriod(maxExecutionTaskPeriod);
		result.setAverageOfTaskWorkload(averageOfTaskWorkload);
		result.setDeviationOfTaskWorkload(deviationOfTaskWorkload);
		result.setMinTaskWorkload(minTaskWorkload);
		result.setMaxTaskWorkload(maxTaskWorkload);


		return result;
	}

}
