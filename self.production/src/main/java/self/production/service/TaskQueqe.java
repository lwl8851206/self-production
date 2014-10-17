package self.production.service;

import java.util.Stack;



public class TaskQueqe implements Runnable{
	private Stack<ITask> unDoTaskList;
	private Stack<ITask> doneTaskList;
	private ITask currentTask;
	
	public TaskQueqe() {
		this.unDoTaskList = new Stack<ITask>();
		this.doneTaskList = new Stack<ITask>();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 获取已执行完毕的任务队列
	 * @return
	 */
	public Stack<ITask> getdoneTaskList() {
		return this.doneTaskList;
	}
	
	/**
	 * 获取未执行的任务队列
	 * @return
	 */
	public Stack<ITask> getUndoTaskList() {
		return this.unDoTaskList;
	}
	
	/**
	 * 获取当前正在执行的任务队列
	 * @return
	 */
	public ITask getCurrentTask() {
		return this.currentTask;
	}
	
	/**
	 * 将任务加入到当前任务队列当中
	 * @param task
	 */
	public void addTask(ITask task) {
		this.unDoTaskList.push(task);
	}
	
	/**
	 * 执行任务
	 */
	public  void runTask() {
		ITask task = null;
		while (!(unDoTaskList.isEmpty())) {
				task = unDoTaskList.pop();
				task.run();
				while (task.getStatus() != 1);
				doneTaskList.push(task);
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			this.runTask();
		}
	}

}
