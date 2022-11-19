pipeline {
    agent any
    stages {
        stage('CheckOut') {
            steps{
            checkout([ $class: 'GitSCM', branches: [[name: gitbranch ]], userRemoteConfigs: [[ url: buildrepo ]]   ])
                }
            }
        stage('Build AMI'){
            steps{
                sh '''
                cd /var/jenkins_home/workspace/packer-build-ami/amis/
                packer build  ${packerFile}
                '''
                }
            }
        }
    }