pipeline{
	agent {
			docker {
		   		 image 'maven:3-alpine' 
		    		args '-v /root/.m2:/root/.m2 -v /usr/bin:/usr/bin' 
			}
		}
		/*	environment{
				PATH="/usr/bin:$PATH"
			}*/
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
                           //     sh "export PATH=$PATH:/usr/bin/docker"       
				sh "bash ./dockercommand.sh"
				}
			}
		}
}
