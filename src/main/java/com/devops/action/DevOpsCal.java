package com.devops.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cache.annotation.Cacheable;

/** 
documentation 
*/ 
@RestController
@RequestMapping("/DevOpsCal")
public class DevOpsCal{


	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<String> welcomePage(){	
		return new ResponseEntity<String>("This is the Devops Calculator", HttpStatus.OK);
	}


	@RequestMapping(value="/add", method=RequestMethod.GET)
	@Cacheable("sum")
	public ResponseEntity<String> addition(@RequestParam(value = "a", required = false) String a,@RequestParam(value = "b", required = false) String b)  {	

		return new ResponseEntity<String>((Integer.parseInt(a)+Integer.parseInt(b))+"", HttpStatus.OK);		
	}


	@RequestMapping(value="/minus", method=RequestMethod.GET)
	public ResponseEntity<String> subtract(@RequestParam(value = "a", required = false) String a,@RequestParam(value = "b", required = false) String b)  {	

	return new ResponseEntity<String>((Integer.parseInt(a)-Integer.parseInt(b))+"", HttpStatus.OK);			
	}

	@RequestMapping(value="/multiply", method=RequestMethod.GET)
	public ResponseEntity<String> multiply(@RequestParam(value = "a", required = false) String a,@RequestParam(value = "b", required = false) String b)  {	

	return new ResponseEntity<String>((Integer.parseInt(a)*Integer.parseInt(b))+"", HttpStatus.OK);			

	}

	@RequestMapping(value="/divide", method=RequestMethod.GET)
	public ResponseEntity<String> divide(@RequestParam(value = "a", required = false) String a,@RequestParam(value = "b", required = false) String b)  {	

return new ResponseEntity<String>((Float.parseFloat(a)/Float.parseFloat(b))+"", HttpStatus.OK);				
	}



}
