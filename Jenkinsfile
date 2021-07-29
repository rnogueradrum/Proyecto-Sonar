pipeline {
    agent any
    tools {
        maven "maven3.6.3"
        jdk "jdk16"
    }
    stages {
        stage("Env Variables") {
            steps {
                sh "printenv"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
//        stage('Sonar') {
//            steps {
//                sh 'mvn verify sonar:sonar -Dsonar.projectKey=rnogueradrum_m3-01-maven-RN -Dsonar.organization=rnogueradrum -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=3de65a1c013f5abc7d8b4ab7892c215e05bae05b -Dsonar.branch.name=master'
//            }
//        }
    }
}