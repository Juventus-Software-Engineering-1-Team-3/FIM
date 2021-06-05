package ch.juventus.fim.persistance.staffdataaccess;

import java.util.Map;

public interface IStaffDAO {
	/**
	 * Key for reading staffId of a staff.
	 */
	public final static String STAFF_ID_KEY = "staffId";
	/**
	 * Key for reading staffType of a staff.
	 */
	public final static String STAFF_TYPE_KEY = "staffType";
	/**
	 * Key for reading name of a staff.
	 */
	public final static String STAFF_NAME_KEY = "name";
	/**
	 * Key for reading surname of a staff.
	 */
	public final static String STAFF_SURNAME_KEY = "surname";
	/**
	 * Key for reading phone of a staff.
	 */
	public final static String STAFF_PHONE_KEY = "phone";

	public void insertStaff(Map<String, String> staffData);

	public Map<String, String> selectStaff(int staffId);

}
