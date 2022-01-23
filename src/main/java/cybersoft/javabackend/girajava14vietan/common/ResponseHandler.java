package cybersoft.javabackend.girajava14vietan.common;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cybersoft.javabackend.girajava14vietan.common.utils.ErrorUtil;

public class ResponseHandler {
	
	public static ResponseEntity<Object> getResponse(Object obj, HttpStatus status){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//contract with client
		map.put("content",obj);
		map.put("errors", "");
		map.put("hasErrors", false);
		map.put("pageIndex" , 1);
		map.put("pageSize", 20);
		map.put("total", 20);
		map.put("responseTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
	
	public static ResponseEntity<Object> getErrorResponse(Object obj, HttpStatus status){
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(obj instanceof BindingResult) {
			map.put("content", "");
			map.put("errors", ErrorUtil.soveError((BindingResult)obj));
		}else {
			map.put("errors", obj);
		}
		
		//contract with client
		map.put("hasErrors", true);
		map.put("pageIndex" , 0);
		map.put("pageSize", 0);
		map.put("total", 0);
		map.put("responseTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}

	public static ResponseEntity<Object> getResponse(HttpStatus ok) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//contract with client
		map.put("content","OK");
		map.put("errors", "");
		map.put("hasErrors", false);
		map.put("pageIndex" , 1);
		map.put("pageSize", 20);
		map.put("total", 20);
		map.put("responseTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", ok.value());
		
		return new ResponseEntity<Object>(map, ok);
	}
}
