/**
 * Staff Type enumeration with their values
 */

package ch.juventus.fim.business.staff;

public enum StaffType {
	Driver {
		@Override
		public String toString() {
			return "Driver";
		}
	},
	Mechanic {
		@Override
		public String toString() {
			return "Mechanic";
		}
	},
}
