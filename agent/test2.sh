pipeline {
    agent any
    stages {
        stage('Build and Test') {
            steps {
                echo "Building and Testing..."
            }
        }
    }
}