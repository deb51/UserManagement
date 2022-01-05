package in.ashokit.bindings;

import java.util.Date;

import lombok.Data;


@Data
public class UserBinding {

	private Integer userId;

	private String userFname;

	private String userLname;

	private String userEmail;

	private Integer userPhone;

	private Date userDob;

	private String userGender;

	private Integer userCounrty;

	private Integer userState;

	private Integer userCity;

	private String userPassword;

	private String userAccountStatus;

	private Date createdDate;

	private Date updatedDate;
}
