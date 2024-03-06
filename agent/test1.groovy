pipeline {
    agent any
    //  Using an Agent   
    //  this pipeline runs any available agent (slaves/executors/build-in Node)
    stages {
        //  this is the build stage
        stage('Build') {
            steps {
                echo "Building..."
                //  print the exists and nonexists file in the path.write a bash script.
                sh ''' 
                #!/bin/bash
                if [ -e "$1"]
                then
                    echo "exist file is $1"
                else
                    echo "nonexist  file is $1"
                '''      
            }
        }
    }
}
pipeline {
    agent any  
    //  User Input Step
    //   the pipeline runs any available agent (slaves/master)
    stages {
        //   this is the Test stage
        stage('Test') {
            steps {
                echo "Testing"
                //  to approvethe test before proceeding
                input(message: 'press OK to continue', submitter: 'user1,user2')   
            }
        }
    }
}
pipeline {
    agent any
    //  Using Parameters
    //  The parameters directive lets you define parameters for your pipeline.
    parameters {
        string(name: 'NAME', description: 'please tell me your name')
        test(name: 'DESC', description: 'Decribe the job details')
        booleanParam(name: 'SKIP_TEST', description: 'skip the running the test cases')
    } 
    stages {
        //  this is the Delivery stage
        stage('Delivery') {
            steps {
                echo "Hello, ${params.NAME}!"
            }
        }
    }
}
pipeline {
    agent any 
    stages {
        //  this the deploy stage
        stage ('Deploy') {
            steps {
                echo "deploying"
            }
        }
    }
}
