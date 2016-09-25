package org.tylubz.dao.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.tylubz.entity.AddressEntity;

/**
 * Created by Sergei on 25.09.2016.
 */
public interface CustomerRepository extends CrudRepository<AddressEntity,Integer> {
}
