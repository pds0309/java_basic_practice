package mvc.practice.service;

import java.util.List;

import mvc.practice.model.DeptDTO;

/*
 * CRUD 추상 메소드 정의 
 */
public interface DeptService {
		
	//select
	public List<DeptDTO> selectAll();
	
	//selectByDeptNo
	public DeptDTO selectByDeptNo(int deptNo);
	
	// insert
	public int insert(DeptDTO dto);
	
	// delete
	public int delete(int deptNo);
	
	// update
	public int update(DeptDTO dto);
}
