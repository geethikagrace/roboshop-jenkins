def call() {
    pipeline{


        agent{
            node{
                label
            }
        }
        options {
            ansiColor('xterm')
        }




        stages{

        }
        post{
            always {
                cleanWs()
            }
        }
    }
}