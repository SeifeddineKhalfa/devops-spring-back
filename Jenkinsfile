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
                   sh """mvn sonar:sonar -Dsonar.login=51a16370fb993055e13386c7b2dc7635d384741c"""
                }
            }
        }
        stage('Deploy to Nexus') {
            steps {
                script{
                    sh 'mvn deploy '
                }
            }
        }
    }
}
