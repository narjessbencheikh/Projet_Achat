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


   
    }  
}
