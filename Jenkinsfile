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
                
        stage('build and test') {
            when { 
                environment name: 'DEPLOY_TEST', value: 'true'
            }
            steps {
                echo 'with TESTING'
            }        
        }

        stage('build only') {
            when { 
                environment name: 'DEPLOY_TEST', value: 'false'
            }
            steps {
                echo 'JUST BUILD'
                sh "ls *.* > listFiles"
                sh "rm -f listFiles"                
                sh 'mvn sonar:sonar -Dsonar.projectKey=CloudBase -Dsonar.host.url=http://localhost:9000 -Dsonar.login=06e7d587a647c8ebf4def5d6c3a66916ad09e41a'      
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
