package prasad.beans;

public class Bean_surey implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private String date;
    private String like;
    private String know;
    private String recommend;
    private String raffle;
    private String comment;
    private Double stand_dev;
	 private Double mean;
	 
	 int [] survey_data;

	 public int[] getsurvey_data() {
	 	return survey_data;
	 }

	 public void setsurvey_Data(int[] survey_data) {
	 	this.survey_data = survey_data;
	 }

	 
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getKnow() {
		return know;
	}
	public void setKnow(String know) {
		this.know = know;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		
		this.raffle = raffle;
		
		
		
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Double getStand_dev() {
		return stand_dev;
	}
	public void setStand_dev(Double stand_dev) {
		this.stand_dev = stand_dev;
	}
	public Double getMean() {
		return mean;
	}
	public void setMean(Double mean) {
		this.mean = mean;
	}

	

}
