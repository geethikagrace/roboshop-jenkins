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
            stage ('code quality'){
                steps{
                    sh 'sonar-scanner -Dsonar.projectkey=${component} -Dsonar.host.url = http://172.31.82.179:9000 -Dsonar.login=admin -Dsonar.password=admin123'
                }
            }
            stage ('Unit Test Cases'){
                steps{
                    sh 'echo Unit Test Cases'
                }
            }
            stage ('Chechmarx SAST scan'){
                steps{
                    sh 'echo Chechmarx SAST scan'
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