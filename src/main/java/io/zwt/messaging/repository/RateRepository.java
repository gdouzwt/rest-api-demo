package io.zwt.messaging.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.zwt.messaging.domain.Rate;

public interface RateRepository  extends JpaRepository<Rate,String>{
		List<Rate> findByDate(Date date);
		Rate findByDateAndCode(Date date,String code);
}