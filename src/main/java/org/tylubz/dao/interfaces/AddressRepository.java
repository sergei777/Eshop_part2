package org.tylubz.dao.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.tylubz.entity.AddressEntity;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface AddressRepository extends CrudRepository<AddressEntity,Integer> {
}
