import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SurveyStation extends Node<Short> implements Comparable<SurveyStation> {
	private short stationId;
	private Calendar startDate;
	private Calendar finishDate;
	private short altitude;
	private double latitude;
	private double longitude;
	private String stationName;
	private String federalState;

    public SurveyStation() {
        super((short) 0); // Provide a default value for the key
    }
	
	public SurveyStation(short stationId, String startDate, String finishDate, short altitude, double latitude, double longitude, String stationName, String federalState) {
	    super(stationId);
		this.stationId = stationId;
	    this.startDate = calendarFormatOf(startDate);
	    this.finishDate = calendarFormatOf(finishDate);
	    this.altitude = altitude;
	    this.latitude = latitude;
	    this.longitude = longitude;
	    this.stationName = stationName;
	    this.federalState = federalState;
	}
	
	public short getAltitude () {
		return altitude;
	}
	
	public double getLatitude () {
		return latitude;
	}
	
	public double getLongitude () {
		return longitude;
	}
	
	public String getStationName () {
		return stationName;
	}
	
	public Calendar calendarFormatOf(String sD) {
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	        Calendar c = Calendar.getInstance();
	        c.setTime(dateFormat.parse(sD));
	        return c;
	    } catch (Exception e) {
	        System.out.println("Fehler beim Parsen des Datums: " + e.getMessage());
	        return null;
	    }
	}
	
	
    @Override
    public int compareTo(SurveyStation other) {
        // You need to decide how you want to compare SurveyStation instances.
        // Here's an example comparing based on station ID.
        return Short.compare(this.stationId, other.stationId);
    }

}