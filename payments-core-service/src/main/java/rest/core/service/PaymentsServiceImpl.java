package rest.core.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import rest.core.model.PaymentDetail;
import rest.core.model.PaymentDetailCollection;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	@Override
	public PaymentDetailCollection getPaymentDetails(String accountNumber) {
		
		PaymentDetailCollection paymentDetail = new PaymentDetailCollection();
		paymentDetail.setAccountNumber(accountNumber);
		paymentDetail.setLastPaymentAmount(100);
		paymentDetail.setLastPaymentDate(new Date());
		
		paymentDetail.setPaymentDetails(this.getPaymentDetailsAsList());
		
		return paymentDetail;
	}
	
	private List<PaymentDetail> getPaymentDetailsAsList(){
		List<PaymentDetail> paymentDetails = Arrays.asList(
			new PaymentDetail(10, 20, new Date()),
			new PaymentDetail(11, 22, new Date()),
			new PaymentDetail(12, 23, new Date()));
		
		return paymentDetails;
	}
}
