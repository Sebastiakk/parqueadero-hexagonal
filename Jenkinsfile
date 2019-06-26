pipeline{
	
		agent {
		label 'Slave_Induccion'
		}
	
        
		triggers {
        pollSCM('@hourly')
		}
	
		tools {
		jdk 'JDK8_Centos' 
		gradle 'Gradle5.0_Centos' 
		}
	
		options {
			buildDiscarder(logRotator(numToKeepStr: '5'))
			disableConcurrentBuilds()
		}
		
		environment {
        PROJECT_PATH_BACK = 'Estacionamiento'
		}
		parameters{
			booleanParam defaultValue: false, description: 'Push a registry AWS', name: 'pushdeploy'
		}
		
		stages{
		
			stage('Checkout') {
				steps {
                echo '------------>Checkout desde Git Microservicio<------------'
                checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'Estacionamiento']], gitTool: 'Git_Centos', submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitHub_sebastiakk', url: 'https://github.com/Sebastiakk/parqueadero-hexagonal.git']]])
				}
			}
		
		
			stage('Compile'){
				parallel {
					stage('Compile backend'){
						steps{
							echo "------------>Compilación backend<------------"
							dir("${PROJECT_PATH_BACK}"){
								sh 'gradle build -x test'
							}
						}
					
					}
				}
			}
			stage('Unit Tests') {
			steps{
		 			echo "------------>Unit Tests<------------"
		 			sh 'gradle --stacktrace test'
					junit '**/build/test-results/test/*.xml' //aggregate test results - JUnit
					step( [ $class: 'JacocoPublisher' ] )
	 			}
	 	}
	 
	 	stage('Integration Tests') {
	 		steps {
	 				echo "------------>Integration Tests<------------"
	 			}
		}
	 
	 	stage('Static Code Analysis') {
	 		steps{
		 			echo '------------>Análisis de código estático<------------'
		 			withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
					}
	 			}
	 	}

		}
		post {
			failure {
				mail(to: 'angel.aparicio@ceiba.com.co',
				body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
				subject: "ERROR CI: ${env.JOB_NAME}")
			}
		}	
			
}
