package testasync

import grails.transaction.Transactional
import grails.util.Holders

@Transactional
class AsyncService {

    def fooService

    /**
     * Run an async task
     * @return
     */
    def runTask(String serviceName, String serviceMethod, Map parameters){
        Task newTask = new Task(status: TaskStatus.ONGOING)
        newTask.save()
        runAsync {
            Holders.getApplicationContext().getBean(serviceName)."${serviceMethod}"()
            //fooService.longTask()
            newTask.setStatus(TaskStatus.ENDED)
            newTask.save()
        }
        return newTask
    }
}
