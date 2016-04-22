package hello;
public class Account {
	private int id;
	private int personId;
	private String login;
	private String password;
	Account(){}
	Account(String login,String password){
		this.login=login;
		this.password=password;
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password= password;
    }

}
