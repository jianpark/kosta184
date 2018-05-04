package ex0503.dao;

import java.util.List;

import ex0503.dto.CustomerDTO;

public interface CustomerDAO {

	/**
	 * ID �ߺ�üũ
	 * @return : �ߺ��Դϴ� / ��밡���մϴ�.
	 */
	String inCheck(String id);
	
	/**
	 * Customer ���
	 */
	int insert(CustomerDTO customerDTO);
	
	/**
	 * ��ü�˻�
	 */
	List<CustomerDTO> selectAll();
	
	/**
	 * Customer ����
	 */
	int update(CustomerDTO customerDTO);
	
	/**
	 * Customer����
	 */
	int delete(String id);
}
