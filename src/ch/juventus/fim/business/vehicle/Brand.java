package ch.juventus.fim.business.vehicle;

public enum Brand {
	Mercedes {
		@Override
		public String toString() {
			return "Mercedes";
		}
	},
	MAN {
		@Override
		public String toString() {
			return "MAN";
		}
	}
}
