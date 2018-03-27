pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn package'
        archiveArtifacts 'target/*.jar'
      }
    }
  }
}