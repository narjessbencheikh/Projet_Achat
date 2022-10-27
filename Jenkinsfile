pipeline {
    agent any
    stages {


        stage('Git Checkout') {
            steps {

               git branch: 'narjessFacture', url: 'https://github.com/narjessbencheikh/Projet_Achat.git'
               
            }
        }

        stage('SonarQube') {
            steps {

                 sh 'mvn test'
               
            }
        }


        
    }
}