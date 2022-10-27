pipeline {
    agent any
    stages {


        stage('Git Checkout') {
            steps {

               git branch: 'narjessFacture', url: 'https://github.com/narjessbencheikh/Projet_Achat.git'
               
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {

                    withSonarQubeEnv(credentialsId: 'sonar_token') {
                      sh 'mvn clean package sonar:sonar'
                    }
                 }
                 
                
               
            }
        }


        
    }
}