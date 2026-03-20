pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
                publishHTML([
                    reportDir: 'reports',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Automation Report'
                ])
            }
        }
    }
} 