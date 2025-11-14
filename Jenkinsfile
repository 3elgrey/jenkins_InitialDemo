pipeline {
    agent any

    parameters{

        booleanParam{defaultValue: false, description: "Production environment", name: "PROD"}
        string{defaultValue: "TEST", description: "Test scripts", name: "Testing"}
        choice{ choices: ["TEST", "DEV", "QA", "PRE-PROD"], description: "Environment to run the job", name: "Env"}
        
    }

    stages {
        stage('Clean Up') {
            steps {
                echo 'Cleaning up workspace...'
                deleteDir()
            }
        }

        stage('Clone Repository') {
            steps {
                echo 'Cloning repository...'
                sh 'git clone https://github.com/3elgrey/jenkins_InitialDemo.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building...'
                dir('jenkins_InitialDemo') {
                    sh 'TERM=dumb mvn -Dstyle.color=never clean install'
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Testing...'
                dir('jenkins_InitialDemo') {
                    sh 'TERM=dumb mvn -Dstyle.color=never test'
                }
            }
        }

        // stage('Deploy') {
        //     steps {
        //         echo 'Deploying...'
        //     }
        // }
    }
}
