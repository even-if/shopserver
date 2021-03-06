package cn.edu.neu.service;

import java.util.List;

import cn.edu.neu.model.Address;

public interface AddressService {

	List<Address> getAddressByUserId(int loginUserId);

	Address addAddress(Address address);

	void updateAddress(Address address);

	void deleteAddress(String addrId);

	void setDefaultAddress(String addrId, int loginUserId);

	Address getAddressById(String addrId);

}
