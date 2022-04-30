package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserAddressRepository extends JpaRepository<AppUserAddress,Long> {

   List<AppUserAddress> findAppUserAddressesByAppUser_AppUserID(Long appUserID);

}
