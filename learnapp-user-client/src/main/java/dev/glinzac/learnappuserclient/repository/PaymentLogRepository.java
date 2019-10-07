package dev.glinzac.learnappuserclient.repository;

import dev.glinzac.learnappuserclient.entities.PaymentLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PaymentLogRepository extends CrudRepository<PaymentLog,Integer> {

    @Query(value = "select * from payment_log",nativeQuery = true)
    List<PaymentLog> getPaymentLog();
}
