package xxx.service.serviceImpl;

import com.czz.entity.Payment;

import org.springframework.stereotype.Service;
import xxx.dao.PaymentDao;
import xxx.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
