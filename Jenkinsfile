// pipeline {
//     agent any

//     stages {
//         stage('Checkout') {
//             steps {
//                 git 'https://github.com/3elgrey/jenkins_InitialDemo.git'
//             }
//         }

//         stage('Build') {
//             steps {
//                 sh 'mvn clean package'
//             }
//         }

//         stage('Test') {
//             steps {
//                 sh 'mvn test'
//             }
//         }

//         stage('Deploy') {
//             steps {
//                 echo 'Deploying Java Login App...'
//             }
//         }
//     }
// }
pipeline {
    agent any

    parameters {
        string(
            name: 'BRANCH',
            defaultValue: 'main',
            description: 'Git branch to build'
        )
    }

    // environment {
    //     MAVEN_HOME = tool 'Maven'  // Ensure "Maven" tool is configured in Jenkins
    //     JAVA_HOME = tool 'JDK21'   // Or whatever JDK name you set in Jenkins Global Tool Config
    //     PATH = "${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"
    // }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${params.BRANCH}", 
                    url: 'https://github.com/3elgrey/jenkins_InitialDemo.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building project with Maven..."
                bat "mvn clean install -DskipTests=false"
            }
        }

        stage('Test') {
            steps {
                echo "Running unit tests..."
                bat "mvn test"
            }
        }

        stage('Archive Artifact') {
            steps {
                echo "Archiving JAR artifact..."
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }

        stage('Post Build Info') {
            steps {
                echo "✅ Build completed successfully for branch: ${params.BRANCH}"
            }
        }
    }

    post {
        failure {
            echo "❌ Build failed for branch: ${params.BRANCH}"
        }
    }
}
