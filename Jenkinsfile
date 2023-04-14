pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                script {
                    git branch: 'alaNABLI', url: 'https://github.com/SeifeddineKhalfa/devops-spring-back.git'
                }
            }
        }
        stage('UNIT testing') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Maven build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Static code analysis') {
            steps {
                script {
                   sh """mvn sonar:sonar -Dsonar.login=7bb01cbc55931099ddde64740c8c61884a36fed9"""
                }
            }
        }
    }
}
