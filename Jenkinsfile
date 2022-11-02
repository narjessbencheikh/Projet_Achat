pipeline {
    agent any
    stages {


        stage('Git Checkout') {
            steps {

               git branch: 'ahmedmezghani', url: 'https://github.com/narjessbencheikh/Projet_Achat.git'
               
            }
        }
	stage('Affichage date'){
		steps {
			echo date
		}
	}        
    }
}