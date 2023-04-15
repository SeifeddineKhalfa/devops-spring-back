pipeline {
    environment {
        NEXUS_URL = 'http://192.168.1.16:8081'
        NEXUS_REPOSITORY_ID = 'deploymentRepo'
        NEXUS_REPOSITORY_URL = 'http://192.168.1.16:8081/repository/maven-releases'
        DOCKERHUB_CREDENTIALS = credentials('ichrakbasti')
    }
    agent any
    stages {
        stage('Chekout and pull branche feature/ichrak-devops '){
            steps {
                echo 'Pulling .............';
                git branch: 'feature/ichrak-devops',
                url: 'https://github.com/SeifeddineKhalfa/devops-spring-back.git'
            }
        }
        stage('Maven Clean Install'){
            steps {
                echo "Clean......";
                sh """mvn clean -DskipTests""";
            }
        }
        stage('Compilation') {
            steps {
              sh 'mvn compile'
            }
        }
        stage("Test unitaire produit ") {
            steps{
                sh'mvn test -Ptest'
            }
        }
        stage ('Sonar') {
            steps {
                echo "sonar.............";
                sh 'mvn sonar:sonar -Dsonar.login=59449d768a80757e48b26ea45f603fae3b775ba6';
            }
        }
        stage ('Nexus'){
            steps {
                echo 'Deploy..............';
                sh "mvn deploy -DaltDeploymentRepository=${NEXUS_REPOSITORY_ID}::default::${NEXUS_REPOSITORY_URL} -s /usr/share/maven/conf/settings.xml"
            }
        }
        stage('docker build'){
            steps{
                script{
                    sh 'docker build -t ichrakbasti/projet .'
                }
            }
        }
        stage('Login docker hub') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
            }
        }
        stage('docker push') {
            steps {
                sh 'docker push ichrakbasti/projet'
            }
        }
        stage("Start Containers") {
            steps {
                sh 'docker-compose up -d --build'
            }
        }
    }
}