pipeline {
          agent any
          stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'sirine',
                    url : 'https://github.com/narjessbencheikh/Projet_Achat.git';
                }

            }
            stage('MVN CLEAN'){
            steps{
                echo 'Pulling...';
                sh 'mvn clean'
                }
            }
             stage('MVN COMPILE'){
                steps{
                sh 'mvn compile'
                }
             }
             stage('MVN PACKAGE'){
                steps{
                sh 'mvn package'
                }
             }

              stage('MVN SONARQUBE '){
                 steps{
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                 }
              }
              stage("nexus deploy"){
                 steps{
                  nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: '/var/lib/jenkins/workspace/DevopsBack/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus-snapshots', groupId: 'tn.esprit.rh', nexusUrl: '194.94.28.148:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'nexus-snapshots', version: '1.0.0'
                 }
              }

              }
          }
