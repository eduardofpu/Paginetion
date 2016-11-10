package org.condominio.sj.backand.test.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.condominio.sj.backand.permission.PermissionEntity;
import org.condominio.sj.backand.permission.PermissionRepository;
import org.condominio.sj.backand.test.utils.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PermissionRepositoryTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Autowired
	private PermissionRepository permissionRepository;

	@Test
	public void findAllTest() {
		List<PermissionEntity> permissions = this.permissionRepository.findAll();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Test FindAll(): " + permissions);
		}
	}

}
