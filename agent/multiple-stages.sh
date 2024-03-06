pipeline {
    agent any
    //  Parallel Stages
    //  The parallel directive allows you to execute multiple stages concurrently. Its useful for speeding up your pipeline
    stages {
        stage('Build and Test') {
            steps {
                echo "Building and Testing..."
            }
        }
        stage('Deploy to staging') {
            steps {
                echo "Deploy to staging environment"
            }
        }
        stage('Deploy to production') {
            steps {
                echo "deploy to production environment"
            }
        }
    }
    post {
        always {
            echo "pipeline completed"
        }
    }
}
