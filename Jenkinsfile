pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/3elgrey/jenkins_InitialDemo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Java Login App...'
            }
        }
    }
}
