pipeline {
    agent any

    parameters{

        booleanParam(name: 'PROD', defaultValue: false, description: 'Production environment')
        string(name: 'VERSION', defaultValue: '1.0', description: 'App version')
        choice(name: "Env", choices: ["TEST", "DEV", "QA", "PRE-PROD"], description: "Environment to run the job")
        
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
