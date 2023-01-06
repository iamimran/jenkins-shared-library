#!/usr/bin/env groovy

def call() {
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t iamimran/java-maven-app:jma1.0 .'
        sh "echo $PASS | docker login -u $USERNAME --password-stdin"
        sh "docker push iamimran/java-maven-app:jma1.0"
    }
}
