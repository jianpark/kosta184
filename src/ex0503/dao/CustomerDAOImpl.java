package ex0503.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ex0503.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public String inCheck(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id from customer where id =?";
		String idCheck="멋진 id네요";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();			

			while(rs.next()) {
				idCheck = "중복된 아이디예요"; 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}	
		return idCheck;
	}

	@Override
	public int insert(CustomerDTO customerDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;
		String sql="insert into customer values(?,?,?,?,?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, customerDTO.getId());
			ps.setString(2, customerDTO.getName());
			ps.setInt(3, customerDTO.getAge());
			ps.setString(4, customerDTO.getPhone());
			ps.setString(5, customerDTO.getAddr());
			
			re = ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}	
		return re;
	}

	@Override
	public List<CustomerDTO> selectAll() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		String sql="select * from customer";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CustomerDTO dto = new CustomerDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				
				System.out.println(rs.getString(1));
				
				list.add(dto);
			}		        
		   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public int update(CustomerDTO customerDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;
		String sql="update customer set NAME =?,age=?, tel=?,addr=? where id = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, customerDTO.getName());
			ps.setInt(2, customerDTO.getAge());
			ps.setString(3, customerDTO.getPhone());
			ps.setString(4, customerDTO.getAddr());
			ps.setString(5, customerDTO.getId());
			
			re = ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}	
		return re;
	}

	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;
		String sql="delete from customer where id=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			re = ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}	
		return re;
		
	}

}
