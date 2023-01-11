#!/usr/bin/env groovy

def call(String imageName) {
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USERNAME')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USERNAME --password-stdin"
        sh "docker push iamimran/java-maven-app:jma1.0"
    }
}
