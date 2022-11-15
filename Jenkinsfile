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
	stage('JUnit and Mockito Test'){
            steps{
                        sh 'mvn --batch-mode test'
            }
        }
        stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }
	stage('Build Docker image Backend') {
            steps {
                sh 'docker build -t ahmedmezghani/achat . '
            }
        }
        
        stage('Login Dockerhub') {
			steps {
			    sh 'docker login -u ahmedmezghani -p maison9814'
			}
		}
			
			
        stage('Push image Backend to Dockerhub') {
            steps {
                sh 'docker push ahmedmezghani/achat'
            }
        }
        stage('Docker compose back/sql') {
            steps 
            {
                sh 'docker-compose up -d'
            }
        }
stage('Sending email'){
	            steps {
	             mail bcc: '', body: '''Hello from ahmed,
	             Devops Pipeline with success.
	             Cordialement''', cc: '', from: '', replyTo: '', subject: 'Devops', to: 'ahmed.mezghani@esprit.tn'
	             }
	        }
    }
}