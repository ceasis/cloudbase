pipeline {
    agent any
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
