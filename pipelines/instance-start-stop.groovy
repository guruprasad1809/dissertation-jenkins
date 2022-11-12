pipeline {
    agent any
    stages {
        stage('Start Instance') {
            steps {
                    
                    script{
                    if (params.Action=='start') {
                        echo "Starting Instance"
                        sh (script:"aws ec2 start-instances --instance-ids ${instanceid.trim()} --region $region || true" , returnStdout:true)
                    }
                }
            }    
        }
        stage('Stopping Instance'){
            steps {
                    script{
                    if (params.Action=='stop') {
                        echo "Stopping Instance"
                        /*sh (script:"aws ec2 stop-instances --instance-ids ${instanceid.trim()} --region $region || true" , returnStdout:true)*/
                    }
                }
            }
        }
        stage('Terminate Instance'){
            steps {
                    script{
                    if (params.Action=='terminate') {
                        echo "Terminating Instance"
                        /*sh (script:"aws ec2 terminate-instances --instance-ids ${instanceid.trim()} --region $region || true" , returnStdout:true)*/
                    }
                }
            }
        }
    }
}
