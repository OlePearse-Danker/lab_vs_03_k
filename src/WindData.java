import java.text.SimpleDateFormat;
	import java.util.Calendar;

	public class WindData {
		
		private short stationId;
		private Calendar date;
		private byte quality;
		private double speed;
		private double direction;
		
		public WindData (short stationId, String date, byte quality, double speed, double direction ) {
			this.stationId = stationId;
			this.date = calendarFormatOf(date);
			this.quality = quality;
			this.speed = speed;
			this.direction = direction;
			
			
			// prints out all the read in data
			// System.out.println(stationId + ", " + date + ", " + quality + ", " + speed + ", " + direction);
			
		}
		
	    public Calendar calendarFormatOf(String sD) {

			try {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	            Calendar c = Calendar.getInstance();
	            c.setTime(dateFormat.parse(sD));

	            return c;
	        } catch (Exception e) {
	        	System.out.println("Datum konnte nicht verarbeitet werden!");
	        }
			
			return null;
		}
	    
	    public double getDirection() {
	    	return direction;
	    }
	    
	    public double getSpeed() {
	    	return speed;
	    }
	    
		
	}
