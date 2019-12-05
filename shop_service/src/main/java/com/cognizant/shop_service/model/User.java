package com.cognizant.shop_service.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class User 
{
	@Id
	//@NotNull
	//@Size(min=2,max=50,message="User Id should be between 2 and 50 characters")
	@Column(name="us_userid")
	private String userId;
	//@NotNull
	//@Size(min=2,max=50,message="First Name should be between 2 and 50 characters")
	@Column(name="us_first_name")
	private String firstname;
	//@NotNull
	//@Size(min=2,max=50,message="Last Name should be between 2 and 50 characters")
	@Column(name="us_last_name")
	private String lastname;
	//@NotNull
	//@Size(min=2,max=3,message="Age should be between 2 and 3 characters")
	@Column(name="us_age")
	private int age;
	//@NotNull
	//@Size(min=6,max=10,message="Gender should be between 6 and 10 characters")
	@Column(name="us_gender")
	private String gender;
	//@NotNull
	//@Size(min=10,max=10,message="Contact number should be 10 characters")
	@Column(name="us_contact_number")
	private long contactNumber;
	//@NotNull
	//@Size(min=2,max=50,message="User Id should be between 2 and 50 characters")
	@Column(name="us_password")
	private String password;
	//@NotNull
	//@Size(min=1,max=1,message="User Id should be 1characters")
	@Column(name="us_user_type")
	private	String userType;
	//@Size(max=1,message="status should be 1 characters")
	@Column(name="us_status")
	private String status;
	//@Size(min=2,max=50,message="should be between 2 and 50 characters")
	@Column(name="us_ques1")
	private String question1;
	//@Size(min=2,max=50,message="should be between 2 and 50 characters")
	@Column(name="us_ans1")
	private String answer1;
	//@Size(min=2,max=50,message="should be between 2 and 50 characters")
	@Column(name="us_ques2")
	private String question2;
	//@Size(min=2,max=50,message="should be between 2 and 50 characters")
	@Column(name="us_ans2")
	private String answer2;
	///@Size(min=2,max=50,message="should be between 2 and 50 characters")
	@Column(name="us_ques3")
	private String question3;
	//@Size(min=2,max=50,message="should be between 2 and 50 characters")
	@Column(name="us_ans3")
	private String answer3;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
    private Set<Role> roleList;
	
	public Set<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private Set<Purchase> purchases;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}
	
	public Set<Purchase> getPurchaseList() {
		return purchases;
	}
	public void setPurchaseList(Set<Purchase> purchaseList) {
		this.purchases = purchaseList;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String userId, String firstname, String lastname, int age, String gender, long contactNumber,
			String password, String userType, String status, String question1, String answer1, String question2,
			String answer2, String question3, String answer3) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.password = password;
		this.userType = userType;
		this.status = status;
		this.question1 = question1;
		this.answer1 = answer1;
		this.question2 = question2;
		this.answer2 = answer2;
		this.question3 = question3;
		this.answer3 = answer3;
	}
	/*@Override
	public String toString() {
		return "User [ firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", contactNumber=" + contactNumber + ", userId=" + userId + ", password=" + password
				+ ", userType=" + userType + ", status=" + status + ", question1=" + question1 + ", answer1=" + answer1
				+ ", question2=" + question2 + ", answer2=" + answer2 + ", question3=" + question3 + ", answer3="
				+ answer3 + ", roleList=" + roleList + "]";
	}*/
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", password=" + password + ", userType="
				+ userType + ", status=" + status + ", question1=" + question1 + ", answer1=" + answer1 + ", question2="
				+ question2 + ", answer2=" + answer2 + ", question3=" + question3 + ", answer3=" + answer3
				+ ", roleList=" + roleList +  "]";
	}

	
	
	
}
