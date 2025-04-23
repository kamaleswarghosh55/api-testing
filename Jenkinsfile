pipeline {
    agent any

    tools {
        maven 'Maven_3'
    }

    environment {
        IMAGE_NAME = 'kamaleswarghosh/api-testing-image'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'git@github.com:kamaleswarghosh55/api-testing.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run --rm $IMAGE_NAME'
            }
        }

        stage('Publish Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline Completed.'
        }
    }
}