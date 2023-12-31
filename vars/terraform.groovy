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

        parameters {
            choice(name: 'env', choices: ['dev', 'prod'], description: 'choose environment ')

        }


        stages{
            stage (' Terraform Init'){

                steps{
                    sh 'terraform init -backend-config=env-${env}/state.tfvars'
                }
            }


            stage ('terraform Apply'){
                steps{
                    sh 'terraform apply -auto-approve -var-file=env-${env}/main.tfvars'
                }
            }


            post{
                always {
                    cleanWs()
                }
            }
        }
    }
}