package ch.juventus.fim.business.logentry;

public enum OilLevel {
	TooHigh {
		@Override
		public String toString() {
			return "Too high";
		}
	},
	TooLow {
		@Override
		public String toString() {
			return "Too low";
		}
	},
	Good {
		@Override
		public String toString() {
			return "Good";
		}
	}
}
