package Ecommerce.OneStore.ServiceImpl;

import Ecommerce.OneStore.Model.Address;
import Ecommerce.OneStore.Repository.AddressRepo;
import Ecommerce.OneStore.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressImpl implements AddressService {

    @Autowired
    private AddressRepo arepo;

    @Override
    public Address addAddress(Address address){
        return arepo.save(address);
    }

    @Override
    public Address updateAddress(Long id,Address address) {
        if(arepo.existsById(id)){
            address.setAddressId(id);
            return arepo.save(address);
        }
        return null;
    }

    @Override
    public List<Address> getAllAddress() {
        return arepo.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return arepo.findById(id).get();
    }

    @Override
    public Boolean deleteAddress(Long id) {
        if(arepo.existsById(id)){
            return true;
        }
        return false;
    }
}
