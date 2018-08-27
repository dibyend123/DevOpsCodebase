pipeline{
	agent any 
		stages{
			
			stage("test"){
				steps{
					sh 'mvn test'
				}			
			}
			stage("build"){
				steps{
					sh 'mvn package'
				}			
			}
			stage("codecheck"){
				steps{
				   sh "mvn clean verify"
		                      publishHTML (target: [ reportDir: 'target/site',
                                      reportFiles: 'checkstyle.html',
                                      reportName: "checkstyle Report" ])	
                        	}
			}
                        stage("codecheckreport"){
                              steps {  
  	                              sh "mvn jacoco:report"           
	                              publishHTML (target: [ reportDir: 'target/jacoco-ut',
               		              reportFiles: 'index.html',               
				      reportName: "JaCoCo Report"          ])          
	                            }  
                        }
                        stage("checkstyle"){
				steps{
					sh "mvn checkstyle:checkstyle"
				}
			}
			stage("createpackage"){
				steps{
					sh "mvn package"
				}
			}
    			stage("dockercomposebuild"){
				steps{
					sh "docker-compose up -d"
				}
			}
			stage("dockercomposetest"){
				steps{
					sh "docker-compose ps"
				}
			}
			stage("acceptancetest"){
				steps{
					sleep 60
					sh "bash acceptance_test.sh"
				}	
			}
/*			stage("dockerbuild"){
				steps{
		 sh "docker build -t localhost:5000/calculator:${BUILD_NUMBER} ."		
                           }
			}
			stage("dockerpush"){
				steps{
					sh "docker push localhost:5000/calculator:${BUILD_NUMBER}"
				}
			}
			stage("Deploy"){
				steps{
					sh "docker run -d --rm -p 8765:8080 --name calculator localhost:5000/calculator:${BUILD_NUMBER}"
				}
			}
			stage("docker-composecheck"){
				steps{
					sh "docker-compose --version"
				}

			}*/
/*			stage("acceptancetest"){
				steps{
					sleep 60
					sh "bash acceptance_test.sh"
				}	
			}*/
		}
	/*	post{
				always{
					sh "docker-compose down"

				}
		} */
}
