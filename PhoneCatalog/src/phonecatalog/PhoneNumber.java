package phonecatalog;

/**
 *
 * @author Max
 */
public class PhoneNumber {
    
    private String countryCode;
    private String cityCode;
    private String number;

    public PhoneNumber() {
        countryCode = "+7";
        cityCode = "(812)";
    }

    
    public PhoneNumber(String countryCode, String cityCode, String number) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    
}
