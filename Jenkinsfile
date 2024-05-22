node {
  def dockerHubRepo = 'alcazels@gmail.com/adteller'
  def dockerHubCredentialsId = 'DockerHub_ID' 
  
  stage("Clone the project") {
    git branch: 'main', url: 'https://github.com/adteller/restapidemo.git'
  }

  stage("Compilation") {
    sh "chmod +x ./gradlew"
    sh "./gradlew clean build -x test"
  }

  stage("Tests and Deployment") {
    stage("Running unit tests") {
      sh "chmod +x ./gradlew"
      sh "./gradlew test"
    }
    stage("Deployment") {
      sh "chmod +x ./gradlew"
      sh 'nohup ./gradlew bootRun -Dserver.port=8280 &'
      sh 'echo #!asdf2580 | sudo docker login -u alcazels@gmail.com'
      sh 'sudo docker build -t adteller/restapidemo:1.0 .'
    }
    stage('Push Docker Image') {
        script {
            docker.withRegistry('https://index.docker.io/v1/', dockerHubCredentialsId) {
                def image = docker.image("adteller/restapidemo:1.0")
                image.push()
                image.push('1.0')
            }
        }
    }
  }
}
