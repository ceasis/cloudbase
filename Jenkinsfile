pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh 'pwd'
                
                dir('/Users/choloasis/workspace/springboot-discovery-service') {
                    sh 'mvn clean package'
                }
                
            }
        }
    }
}
