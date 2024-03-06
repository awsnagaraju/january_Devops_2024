pipeline {
    agent any
    //  Conditional Execution
    //  Use the when directive to conditionally execute stages based on specific criteria (e.g., branch name, environment variables).
    stages {
        stage('Build') {
            steps {
                echo "Building..."
            }
        }
        stage('Deploy to Staging') {
            when {
                expression { env.BRANCH_NAME =='main' }
            }
            steps {
                    echo "Deploy to staging environment"
            }
        }   

    }
}