package ch.juventus.fim.persistance.staffdataaccess;

import java.util.Map;

public interface IStaffDAO {

	public void insertStaff(Map<String, String> staffData);

	public Map<String, String> selectStaff(int staffId);

}
