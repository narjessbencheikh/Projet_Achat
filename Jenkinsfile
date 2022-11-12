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
            steps {
                sh "mvn clean "
            }
        }
        stage('MVN COMPILE'){
            steps {
                sh "mvn compile"
            }
        }
        stage('MVN SONARQUBE'){
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=ahmed123'
            }
        }
    }
}