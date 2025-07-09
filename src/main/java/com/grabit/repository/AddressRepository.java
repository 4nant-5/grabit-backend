package com.grabit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabit.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
