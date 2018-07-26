	pipeline{
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
				   sh "mvn jacoco-check:check"
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
		}
	}
