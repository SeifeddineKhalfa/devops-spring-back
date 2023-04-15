pipeline {
    agent any
    environment {
         DOCKERHUB_CREDENTIALS = credentials('docker-pass')
     }
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
        stage("Publish to Nexus Repository Manager") {
               steps {
                   script {
                       pom = readMavenPom file: "pom.xml";
                       filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                       echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                       artifactPath = filesByGlob[0].path;
                       artifactExists = fileExists artifactPath;
                       if(artifactExists) {
                           echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                           nexusArtifactUploader(
                               nexusVersion: "nexus3",
                               protocol: "http",
                               nexusUrl: "192.168.1.10:8081",
                               groupId: pom.groupId,
                               version: pom.version,
                               repository: "devops",
                               credentialsId: "nexus-pass",
                               artifacts: [
                                   [artifactId: pom.artifactId,
                                   classifier: '',
                                   file: artifactPath,
                                   type: pom.packaging],
                                   [artifactId: pom.artifactId,
                                   classifier: '',
                                   file: "pom.xml",
                                   type: "pom"]
                               ]
                           );
                       } else {
                           error "*** File: ${artifactPath}, could not be found";
                       }
                   }
               }
           }
           stage('Docker build') {
                agent any
                steps {
                  sh 'echo "Docker is building ...."'
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/backendbuild . < Dockerfile'
                }
           }
           stage('Docker login') {
            agent any
            steps {
              sh 'echo "login Docker ...."'
              sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
            }
          }
          stage('Docker push') {
               agent any
               steps {
                 sh 'echo "Docker is pushing ...."'
                 sh 'docker push $DOCKERHUB_CREDENTIALS_USR/backendbuild'

               }
          }
          stage('docker check containers') {
               steps {

                 sh 'docker ps'
               }
          }
       }
}

