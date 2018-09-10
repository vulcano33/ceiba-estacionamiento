pipeline {
	agent {
		label 'Slave_Induccion'
	}
	options {
		buildDiscarder(logRotator(numToKeepStr: '3'))
		disableConcurrentBuilds()
	}
	//Una seccion que define las herramientas para “autoinstalar” y poner en la PATH
	tools {
		jdk 'JDK8_Centos' //Preinstalada en la Configuracion del Master
		gradle 'Gradle4.5_Centos' //Preinstalada en la Configuracion del Master
	}
	stages {
		stage('Checkout') {
			steps {
				echo "------------>Checkout<------------"
				checkout([$class: 'GitSCM', branches: [
						[name: '*/master']
					],
					doGenerateSubmoduleConfigurations: false, extensions: [], gitTool:
					'Git_Centos', submoduleCfg: [], userRemoteConfigs: [
						[credentialsId:
							'GitHub_vulcano33', url: 'https://github.com/vulcano33/ceiba-estacionamiento.git'
						]
					]
				])
			}
		}


		stage('Compile') {
			steps {
				echo "------------>Compile<------------"
				sh 'gradle clean'
				sh 'gradle --b ./build.gradle compileJava'
			}
		}

		stage('Unit Tests') {
			steps {
				echo "------------>Unit Tests<------------"
				sh 'gradle --b ./build.gradle test'

			}
		}

		stage('Integration Tests') {
			steps {
				echo "------------>Integration Tests<------------"
			}
		}
		
		stage('Build') {
		       steps {
			      echo "------------>Build<------------"
			      sh 'gradle --b ./build.gradle build -x test'
		             }
	         }

		stage('Static Code Analysis') {
			steps {
				echo '------------>Analisis de codigo estatico<------------'
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
				                          }
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
			echo 'This will run only if failed'
			//      Send notifications about a Pipeline to an email
			mail(to: 'carlos.cabrera@ceiba.com.co',
				subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
				body: "Something is wrong with ${env.BUILD_URL}")


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