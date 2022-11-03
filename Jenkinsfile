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


pipeline{
    agent any
    stages{
        stage('GIT'){
            steps {
                echo "Getting Project from Git"
                git branch: 'ahmedmezghani', url: 'https://github.com/narjessbencheikh/Projet_Achat.git'
            }
        }
        stage('MVN CLEAN'){
            steps{
                sh 'mvn clean install -DskipTests'
            }
        }
    }
}