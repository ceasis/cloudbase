pipeline {
    agent any
    
    parameters {
        booleanParam(name: 'DEPLOY_TEST', defaultValue: false, description: 'Deploys to TEST')
    }
    
    tools {
        maven 'Maven'
    }
    stages {
        stage('build') {
            steps {
                echo '... building'
                
                git branch: 'master',
                    url: 'https://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@github.com/ceasis/maperr-web.git'
                
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
