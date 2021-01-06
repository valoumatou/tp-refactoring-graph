pipeline {
    agent {
        docker {
            image 'docker.io/library/maven:3.6-openjdk-11-slim'
            label 'docker'
            // "docker volume create maven-home" requis sur le noeud
            args '-v maven-home:/usr/share/maven'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package jacoco:report'
            }
        }
    }
    post {
        always {
            junit 'target/**/*.xml'
            jacoco(
                execPattern: 'target/*.exec',
                classPattern: 'target/classes',
                sourcePattern: 'src/main/java',
                exclusionPattern: 'src/test*'
            )
        }
    }
}
