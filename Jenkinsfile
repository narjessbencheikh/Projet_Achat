pipeline {
    agent any
    stages {
        stage('Checkout Git') {
            steps {
               echo 'Pulling...',
               git branch : 'narjessFacture',
               url : 'https://github.com/narjessbencheikh/DevOps-Project'
            }
        }

        stage('SonarQube analysis') {
      withSonarQubeEnv(credentialsId: 'f225455e-ea59-40fa-8af7-08176e86507a', installationName: 'My SonarQube Server') { // You can override the credential to be used
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
    }


        
    }
}
