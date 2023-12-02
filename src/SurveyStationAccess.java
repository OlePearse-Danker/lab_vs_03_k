import java.util.ArrayList;

public class SurveyStationAccess extends FileAccessViaBytes {
	private final int DATASET_LENGTH = 1002;
	private final int PRELIMINARIES = 211;
	private ArrayList<SurveyStation> surveyStations;
	private String data = "start";

	public SurveyStationAccess(String fileName) {
		super(fileName);
		surveyStations = new ArrayList<>();
		readSurveyStations();
		super.close();
	}

	public ArrayList<SurveyStation> getSurveyStations() {
		return surveyStations;
	}

	public int getNumberOfSurveyStationsOf(String federalState) {
		return 0;
	}

	public void readSurveyStations() {
		surveyStations = new ArrayList<SurveyStation>();
		try {
			this.readNBytes(PRELIMINARIES);
		} catch (Exception e) {

		}
		while (true) {
			try {
				data = this.readNBytes(DATASET_LENGTH);
				if (data != null) {
					String[] stationData = analyseString(data);

					// System.out.println(stationData[6]);

					SurveyStation ss = new SurveyStation(Short.parseShort(stationData[0]), stationData[1],
							stationData[2], Short.parseShort(stationData[3]), Double.parseDouble(stationData[4]),
							Double.parseDouble(stationData[5]), stationData[6], stationData[7]);

					surveyStations.add(ss);
				}
			} catch (Exception e) {
				System.out.println("Datei ist vollständig abgelesen");
				break;
			}
		}
	}

	private String[] analyseString(String s) {

		String[] result = new String[8];

		String item = s.substring(0, 6);
		result[0] = item.trim(); // id

		item = s.substring(6, 14);
		result[1] = item.trim(); // von Datum

		item = s.substring(15, 24);
		result[2] = item.trim(); // bis Datum

		item = s.substring(34, 38);
		result[3] = item.trim(); // höhe

		item = s.substring(39, 51);
		result[4] = item.trim(); // latitude

		item = s.substring(52, 60);
		result[5] = item.trim(); // longitude

		item = s.substring(61, 101);
		result[6] = item.trim(); // stationsname

		item = s.substring(102, 132);
		result[7] = item.trim(); // bundesland

		return result;
	}

	public int getNumberOfSurveyStations() {
		return surveyStations.size();
	}

	public SurveyStation findLowestStation() {
		if (surveyStations.isEmpty()) {
			return null;
		}

		SurveyStation lowestStation = surveyStations.get(0);

		for (SurveyStation station : surveyStations) {
			if (station.getAltitude() < lowestStation.getAltitude()) {
				lowestStation = station;
			}
		}
		return lowestStation;
	}

	public SurveyStation findHighestStation() {
		if (surveyStations.isEmpty()) {
			return null;
		}
		SurveyStation highestStation = surveyStations.get(0);

		for (SurveyStation station : surveyStations) {
			if (station.getAltitude() > highestStation.getAltitude()) {
				highestStation = station;
			}
		}
		return highestStation;
	}
	
	public SurveyStation findNorthernmostStation() {
		if (surveyStations.isEmpty()) {
			return null;
		}
		SurveyStation northernmostStation = surveyStations.get(0);

		for (SurveyStation station : surveyStations) {
			if (station.getLatitude() > northernmostStation.getLatitude()) {
				northernmostStation = station;
			}
		}
		return northernmostStation;
	}
	
	public SurveyStation findSouthernmostStation() {
	    if (surveyStations.isEmpty()) {
	        return null;
	    }
	    SurveyStation southernmostStation = surveyStations.get(0);

	    for (SurveyStation station : surveyStations) {
	        if (station.getLatitude() < southernmostStation.getLatitude()) {
	            southernmostStation = station;
	        }
	    }
	    return southernmostStation;
	}

	public SurveyStation findEasternmostStation() {
	    if (surveyStations.isEmpty()) {
	        return null;
	    }
	    SurveyStation easternmostStation = surveyStations.get(0);

	    for (SurveyStation station : surveyStations) {
	        if (station.getLongitude() > easternmostStation.getLongitude()) {
	            easternmostStation = station;
	        }
	    }
	    return easternmostStation;
	}

	public SurveyStation findWesternmostStation() {
	    if (surveyStations.isEmpty()) {
	        return null;
	    }
	    SurveyStation westernmostStation = surveyStations.get(0);

	    for (SurveyStation station : surveyStations) {
	        if (station.getLongitude() < westernmostStation.getLongitude()) {
	            westernmostStation = station;
	        }
	    }
	    return westernmostStation;
	}

}
	