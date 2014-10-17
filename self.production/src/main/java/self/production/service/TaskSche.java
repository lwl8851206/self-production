package self.production.service;

public class TaskSche {
	private TaskExecutor taskExecutor;
	public TaskSche(TaskExecutor taskExecutor) {
		// TODO Auto-generated constructor stub
		 this.taskExecutor = taskExecutor; 
	}
	
    public void printMessages() {   
        for(int i = 0; i < 25; i++) {     
            taskExecutor.execute(new MessagePrinterTask("Message" + i));   
        } 
    }
     
     
    private class MessagePrinterTask implements Runnable {   
        private String message;   
        public MessagePrinterTask(String message) {     
            this.message = message;   
        }   
        public void run() {     
            System.out.println(message);   
        }
    }

}
