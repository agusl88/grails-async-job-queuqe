package testasync

import grails.converters.JSON

class TestController {

    def asyncService

    def index(){
        render view: 'index'
    }

    /**
     * Create a new task
     * @return
     */
    def newTask() {
        Task newTask = asyncService.runTask('fooService', 'longTask', [:])
        def resultMap = [taskID: newTask.id]
        render resultMap as JSON
    }

    /**
     * Return the task status
     * @param id task id
     * @return
     */
    def checkTaskStatus(Long id){
        def resultMap = [status: Task.get(id).status.toString()]
        render resultMap as JSON
    }
}