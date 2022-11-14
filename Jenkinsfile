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
             sh " mvn sonar:sonar -Dsonar.projectKey=wissem -Dsonar.host.url=http://192.168.1.150:9000   -Dsonar.login=62f9e96b7846e55ba62415902fde9f7249693cd8"

                }
            }
        }

         stage("publish to nexus") {
            steps {
                script {
                configFileProvider([configFile(fileId: 'wissem', variable: 'setting')]) {
                    sh 'mvn  -B -DskipTests deploy -s $setting'

}                }
            }
        }
        stage("creating docker image ") {
            steps {
                script {
                  sh 'docker build -t wissemoueslati/spring:latest .'
                }
            }
        }
         
         
           stage("pushing image to docker hub") { 
             steps { 
                 script { 
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push wissemoueslati/spring:latest'
                        
                    }
                 } 
             } 
         }
            stage("docker compose ") {
            steps {
                script {
                  sh 'docker compose up -d'
                }
            }
        }


   
    }  
}
