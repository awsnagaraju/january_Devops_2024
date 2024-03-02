pipeline {
    agent any   //  this pipeline runs any available agent (slaves/executors/build-in Node)
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
    agent any  //   the pipeline runs any available agent (slaves/master)
    stages {
        //   this is the Test stage
        stage('Test') {
            steps {
                echo "Testing"
                input(message: 'press OK to continue', submitter: 'user1,user2')   
            }
        }
    }
}
pipeline {
    agent any 
    stages {
        //  this is the Delivery stage
        stage('Delivery') {
            steps {
                echo "Delivering"

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
