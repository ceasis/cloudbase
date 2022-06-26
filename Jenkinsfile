pipeline {
    agent any
    
    parameters {
        booleanParam(name: 'DEPLOY_TEST', defaultValue: false, description: 'Deploys to TEST')
    }
    
    tools {
        maven 'mvn'
    }
    stages {
        stage('build') {
            steps {
                echo '... building'
                
                sh 'mvn clean install package'
                
            }
        }

        stage('test') {
            steps {
                echo '... testing'
            }
        }

        stage('deploy') {
            steps {
                echo '... deploying'
            }
        }

    }
}
