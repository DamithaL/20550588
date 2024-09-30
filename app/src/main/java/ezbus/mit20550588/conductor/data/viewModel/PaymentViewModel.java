package ezbus.mit20550588.conductor.data.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.Map;

import ezbus.mit20550588.conductor.data.model.PayHereRequest;
import ezbus.mit20550588.conductor.data.model.TicketOrder;
import ezbus.mit20550588.conductor.data.network.ApiServiceBus;
import ezbus.mit20550588.conductor.data.network.ApiServicePayment;
import ezbus.mit20550588.conductor.data.network.PaymentStatusResponse;
import ezbus.mit20550588.conductor.data.network.RetrofitClient;
import ezbus.mit20550588.conductor.data.network.TicketRedemptionStatus;
import ezbus.mit20550588.conductor.data.repository.PaymentRepository;
import ezbus.mit20550588.conductor.data.repository.TicketRepository;

public class PaymentViewModel extends ViewModel {

    private PaymentRepository paymentRepository;
    private LiveData<String> errorLiveData;

    private LiveData<PayHereRequest> ticketOrderLiveData;

    private LiveData<PaymentStatusResponse> paymentStatusLiveData;

    private LiveData<TicketRedemptionStatus> ticketRedemptionStatus;

    // Constructor to initialize the repository
    public PaymentViewModel() {
        this.paymentRepository = new PaymentRepository(new RetrofitClient().getClient().create(ApiServicePayment.class));
        this.ticketOrderLiveData = paymentRepository.getTicketOrderLiveData();
        this.errorLiveData = paymentRepository.getErrorLiveData();
        this.ticketOrderLiveData = paymentRepository.getTicketOrderLiveData();
        this.paymentStatusLiveData = paymentRepository.getPaymentStatusLiveData();
        this.ticketRedemptionStatus = paymentRepository.getTicketRedemptionStatusLiveData();
    }

    // Existing constructor for dependency injection
    public PaymentViewModel(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        this.ticketOrderLiveData = paymentRepository.getTicketOrderLiveData();
        this.errorLiveData = paymentRepository.getErrorLiveData();
        this.paymentStatusLiveData = paymentRepository.getPaymentStatusLiveData();
        this.ticketRedemptionStatus = paymentRepository.getTicketRedemptionStatusLiveData();
    }


    public LiveData<PayHereRequest> getTicketOrderLiveData() {
        return ticketOrderLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public LiveData<PaymentStatusResponse> getPaymentStatusLiveData() {
        return paymentStatusLiveData;
    }

    public LiveData<TicketRedemptionStatus> getTicketRedemptionStatus() {
        return ticketRedemptionStatus;
    }

    public void validateTicketOrder(TicketOrder ticket) {

        paymentRepository.validateTicketOrder(ticket);
    }

    public void notifyPayment(Map<String, Object> notifyPaymentRequest) {
        paymentRepository.notifyPayment(notifyPaymentRequest);
    }

    public void notifyPaymentCancel(Map<String, Object> notifyPaymentRequest) {
        paymentRepository.notifyPaymentCancel(notifyPaymentRequest);
    }

    public void isTicketRedeemed(Map<String, Object> checkRedeemStatusRequest) {
        paymentRepository.isTicketRedeemed(checkRedeemStatusRequest);
    }


}
