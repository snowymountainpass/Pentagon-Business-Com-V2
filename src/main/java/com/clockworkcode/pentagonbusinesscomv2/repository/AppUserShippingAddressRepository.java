package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUserShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserShippingAddressRepository extends JpaRepository<AppUserShippingAddress,Long> {

    List<AppUserShippingAddress> getAppUserShippingAddressesByAppUser_AppUserID(Long appUserID);

}
