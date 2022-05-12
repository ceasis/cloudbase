pipeline {
    agent any
    
    parameters {
        booleanParam(name: 'Deploy To Test', defaultValue: false, description: 'Deploys to TEST')
    }
    
    tools {
        maven 'Maven'
    }
    stages {
        stage('build') {
            steps {
                echo '... building'
                sh 'mvn install'
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
