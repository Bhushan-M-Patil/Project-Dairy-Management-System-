package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entities.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	//Dependency : Repository level I/F
	@Autowired
	private EmployeeRepository empRepo;
	
	// dependency : model mapper
//	@Autowired
//	private ModelMapper mapper;

	@Override
	public List<Employee> getAllEmpDetails() {
		return empRepo.findAll();
	}

	@Override
	public Employee addEmpDetails(Employee transientEmp) {
		Employee persistentEmployee = null;
		try {
			persistentEmployee = empRepo.save(transientEmp);
		}catch(RuntimeException exception) {
			throw new ResourceNotFoundException("Error while Saving Employee with id " + transientEmp.getId()+ " !");
		}
		return persistentEmployee;
	}

	
	@Override
	public String deleteEmpDetails(Long empId) {
		if (empRepo.existsById(empId)) { //one way of handling exception
			 empRepo.deleteById(empId);
			 return "Employee with id "+ empId+ " got deleted successfully.";
		}
		throw new ResourceNotFoundException("Invalid Employee Id : Updation Failed!!!!!!!!");
	}

	@Override
	public Employee fetchEmpDetails(Long empId) {
		return empRepo.findById(empId)
			   .orElseThrow(() -> new ResourceNotFoundException("Invalid Employee ID !!!!!"));
	}
	
	@Override
	public Employee updateEmpDetails(Employee detachedEmp) {

		// confirm if emp with id exists !
		if (empRepo.existsById(detachedEmp.getId())) {
			return empRepo.save(detachedEmp);
		}
		
		throw new ResourceNotFoundException("Invalid Employee Id : Updation Failed!!!!!!!!");  //other way of handling exception
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public EmployeeSpecificResp authenticateEmp(LoginRequestDto dto) {
//		// TODO Auto-generated method stub
//		Employee employee = empRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
//				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
//		//=> success
//		return mapper.map(employee, EmployeeSpecificResp.class);
//		
//	}
//
//	@Override
//	public List<Employee> getEmpsByDateAndDept(LocalDate joinDate1, String dept1) {
//		// TODO Auto-generated method stub
//		return empRepo.findByJoinDateAfterAndDepartment(joinDate1, dept1);
//	}
//
//	@Override
//	public List<EmployeeResponse> getEmpsBySalary(double minSal, double maxSal) {

		// return empRepo.fetchEmpNamesBySalaryRange(minSal, maxSal);
		// OR simply send back List of DTO containing the properties , lifted from DB
		// Here a prog will have to do the conversion from Entity to DTO (later to be
		// done auto.)

//		return empRepo.fetchEmpNamesBySalaryRange(minSal, maxSal).//Stream<Emp>
//				map(e -> new EmployeeResponse(e.getFirstName(),e.getLastName())) //Stream<EmpResp>
//				.collect(Collectors.toList());
//		return empRepo.fetchEmpNamesBySalaryRange(minSal, maxSal).// Stream<Emp>
//				map(e -> mapper.map(e, EmployeeResponse.class)) // Entity --> DTO
//				.collect(Collectors.toList());
//
//	}

//	@Override
//	public List<Employee> getEmpsByLastNameContainingKey(String key) {
//		// TODO Auto-generated method stub
//		return empRepo.findByLastNameContaining(key);
//	}
//
//	@Override
//	public String applySalaryIncrement(EmpSalIncrementRequest dto) {
////		empRepo.findByDepartmentAndJoinDateBefore(dto.getDept(), 
////				dto.getSpecifiedDate())
////				.forEach(e -> e.setSalary(e.getSalary() + dto.getSalIncrement()));
////		// OR using JPQL update
//		int rows = empRepo.updateEmpSalary(dto.getSalIncrement(), dto.getDept(), dto.getSpecifiedDate());
//		return "Applied sal increment to "+rows+" emps!";
		
	//}

}
