package case_study_furama.models;

import java.util.Objects;

public class Contract {
    private String contractNumber;// ma hop dong
    private String bookingHorse;// ma booking
    private String predepositAmount; // so tien coc truoc
    private String sumMoneyPay; // tong so tien thanh toan
    private String guestHorse; // ma khach hang

    public Contract() {
    }

    public Contract(String contractNumber, String bookingHorse, String predepositAmount, String sumMoneyPay, String guestHorse) {
        this.contractNumber = contractNumber;
        this.bookingHorse = bookingHorse;
        this.predepositAmount = predepositAmount;
        this.sumMoneyPay = sumMoneyPay;
        this.guestHorse = guestHorse;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingHorse() {
        return bookingHorse;
    }

    public void setBookingHorse(String bookingHorse) {
        this.bookingHorse = bookingHorse;
    }

    public String getPredepositAmount() {
        return predepositAmount;
    }

    public void setPredepositAmount(String predepositAmount) {
        this.predepositAmount = predepositAmount;
    }

    public String getSumMoneyPay() {
        return sumMoneyPay;
    }

    public void setSumMoneyPay(String sumMoneyPay) {
        this.sumMoneyPay = sumMoneyPay;
    }

    public String getGuestHorse() {
        return guestHorse;
    }

    public void setGuestHorse(String guestHorse) {
        this.guestHorse = guestHorse;
    }

    @Override
    public String toString() {
        return "|ContractNumber = " + contractNumber +
                "|BookingHorse = " + bookingHorse +
                "|PredepositAmount = " + predepositAmount +
                "|SumMoneyPay = " + sumMoneyPay +
                "|GuestHorse = " + guestHorse + "|";
    }

    public String getInfoToCsv() {
        return contractNumber + "," + bookingHorse + "," + predepositAmount + "," + sumMoneyPay + "," + guestHorse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(contractNumber, contract.contractNumber) && Objects.equals(bookingHorse, contract.bookingHorse) && Objects.equals(predepositAmount, contract.predepositAmount) && Objects.equals(sumMoneyPay, contract.sumMoneyPay) && Objects.equals(guestHorse, contract.guestHorse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractNumber, bookingHorse, predepositAmount, sumMoneyPay, guestHorse);
    }
}
