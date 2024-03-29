pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'sleep 5'
            }
        }

        stage('Test') {
            steps {
                sh '''
                    #!/bin/bash
                    ls -lrt
                    sleep 10
                 '''   

            }

        }
        stage('Trigger Maven-pipeline Job') {
            steps {
                 
                echo "/home/ubuntu/jenkins-s1/workspace/Maven-pipeline/agent-1/Mavenfile"
                build job: 'Maven-pipeline', wait: true
                echo 'Maven-pipeline job triggered successfully!'
            }
        }
    }   
}
    