pipeline {
    agent any
     tools {
        maven 'maven'
    }
    stages {

         stage("cleaning code") {
            steps {
                script {
                   sh 'mvn -B -DskipTests clean '
                }
            }
        }
        stage("building") {
            steps {
                script {
                   sh 'mvn -B -DskipTests clean package'
                }
            }
        }
         stage("testing") {
            steps {
                script {
                   sh 'mvn test'
                }
            }
        }
        stage("code QualityCheck Sonar") {
            steps {
                script {
             sh " mvn sonar:sonar -Dsonar.projectKey=wissem -Dsonar.host.url=http://192.168.1.150:9000   -Dsonar.login=47d83366fee9dafbf03db533eeae79c47ffe559e"

                }
            }
        }


   
    }  
}