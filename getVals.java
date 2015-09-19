	static MuseOscServer museOscServer;
	
	OscP5 museServer;
	static int recvPort = 5000;

	public static void main(String [] args) {
		museOscServer = new MuseOscServer();
		museOscServer.museServer = new OscP5(museOscServer, recvPort);
			}
	
	float[] oscEvent(OscMessage msg) {
		System.out.println("### got a message " + msg);
		ArrayList <Float> list = new ArrayList<Float>();
		if (msg.checkAddrPattern("/muse/eeg")==true) {  
			for(int i = 0; i < 4; i++) {
				list.add(msg.get(i).floatValue()); 
			}
		} 
		return list
	}