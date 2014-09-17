package testasync

class FooService {

    static transactional = false

    def longTask(){
        println 'Task started'
        println 'Waiting 30 seconds...'
        Thread.sleep(30000)
        println 'Task Complete.'
    }

    def longTask2(){
        println 'Task started'
        println 'Waiting 60 seconds...'
        Thread.sleep(60000)
        println 'Task Complete.'
    }
}
