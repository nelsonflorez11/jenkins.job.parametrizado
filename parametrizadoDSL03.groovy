job('hijo02-dsl') {
	description('hola bogota como estansss')
  	scm {
      		git('https://github.com/nelsonflorez11/jenkins.job.parametrizado.git', 'main') { node ->
        		node / gitConfigName('nelsonflorez11')
        		node / gitConfigEmail('nelsonflorez11@gmail.com')
      		}
    	} 
  		parameters {
   		stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
      		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      		booleanParam('agente', false)
    	}
  		triggers {
    		cron('H/7 * * * *')
    	}
  		steps {
    		shell("bash jobscript.sh")
    	}
  		 publishers {
      		mailer('nelsonflorez11@gmail.com', true, true)
    	}
  

    	
}
