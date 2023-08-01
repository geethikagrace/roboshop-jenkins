def call(int buildNumber) {
    pipeline{


        agent{
            node{
                label
            }
        }

        parameters {
            choice(name: 'env', choices: ['dev', 'prod'], description: 'choose environment ')
            //  choice(name: 'action', choices: ['apply', 'destroy'], description: 'choose action ')

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