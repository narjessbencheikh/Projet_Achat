pipeline {
    agent any
    stages {


        stage('Git Checkout') {
            steps {

               git branch: 'narjessFacture', url: 'https://github.com/narjessbencheikh/Projet_Achat.git'
               
            }
        }

        stage('Unit Testing') {
            steps {

                 sh 'mvn test'
               
            }
        }


        
    }
}