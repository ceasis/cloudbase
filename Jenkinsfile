pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh 'pwd'
                sh 'mvn clean package'
            }
        }
    }
}
