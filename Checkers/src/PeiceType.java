
public enum PeiceType {
	RED(1), WHITE(-1);
	
	final int moveDir;
	
	PeiceType(int moveDir) {
		this.moveDir = moveDir;
	}
}
