pipeline {   
	agent {     
	    label 'Slave_Induccion'   
	} 
	options {   
		buildDiscarder(logRotator(numToKeepStr: '3'))
		disableConcurrentBuilds()   
	} 
  
	tools {     
		jdk 'JDK8_Centos'
		gradle 'Gradle4.5_Centos' 
	} 
  
	stages{     
		stage('Checkout') {       
			steps{         
				echo "------------>Checkout<------------"
				checkout(
				[$​class: 'GitSCM​',
				​branches: [[name: '*/master']]​,
				doGenerateSubmoduleConfigurations: false,
				extensions: [],
				​gitTool: 'Git_Centos'​,
				submoduleCfg: [],
				userRemoteConfigs: [[​credentialsId: 'GitHub_sebastiakk', url: 'https://github.com/Sebastiakk/parqueadero-hexagonal']]]) 
                sh 'gradle clean'				
			}     
		}       
		stage('Compile') {
			steps{
				echo "------------>> Compile has started <<------------"
				sh 'gradle --b ./build.gradle compileJava'
			}
		}
		stage('Unit Tests') {
			steps{
				echo "------------>> Unit Tests has started <<------------"
				sh 'gradle test'
				junit '**/build/test-results/test/*.xml' 
				step( [ $class: 'JacocoPublisher' ] )
			}
		}
				
		/*stage('Integration Tests') {
			steps {
				echo "------------>> Integration Tests  has started <<------------"
			}
		}*/
	
		stage('Static Code Analysis') {
			steps{
				echo '------------>Análisis de código estático<------------'
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"}    
			}
		}
		
		stage('Build') {
			steps {
				echo "------------>> Build has started <<------------"
				sh 'gradle --b ./build.gradle build -x test'
			}
		}
	}
	
	
	post {
		always {
			echo 'This will always run'
		}
		
		success {
			echo 'This will run only if successful'
		}
		
		failure {
			{
				mail(to: 'sebastian.ramirez@ceiba.com.co',
				body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
				subject: "ERROR CI: ${env.JOB_NAME}")
			}
		}
		
		unstable {
			echo 'This will run only if the run was marked as unstable'
		}   

		changed {
			echo 'This will run only if the state of the Pipeline has changed'
			echo 'For example, if the Pipeline was previously failing but is now successful'
		}
	}
}