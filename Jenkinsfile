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
                   sh """mvn sonar:sonar -Dsonar.login=74367c6fa5c7c1634c38794ad44de45fd0e4cb6d"""
                }
            }
        }
        stage('Deploy to Nexus') {
            steps {
                script{
                    nexusArtifactUploader artifacts:
                    [
                        [
                            artifactId: 'tpAchatProject',
                            classifier: '',
                            file: 'target/tpAchatProject-1.0.jar',
                            type: 'jar'
                        ]
                    ],
                    credentialsId: 'nexus-pass',
                    groupId: 'com.esprit.examen',
                    nexusUrl: '192.168.1.10:8081',
                    nexusVersion: 'nexus3', protocol:
                    'http', repository:
                    'maven-releases',
                    version: '1.0'
                }
            }
        }
    }
}
