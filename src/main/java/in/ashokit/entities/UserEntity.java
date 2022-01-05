package in.ashokit.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "USER_DTLS")
@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "USER_FIRST_NAME")
	private String userFname;

	@Column(name = "USER_LAST_NAME")
	private String userLname;

	@Column(name = "USER_EMAIL", unique = true)
	private String userEmail;

	@Column(name = "USER_PHNO")
	private Integer userPhone;

	@Column(name = "USER_DOB")
	private Date userDob;

	@Column(name = "USER_GENDER")
	private String userGender;

	@Column(name = "USER_COUNTRY")
	private Integer userCounrty;

	@Column(name = "USER_STATE")
	private Integer userState;

	@Column(name = "USER_CITY")
	private Integer userCity;

	@Column(name = "USER_PWD")
	private String userPassword;

	@Column(name = "USER_ACC_STATUS")
	private String userAccountStatus;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
}
