package com.iyurenko.client.config.jpa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author iyurenko
 * @since 08.04.16.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.iyurenko.client.dao.repository")
public class JpaConfig {
}
