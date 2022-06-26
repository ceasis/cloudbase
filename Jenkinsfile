pipeline {
    agent any
    
    parameters {
        booleanParam(name: 'DEPLOY_TEST', defaultValue: false, description: 'Deploys to TEST')
    }
    
    tools { 
        maven 'Maven 3.8.6' 
        jdk 'Jdk8' 
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
