import java.util.ArrayList;

public class WindDataAccess extends FileAccessViaBytes{
	
	private final int DATASET_LENGTH = 48;
	private final int PRELIMINARIES  = 43;
	private ArrayList<WindData> data;
	private int windDataCounter = 0;
	private double averageDirection = 0;
	private double averageSpeed = 0;
	double directionSum = 0;
	double speedSum = 0;
	int highWindCount = 0;
	private int negativeNumbersCount = 0;
	

	
	public WindDataAccess(String fileName) {
		 super(fileName);
		 readWindData();
		 averageDirection = calculateAverage(data, "direction");
		 averageSpeed = calculateAverage(data, "speed");
		 highWindCount = calculateHighWindSpeeds(data);
		 super.close();
	}
	
	public void readWindData() {
		data = new ArrayList<WindData>();
		
		try {
			this.readNBytes(PRELIMINARIES);
		} catch (Exception e) {
			
		}
		
		
		String buffer = "";
		
		while (true) {
	
			try {
				buffer = this.readNBytes(DATASET_LENGTH);
			
				if (buffer != null) {
					String[] windData = buffer.split(";");
					
					// short stationId, String date, byte quality, double speed, double direction

					WindData wd = new WindData(
							Short.parseShort(windData[0].trim()),
							windData[1].trim(),
							Byte.parseByte(windData[2].trim()),
							Double.parseDouble(windData[3].trim()),
							Double.parseDouble(windData[4].trim())
							);
					
					data.add(wd);
					windDataCounter++;
				}
			} catch (Exception e) {
				// System.err.println("I really like potatoes!");
				break;
			}
		}
	}
	
	
	public int getwindDataCount() {
		return windDataCounter;
	}
	
	
	public double calculateAverage(ArrayList<WindData> data, String averageOf) {
		
	
		if(averageOf == "direction") {
			
			for (int i = 0; i < data.size(); i++) {
				WindData wd = data.get(i);
				double direction = wd.getDirection();
				
					if (wd.getDirection() < 0) {
						negativeNumbersCount++;
						continue;
					}
				
				directionSum += direction;
			}
			
			averageDirection = (directionSum / (windDataCounter - negativeNumbersCount));
			    
			return averageDirection;
			
		}else if(averageOf == "speed") {
			
			for (int i = 0; i < data.size(); i++) {
				WindData wd = data.get(i);
				double speed = wd.getSpeed();
				
					if (wd.getSpeed() < 0) {
						negativeNumbersCount++;
						continue;
					}
				
				speedSum += speed;
			}
			
			averageSpeed = (speedSum / ( windDataCounter - negativeNumbersCount));
			    
			return averageSpeed;
			
		}else {
			
			System.out.println("Geben Sie bitte eine gültigen String als Argument");
			return 1;
		}
		
		
		
	}
	
	public double getAverage(String averageOf) {
		
		if(averageOf == "direction") {
			return averageDirection;
			
		}else if (averageOf == "speed") {
			return averageSpeed;
			
		}else {
			System.out.println("Geben Sie bitte eine gültigen String als Argument");
			return 1;
		}

	}
	
	public int calculateHighWindSpeeds(ArrayList<WindData> data) {
		
		for (int i = 0; i < data.size(); i++) {
			
			WindData wd2 = data.get(i);
			
				if (12 <= wd2.getSpeed() && wd2.getSpeed() <= 14) {
					highWindCount++;
				}
		}
		return highWindCount;
	}
	
	public int getHighWindCount() {
		return highWindCount;
	}	
	
	

}