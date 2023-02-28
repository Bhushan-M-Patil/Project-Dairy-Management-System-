package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;

import lombok.NoArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000")//To enable CORS header 
@RequestMapping("/employees")
@Validated
@NoArgsConstructor
public class EmployeeController {

	//dependency : service layer i.f
	@Autowired
	private EmployeeService empService;


	//add REST end point to get all emps
	// http:host:port/employees , method=GET
	@GetMapping
	public List<Employee> getAllEmps() {
		return empService.getAllEmpDetails();
	}
	

	@PostMapping
	public Employee saveEmpDetails(@RequestBody @Valid Employee transientEmp) {
		return empService.addEmpDetails(transientEmp);
	}

	// http:host:port/employees/123 , method=DELATE
	@DeleteMapping("/{empId}")
	public String deleteEmpDetails(@PathVariable Long empId) {
		return empService.deleteEmpDetails(empId);
		//return new ApiResponse(empService.deleteEmpDetails(empId));
	}

	// http:host:port/employees/123 , method=GET
	@GetMapping("/{empId}")
	public Employee getEmpDetails(
			@PathVariable Long empId) {
		return empService.fetchEmpDetails(empId);
	}

	// http:host:port/employees , method=PUT
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee detachedEmp) {
		return empService.updateEmpDetails(detachedEmp);
	}

	// Add REST end point for Emp siginin
	// URL --- http://host:port/employees/signin
//	@PostMapping("/signin")
//	public ResponseEntity<?> validateEmployee(@RequestBody @Valid LoginRequestDto dto) {
//		System.out.println("in emp signin " + dto);
//		// try {
//		return ResponseEntity.ok(empService.authenticateEmp(dto));
////		} catch (RuntimeException e) {
////			System.out.println("err in emp controller " + e);
////			return ResponseEntity.status(HttpStatus.NOT_FOUND).
////					body(new ApiResponse(e.getMessage()));
////		}
//
//	}

	// Add REST end point for searching emps by dept n date
	// http://host:port/employees/date/2020-1-1/dept/rnd , method =GET
//	@GetMapping("/date/{joinDate1}/dept/{dept1}")
//	public List<Employee> getAllEmpsByDateAndDept(
//			@PathVariable @DateTimeFormat(pattern = "yyyy-M-d") LocalDate joinDate1, @PathVariable String dept1) {
//		System.out.println("in get all emps by date n dept " + joinDate1 + " " + dept1);
//		return empService.getEmpsByDateAndDept(joinDate1, dept1);
//	}
//
//	// Add REST end point for searching emps by sal range , method = GET
//	// pass payload as req params
//	@GetMapping("/salary")
//	public List<EmployeeResponse> getAllEmpsBySalaryRange(@RequestParam double minSal, double maxSal) {
//		System.out.println("in get emps by sal " + minSal + " " + maxSal);
//		return empService.getEmpsBySalary(minSal, maxSal);
//	}
//
//	// Add REST end point to :get all emps -- added in ResponseEntity (=resp packet)
//	// having last name containing some keyword
//	@GetMapping("/last_name/{key}")
//	public ResponseEntity<?> getEmpsByLastNameKey(@PathVariable String key) {
//		System.out.println("in get emps by last name containing key " + key);
//		// API of ResponseEntity : status() body()
//		List<Employee> list = empService.getEmpsByLastNameContainingKey(key);
//		if (list.isEmpty())
//			// simple ret RespEnt : HttpStatus
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		else
//			// sts : OK , list
//			return ResponseEntity.ok(list);
//	}
//
//	// Add REST end point to : apply salry increment(UPDATE) to those emps from
//	// specific department , joined before
//	// specific date
//	@PutMapping("/sal_incr")
//	public ApiResponse applySalaryIncrement(@RequestBody EmpSalIncrementRequest dto) {
//		System.out.println("in apply sal incr " + dto);
//		return new ApiResponse(empService.applySalaryIncrement(dto));
//	}
//
//	// Add REST end point to upload image
//	// URL : http://host:port/employees/{empId}/image , Method=POST
//	@PostMapping(value="/{empId}/image",consumes = "multipart/form-data")
//	public ResponseEntity<?> uploadImageToServerSideFolder(@RequestParam MultipartFile imageFile,
//			@PathVariable Long empId
//			) throws IOException {
//		System.out.println("in upload img " + empId + " " + imageFile.getOriginalFilename());
//		return new ResponseEntity<>(imageService.uploadImage(empId, imageFile), HttpStatus.CREATED);
//	}
//
//	// Add REST end point to download/serve image , method=GET
//	// URL : http://host:port/employees/{empId}/image
//	@GetMapping(value = "/{empId}/image", produces = { MediaType.IMAGE_GIF_VALUE, 
//			MediaType.IMAGE_JPEG_VALUE,
//			MediaType.IMAGE_PNG_VALUE })
//	public ResponseEntity<?> serveImageFromServerSideFolder(@PathVariable Long empId) throws IOException {
//		System.out.println("in serve img " + empId);
//		return new ResponseEntity<>(imageService.serveImage(empId), HttpStatus.OK);
//	}

}
