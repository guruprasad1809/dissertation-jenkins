node {

    if(Action == 'start')
    {
        stage ('Starting Instace')
        {
            echo "starting instance"
            startinstance()
        }
    }
    if(Action == 'stop')
    {
        stage ('Stopping Instance')
        {
            echo "Stopping Instace"
            stopinstance()
        }
    }
    if(Action == 'terminate')
    {
        stage('Terminating Instace')
        {
            echo "Terminating Instace"
            terminateinstance()
        }
    }
}
def startinstance()
{
    sh (script:"aws ec2 start-instances --instance-ids ${instaceid.trim()} || true , returnStdout:true")
    echo "Starting Instance"
    sh (script:"aws ec2 start-instances --instance-ids ${instaceid.trim()} || true , returnStdout:true")
    echo "Starting Instance"
}

