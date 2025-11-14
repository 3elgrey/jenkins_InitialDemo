pipeline {
    agent any

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
                dir('jenkins_InitialDemo/java-login-app') {
                    sh 'TERM=dumb mvn -Dstyle.color=never clean install'
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Testing...'
                dir('jenkins_InitialDemo/java-login-app') {
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
