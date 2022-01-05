package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import in.ashokit.bindings.UserBinding;
import in.ashokit.entities.CityEntity;
import in.ashokit.entities.CountryEntity;
import in.ashokit.entities.StateEntity;
import in.ashokit.entities.UserEntity;
import in.ashokit.repositories.CityRepository;
import in.ashokit.repositories.CountryRepository;
import in.ashokit.repositories.StateRepository;
import in.ashokit.repositories.UserRepository;

public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CityRepository cityRepo;

	@Override
	public boolean uniqueEmail(String email) {

		UserEntity userEntity = userRepo.findByUserEmail(email);
		if (userEntity == null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Map<Integer, String> getCountries() {
		List<CountryEntity> findAll = countryRepo.findAll();
		Map<Integer, String> countryMap = new HashMap<Integer, String>();
		for (CountryEntity entity : findAll) {
			countryMap.put(entity.getCountryId(), entity.getCountryName());
		}
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {

		List<StateEntity> statesList = stateRepo.findByCountryId(countryId);

		Map<Integer, String> stateMap = new HashMap<Integer, String>();

		for (StateEntity entity : statesList) {

			stateMap.put(entity.getStateId(), entity.getStateName());
		}
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {

		List<CityEntity> citiesList = cityRepo.findByStateId(stateId);

		Map<Integer, String> cityMap = new HashMap<Integer, String>();

		for (CityEntity entiry : citiesList) {
			cityMap.put(entiry.getCityId(), entiry.getCityName());
		}

		return cityMap;
	}

	@Override
	public boolean registerUser(UserBinding user) {

		// TODO generate random password
		user.setUserPassword(generatePassword());
		user.setUserAccountStatus("LOCKED");

		// copy data from binding to entity
		UserEntity entity = new UserEntity();

		BeanUtils.copyProperties(user, entity);

		UserEntity save = userRepo.save(entity);

		if (save.getUserId() != null) {
			return sendRegEmail(user);
		}
		return false;
	}

	private String generatePassword() {
		String tempPwd = null;
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 6;
		java.util.Random random = new java.util.Random();

		tempPwd = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return tempPwd;
	}

	private boolean sendRegEmail(UserBinding user) {
		boolean emailSent = false;

		return emailSent;
	}

}
