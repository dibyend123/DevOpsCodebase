	pipeline{
        environment{
             registry = "localhost:5000"
        }
	agent {
			docker {
		   		 image 'maven:3-alpine' 
		    		args '-v /root/.m2:/root/.m2' 
			}
		}
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
		                   //   publishHTML (target: [ reportDir: 'target/site',
                                     // reportFiles: 'checkstyle.html',
                                      //reportName: "checkstyle Report" ])	
                        	}
			}
                        stage("codecheckreport"){
                              steps {  
  	                              sh "mvn jacoco:report"           
	                            //  publishHTML (target: [ reportDir: 'target/jacoco-ut',
               		              //reportFiles: 'index.html',               
				      //reportName: "JaCoCo Report"          ])          
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
                            script {
                              docker.build registry+":1"
                            }
                         }	
			}
		}
	}
