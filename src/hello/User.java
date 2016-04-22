package hello;
import java.util.Set;

public class User{
	private boolean verify;//default false ||zrobie tak ze konstruktor admina ma mo¿liwoœæ dawac autoryzacje z automatu i verify tylko to niebezpieczne ktos inzynieria wsteczna i myk reflekcja i juz robi sobie hmmm zabezpieczyc to autoryzacja jakas
	private boolean autorization;//default false
	private boolean admin;//default false
	private int id;//not set in constructor || autoincrement by hibernate
	private int personId;//not set in constructor
	private String name;
	private String surname;
	private String committee;
	private int phone;
	private String mail;
	private Set<PracticesModel> practices;
	private Set<FunctionalityModel> functions;
	private Set<Account> account;
	private byte[] image;
	public User(User user){
		this.verify=user.verify;
		this.autorization=user.autorization;
		this.admin=user.admin;
		this.name=user.name;
		this.surname=user.surname;
		this.committee=user.committee;
		this.practices=user.practices;
		this.functions=user.functions;
		this.phone=user.phone;
		this.mail=user.mail;
		this.account=user.account;	
		this.image=user.image;
		this.personId=user.personId;
		this.id=user.id;
	}
	User(){}
	User(String name, String surname, String committee,int phone,String mail,Set<PracticesModel> practices,Set<FunctionalityModel> functions,Set<Account> account){
		this.verify=false;
		this.autorization=false;
		this.admin=false;
		this.name=name;
		this.surname=surname;
		this.committee=committee;
		this.practices=practices;
		this.functions=functions;
		this.phone=phone;
		this.mail=mail;
		this.account=account;
	}
	
	public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId= personId;
    }
	public boolean getVerify() {
        return verify;
    }
    public void setVerify(boolean verify) {
        this.verify = verify;
    }
    public boolean getAutorization() {
        return autorization;
    }
    public void setAutorization(boolean autorization) {
        this.autorization = autorization;
    }
    public boolean getAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getCommittee() {
        return committee;
    }
    public void setCommittee(String committee) {
        this.committee = committee;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public Set<PracticesModel> getPractices() {
        return practices;
    }
    public void setPractices(Set<PracticesModel> practices) {
        this.practices = practices;
    }
    public Set<FunctionalityModel> getFunctions() {
        return functions;
    }
    public void setFunctions(Set<FunctionalityModel> functions) {
        this.functions = functions;
    }
    public Set<Account> getAccount() {
        return account;
    }
    public void setAccount(Set<Account> account) {
        this.account = account;
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

}
