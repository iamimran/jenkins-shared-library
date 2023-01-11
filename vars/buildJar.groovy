#!/usr/bin/env groovy

def call() {
    echo "Building the application for the ${env.BRANCH_NAME}"
    sh "mvn package"
}
