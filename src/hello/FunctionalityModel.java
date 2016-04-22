package hello;

public class FunctionalityModel {
	private int id;//not set in constructor || autoincrement by hibernate
	private int personId;
	private String function;
	private String started;
	private String finished;
	
	FunctionalityModel(){}
	FunctionalityModel(String function,String started,String finished){
		this.function=function;
		this.started=started;
		this.finished=finished;
	}
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
	public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId= personId;
    }
    public String getFunction() {
        return function;
    }
    public void setFunction(String function) {
        this.function= function;
    }
    public String getStarted() {
        return started;
    }
    public void setStarted(String started) {
        this.started= started;
    }
    public String getFinished() {
        return finished;
    }
    public void setFinished(String finished) {
        this.finished= finished;
    }
    public String toString(){
    	return started+function+finished;
    }

}
