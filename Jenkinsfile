pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn package'
        archiveArtifacts 'target/*.jar'
      }
    }
    stage('nexus') {
      steps {
        nexusArtifactUploader {
        nexusVersion('nexus3')
        protocol('http')
        nexusUrl('nexus:8081')
        groupId('com.zeroquo')
        version('0.0.1-SNAPSHOT')
        repository('maven-snapshots')
        credentialsId('nexusAdmin')
        artifact {
            artifactId('culturebump')
            type('jar')
            file('culturebump-0.0.1-SNAPSHOT.jar')
        }
      }
      }
    }
  }
}
