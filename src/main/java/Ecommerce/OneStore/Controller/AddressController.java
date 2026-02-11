package Ecommerce.OneStore.Controller;

import Ecommerce.OneStore.Model.Address;
import Ecommerce.OneStore.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/api/address")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        try {
            Address a = addressService.addAddress(address);
            if (a!=null){
                return new ResponseEntity<>(a, HttpStatus.CREATED);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("api/address")
    public ResponseEntity<List<Address>> getAllAddress(){
        try{
            List<Address> a = addressService.getAllAddress();
            if(a!=null){
                return new ResponseEntity<>(a,HttpStatus.OK);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("api/address/{addressId}")
    public ResponseEntity<Address> getAddress(@PathVariable Long addressId){
        try {
            Address a = addressService.getAddressById(addressId);
            if(a!=null){
                return new ResponseEntity<>(a,HttpStatus.OK);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("api/address/{addressId}")
        public ResponseEntity<Address> updateAddress(@PathVariable Long addressId,@RequestBody Address address){
        try{
            Address a = addressService.updateAddress(addressId,address);
            if(a!=null){
                return new ResponseEntity<>(a,HttpStatus.OK);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
