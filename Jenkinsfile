// pipeline {
//     agent any

//     stages {
//         stage('Build') {
//             steps {
//                 bat 'mvn clean install'
//             }
//         }

//         stage('Test') {
//             steps {
//                 bat 'mvn test'
//             }
//         }

//         stage('Report') {
//             steps {
//                 publishHTML([
//                     reportDir: 'reports',
//                     reportFiles: 'ExtentReport.html',
//                     reportName: 'Automation Report'
//                 ])
//             }
//         }
//     }
// } 



pipeline {
    agent any

    environment {
        IMAGE_NAME = 'automation-test'
        CONTAINER_NAME = 'automation-container'
    }

    stages {

        // 1️⃣ Get code from GitHub
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/jogendradurgamahesh/advanced-automation-framework.git'
            }
        }

        // 2️⃣ Build Docker image using Dockerfile
     //   stage('Build Docker Image') {
       //     steps {
         //       bat "docker build -t %IMAGE_NAME% ."
           // }
        //}

          // 🔥 ADD THIS STAGE HERE
        stage('Cleanup Old Container') {
            steps {
                bat "docker rm -f %CONTAINER_NAME% || exit 0"
            }
        }


        // 3️⃣ Run tests inside Docker container
        stage('Run Tests') {
            steps {
                //bat "docker run --name %CONTAINER_NAME% %IMAGE_NAME%"
                 bat "docker run --rm --name %CONTAINER_NAME% jogendramahesh/automation-test"
            }
        }

        // 4️⃣ Copy report from container to Jenkins workspace
        stage('Copy Reports') {
            steps {
                bat "docker cp %CONTAINER_NAME%:/app/reports ."
                 
            }
        }

        // 5️⃣ Remove container (cleanup)
        stage('Cleanup') {
            steps {
                bat "docker rm %CONTAINER_NAME%"
            }
        }

        // 6️⃣ Publish report in Jenkins
       stage('Publish Report') {
    steps {
        publishHTML(target: [
            reportDir: 'reports',
            reportFiles: 'ExtentReport.html',
            reportName: 'Automation Report',
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
        ])
    }
}
    }

    post {
        success {
            echo '✅ Pipeline executed successfully'
        }
        failure {
            echo '❌ Pipeline failed'
        }
        always {
            echo 'Pipeline finished'
        }
    }
}
