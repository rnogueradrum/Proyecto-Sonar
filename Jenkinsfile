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
        stage('Sonar') {
            steps {
                sh 'mvn verify sonar:sonar -Dsonar.projectKey=rnogueradrum_Jenkins-project -Dsonar.organization=rnogueradrum -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=690eddc9086b05dce5e8515b7f81ce721c99c07f -Dsonar.branch.name=master'
            }
        }
    }
}