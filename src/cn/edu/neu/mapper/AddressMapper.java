package cn.edu.neu.mapper;

import java.util.List;

import cn.edu.neu.model.Address;

public interface AddressMapper {

	List<Address> getAddrByUserId(int loginUserId);

	void addAddress(Address address);

	void updateAddress(Address address);

	void deleteAddress(String addrId);

	void setDefaultAddress(String addrId);

	void unsetDefaultAddress(int loginUserId);

	Address getAddressById(String addrId);

}
