package com.lapitus.mysbdemo.repositories;

import com.lapitus.mysbdemo.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
