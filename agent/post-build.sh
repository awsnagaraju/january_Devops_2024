pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "building"
            }
        }
    }
    post {
        sucess {
            echo "pipeline succeeded!"
        }
        failure {
            echo "pipeline failed!"
        }
    }
}