package Ecommerce.OneStore.Service;

import Ecommerce.OneStore.Model.Address;

import java.util.List;

public interface AddressService {
    Address addAddress(Address address);
    List<Address> getAllAddress();
    Address getAddressById(Long id);
    Address updateAddress(Long id,Address address);
    Boolean deleteAddress(Long id);
}
