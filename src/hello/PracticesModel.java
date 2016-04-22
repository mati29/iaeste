package hello;
public class PracticesModel {
	private int id;//not set in constructor || autoincrement by hibernate
	private int personId;
	private String country;
	private String city;
	private String firm;
	private String degreeCourse;
	private String startDate;
	private String endDate;
	private String description;
	
	PracticesModel(){}
	PracticesModel(String country,String startDate,String endDate,String city,String firm,String degreeCourse,String description){
		this.country=country;
		this.startDate=startDate;
		this.endDate=endDate;
		this.city=city;
		this.description=description;
		this.degreeCourse=degreeCourse;
		this.firm=firm;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country= country;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate= startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate= endDate;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city= city;
    }
    public String getDegreeCourse() {
        return degreeCourse;
    }
    public void setDegreeCourse(String degreeCourse) {
        this.degreeCourse= degreeCourse;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description= description;
    }
    public String getFirm() {
        return firm;
    }
    public void setFirm(String firm) {
        this.firm= firm;
    }
}
