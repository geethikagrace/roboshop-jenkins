def call() {
    pipeline{


        agent{
            node{
                label 'workstation'
            }
        }
        options {
            ansiColor('xterm')
        }




        stages{
            stage ('code compile'){
                steps{
                    sh 'echo code compile'
                }
            }
            stage ('code quality'){
                steps{
                    sh 'echo sonar-scanner '
                }
            }
            stage ('Unit Test Cases'){
                steps{
                    sh 'echo Unit Test Cases'
                }
            }
            stage ('Chechmarx SAST scan'){
                steps{
                    sh ' echo Chechmarx SAST scan'
                }
            }
            stage ('Chechmarx SCA scan'){
                steps{
                    sh 'echo Chechmarx SCA scan'
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