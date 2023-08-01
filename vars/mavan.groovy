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
            stage (code compile){
                steps{
                    sh 'code compile'
                }
            }
            stage (code quality){
                steps{
                    sh 'sonar-scanner '
                }
            }
            stage (Unit Test Cases){
                steps{
                    sh 'Unit Test Cases'
                }
            }
            stage (Chechmarx SAST scan){
                steps{
                    sh 'Chechmarx SAST scan'
                }
            }
            stage (Chechmarx SCA scan){
                steps{
                    sh 'Chechmarx SCA scan'
                }
            }

        }
        post{
            always {
                cleanWs()
            }
        }
    }
}