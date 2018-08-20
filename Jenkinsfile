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
			stage("dockerbuild"){
				steps{
		 sh "docker build -t calculator:${BUILD_NUMBER} ."		
                           }
			}
			stage("dockerpush"){
				steps{
					sh "docker push localhost:5000/calculator:${BUILD_NUMBER}"
				}
			}
		}
}
